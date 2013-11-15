package ar.edu.um.isa.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.edu.um.isa.model.Publication;
import ar.edu.um.isa.model.Publisher;

public class PublicationRowMapper implements RowMapper<Publication> {

	public Publication mapRow(ResultSet rs, int index) throws SQLException {
		
		Publication publication = new Publication();
		publication.setIdPublication(rs.getInt("idPublication"));
		Publisher publisher = new Publisher();
		publisher.setIdPublisher(rs.getInt("idPublisher"));
		publication.setPublisher(publisher);
		publication.setDate(rs.getDate("date"));
		publication.setContent(rs.getString("content"));
		
		return publication;
	}

}
