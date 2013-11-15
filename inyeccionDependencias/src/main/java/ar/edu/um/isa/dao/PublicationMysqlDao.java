package ar.edu.um.isa.dao;

import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import ar.edu.um.isa.dao.rowmapper.PublicationRowMapper;
import ar.edu.um.isa.model.Publication;
import ar.edu.um.isa.model.Publisher;
import ar.edu.um.isa.model.Tag;

public class PublicationMysqlDao implements PublicationDao {
	
	private static Logger log = Logger.getLogger(PublicationMysqlDao.class);
	
	private JdbcTemplate jdbcTemplate;

	private Iterator ittag,itmen;
	
	private Tag tagaux;
	private Publisher publisheraux;
	
	public void insertPublication(Publication publication){
		
		String sql = "INSERT INTO Publication (idPublisher, date, content) " + 
				"VALUES (?, ?, ?)";
				Object[] params = new Object[] {publication.getPublisher().getIdPublisher(), publication.getDate(), publication.getContent()};
				int[] types = new int[]{Types.INTEGER, Types.DATE, Types.VARCHAR};
				PreparedStatementCreatorFactory psc = new PreparedStatementCreatorFactory(sql,types);
				psc.setGeneratedKeysColumnNames(new String[] {"idPublication"});
				KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
				int result = this.getJdbcTemplate().update(psc.newPreparedStatementCreator(params),generatedKeyHolder);
				if (result != 1) {
					//System.out.println("Error insertando publicacion en MySql");
					log.error("Error insertando publicacion en MySql");
				}
				publication.setIdPublication(generatedKeyHolder.getKey().intValue());
			//------------------------Guardar Tags------------------------------------------				
				ittag = publication.getTags().iterator();
				while(ittag.hasNext()){
					String sqltag = "INSERT INTO PublicationTag (idPublication, idTag) " + 
							"VALUES (?, ?)";
					tagaux = (Tag) ittag.next();
					Object[] paramstag = new Object[] {publication.getIdPublication(), tagaux.getIdTag()};
					int[] typestag = new int[]{Types.INTEGER, Types.INTEGER};
					PreparedStatementCreatorFactory psc2 = new PreparedStatementCreatorFactory(sqltag,typestag);
					psc2.setGeneratedKeysColumnNames(new String[] {"idPublicationTag"});
					KeyHolder generatedKeyHolderTag = new GeneratedKeyHolder();
					int resultTag = this.getJdbcTemplate().update(psc2.newPreparedStatementCreator(paramstag),generatedKeyHolderTag);
					if (resultTag != 1) {
						//System.out.println("Error insertando publicacion en MySql");
						log.error("Error insertando publicationTag en MySql");
					}
					log.debug("Se inserto la publicationTag correctamente");
				}
			//------------------------Guardar Mentions---------------------------------------------------
				itmen = publication.getMentions().iterator();
				while(itmen.hasNext()){
					String sqlmen = "INSERT INTO Mention (idPublication, idPublisher) " + 
							"VALUES (?, ?)";
					publisheraux = (Publisher) itmen.next();
					Object[] paramsmen = new Object[] {publication.getIdPublication(), publisheraux.getIdPublisher()};
					int[] typesmen = new int[]{Types.INTEGER, Types.INTEGER};
					PreparedStatementCreatorFactory psc3 = new PreparedStatementCreatorFactory(sqlmen,typesmen);
					psc3.setGeneratedKeysColumnNames(new String[] {"idMention"});
					KeyHolder generatedKeyHolderMen = new GeneratedKeyHolder();
					int resultMen = this.getJdbcTemplate().update(psc3.newPreparedStatementCreator(paramsmen),generatedKeyHolderMen);
					if (resultMen != 1) {
						//System.out.println("Error insertando publicacion en MySql");
						log.error("Error insertando Mention en MySql");
					}
					log.debug("Se inserto la Mention correctamente");
				}
				log.debug("Se inserto la publicacion correctamente");
	}

	public List<Publication> findPublicationByPublisher(Publisher publisher) {		
		String sql;
		Object[] params;
		int[] types;
		sql = "SELECT * FROM Publication WHERE idPublisher=?";
		params = new Object[]{publisher.getIdPublisher()};
		types=new int[]{Types.INTEGER};
		List<Publication> publications = this.getJdbcTemplate().query(sql, params, types, new PublicationRowMapper());
		if(publications.size() == 0) {
			log.warn("No existen publicaciones para ese usuario");
			return null;
		}
		return publications;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void deletePublication(Publication publication) {
		String sql;
		Object[] params;
		int[] types;
		sql = "DELETE FROM Publication WHERE idPublication=?";
		params = new Object[]{publication.getIdPublication()};
		types = new int[]{Types.INTEGER};
		this.getJdbcTemplate().update(sql, params, types);
		
	}

	public List<Publication> findPublicationsByTag(Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Publication> findPublicationsByMention(Publisher publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	public void republish(Publication publication) {
		// TODO Auto-generated method stub
		
	}
	public List<Publication> findFollowingPublications(Publisher publisher) {
		String sql;
		Object[] params;
		int[] types;
		sql = "SELECT publication.idPublisher, publication.idPublication, publication.date, publication.content FROM followers INNER JOIN publication ON publication.idPublisher=followers.idFollowed WHERE idFollower=?";
		params = new Object[]{publisher.getIdPublisher()};
		types=new int[]{Types.INTEGER};
		List<Publication> publications = this.getJdbcTemplate().query(sql, params, types, new PublicationRowMapper());
		if(publications.size() == 0) {
			log.warn("No hay mensajes para mostrar");
			return null;
		}
		return publications;
	
	}

}
