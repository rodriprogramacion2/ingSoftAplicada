package ar.edu.um.isa.dao;

import java.util.List;

import ar.edu.um.isa.model.Publication;
import ar.edu.um.isa.model.Publisher;
import ar.edu.um.isa.model.Tag;

public interface PublicationDao {
	public void insertPublication(Publication publication);
	public List<Publication> findPublicationByPublisher(Publisher publisher);
	public void deletePublication(Publication publication);
	public List <Publication> findPublicationsByTag (Tag tag);
	public List <Publication> findPublicationsByMention (Publisher publisher);
	public void republish (Publication publication);
	public List<Publication> findFollowingPublications(Publisher publisher);
}
