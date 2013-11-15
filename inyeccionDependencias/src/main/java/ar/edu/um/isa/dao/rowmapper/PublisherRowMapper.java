/**
 * 
 */
package ar.edu.um.isa.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.edu.um.isa.model.Publisher;

/**
 * @author Rodri
 *
 */
public class PublisherRowMapper implements RowMapper<Publisher> {

	public Publisher mapRow(ResultSet rs, int index) throws SQLException{
		Publisher publisher = new Publisher();
		publisher.setIdPublisher(rs.getInt("idPublisher"));
		publisher.setName(rs.getString("name"));
		return publisher;
		
	}
}
