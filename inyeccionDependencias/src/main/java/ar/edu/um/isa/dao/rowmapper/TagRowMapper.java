package ar.edu.um.isa.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.edu.um.isa.model.Tag;

public class TagRowMapper implements RowMapper<Tag> {

	public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tag tag = new Tag();
		tag.setIdTag(rs.getInt("idTag"));
		tag.setTagName("name");
		return tag;
	}

}
