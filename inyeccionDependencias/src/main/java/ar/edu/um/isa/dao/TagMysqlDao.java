package ar.edu.um.isa.dao;

import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import ar.edu.um.isa.dao.rowmapper.TagRowMapper;
import ar.edu.um.isa.model.Tag;

public class TagMysqlDao implements TagDao {

	private JdbcTemplate jdbcTemplate;
	private static Logger log = Logger.getLogger(TagMysqlDao.class);
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Tag> findPopularTags() {
		// TODO Auto-generated method stub
		return null;
	}

	public void createTag(Tag tag) {
		String sql = "INSERT INTO Publisher (name) " + 
				"VALUES (?)";
				Object[] params = new Object[] {tag.getTagName() };
				int[] types = new int[]{Types.VARCHAR};
				PreparedStatementCreatorFactory psc = new PreparedStatementCreatorFactory(sql,types);
				psc.setGeneratedKeysColumnNames(new String[] {"idTag"});
				KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
				int result = this.getJdbcTemplate().update(psc.newPreparedStatementCreator(params),generatedKeyHolder);
				if (result != 1) {
					//System.out.println("Error insertando publicacion en MySql");
					log.error("Error insertando Tag en MySql");
				}
				tag.setIdTag(generatedKeyHolder.getKey().intValue());
				log.debug("Se inserto la Tag correctamente");
		
	}

	public List<Tag> findTag(Tag tag) {
		String sql;
		Object[] params;
		int[] types;
		sql = "SELECT * FROM tag WHERE name=?";
		params = new Object[]{tag.getTagName()};
		types=new int[]{Types.VARCHAR};
		List<Tag> tags = this.getJdbcTemplate().query(sql, params, types, new TagRowMapper());
		if(tags.size() == 0) {
			log.warn("No existen publicaciones para ese usuario");
			return null;
		}
		return tags;
	}
	
}
