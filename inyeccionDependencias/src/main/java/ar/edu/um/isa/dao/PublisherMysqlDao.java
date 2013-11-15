package ar.edu.um.isa.dao;

import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import ar.edu.um.isa.dao.rowmapper.PublisherRowMapper;
import ar.edu.um.isa.model.Publisher;
	
public class PublisherMysqlDao implements PublisherDao {
	
	private JdbcTemplate jdbcTemplate;
	private static Logger log = Logger.getLogger(PublisherMysqlDao.class);
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void followPublisher(Publisher followed, Publisher follower) {
		String sql = "INSERT INTO followers (idFollower, idFollowed) " + 
				"VALUES (?, ?)";
				Object[] params = new Object[] {followed.getIdPublisher(), follower.getIdPublisher()};
				int[] types = new int[]{Types.INTEGER, Types.INTEGER};
				PreparedStatementCreatorFactory psc = new PreparedStatementCreatorFactory(sql,types);
				psc.setGeneratedKeysColumnNames(new String[] {"idFollow"});
				KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
				int result = this.getJdbcTemplate().update(psc.newPreparedStatementCreator(params),generatedKeyHolder);
				if (result != 1) {
					log.error("Error insertando seguidores en MySql");
				}
				log.debug("Se inserto seguidores correctamente");
		
		
	}

	public void unFollowPublisher(Publisher followed, Publisher follower) {
		String sql;
		Object[] params;
		int[] types;
		sql = "DELETE FROM followers WHERE idFollower=? AND idFollowed=?";
		params = new Object[]{followed.getIdPublisher(), follower.getIdPublisher()};
		types = new int[]{Types.INTEGER, Types.INTEGER};
		this.getJdbcTemplate().update(sql, params, types);
		log.debug("Se borro seguidores correctamente");
	}

	public List<Publisher> findFollowers(Publisher publisher) {
		String sql;
		Object[] params;
		int[] types;
		sql = "SELECT publisher.idPublisher, publisher.name FROM followers INNER JOIN publisher ON publisher.idPublisher=followers.idFollowed WHERE idFollower=?";
		params = new Object[]{publisher.getIdPublisher()};
		types=new int[]{Types.INTEGER};
		List<Publisher> publishers = this.getJdbcTemplate().query(sql, params, types, new PublisherRowMapper());
		if(publishers.size() == 0) {
			log.warn("Este usuario no sigue a ningun usuario");
			return null;
		}
		return publishers;
	
	}

	public List<Publisher> findFollowedBy(Publisher publisher) {
		String sql;
		Object[] params;
		int[] types;
		sql = "SELECT publisher.idPublisher, publisher.name FROM followers INNER JOIN publisher ON publisher.idPublisher=followers.idFollower WHERE idFollowed=?";
		params = new Object[]{publisher.getIdPublisher()};
		types=new int[]{Types.INTEGER};
		List<Publisher> publishers = this.getJdbcTemplate().query(sql, params, types, new PublisherRowMapper());
		if(publishers.size() == 0) {
			log.warn("Este usuario no es seguido por ningun usuario");
			return null;
		}
		return publishers;
	
	}

	public void createPublisher(Publisher publisher) {
		
		String sql = "INSERT INTO Publisher (name) " + 
				"VALUES (?)";
				Object[] params = new Object[] {publisher.getName() };
				int[] types = new int[]{Types.VARCHAR};
				PreparedStatementCreatorFactory psc = new PreparedStatementCreatorFactory(sql,types);
				psc.setGeneratedKeysColumnNames(new String[] {"idPublisher"});
				KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
				int result = this.getJdbcTemplate().update(psc.newPreparedStatementCreator(params),generatedKeyHolder);
				if (result != 1) {
					//System.out.println("Error insertando publicacion en MySql");
					log.error("Error insertando publisher en MySql");
				}
				publisher.setIdPublisher(generatedKeyHolder.getKey().intValue());
				log.debug("Se inserto la publisher correctamente");
		
	}

	public List<Publisher> findPublisher(Publisher publisher) {
		String sql;
		Object[] params;
		int[] types;
		sql = "SELECT * FROM publisher WHERE name=?";
		params = new Object[]{publisher.getName()};
		types=new int[]{Types.VARCHAR};
		List<Publisher> publishers = this.getJdbcTemplate().query(sql, params, types, new PublisherRowMapper());
		if(publishers.size() == 0) {
			log.warn("No existen publicaciones para ese usuario");
			return null;
		}
		return publishers;
	}
	
}
