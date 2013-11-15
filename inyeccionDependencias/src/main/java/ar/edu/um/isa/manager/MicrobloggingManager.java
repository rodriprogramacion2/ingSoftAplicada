package ar.edu.um.isa.manager;

import java.util.List;

import ar.edu.um.isa.dao.PublicationDao;
import ar.edu.um.isa.model.Publication;
import ar.edu.um.isa.model.Publisher;
import ar.edu.um.isa.model.Tag;

public class MicrobloggingManager {
	
	PublicationDao publicationDao;
	Parser parser;
	
	public PublicationDao getPublicationDao() {
		return publicationDao;
	}

	public void setPublicationDao(PublicationDao publicationDao) {
		this.publicationDao = publicationDao;
	}

	public void publish(Publication publication){
		parser.parseTweet(publication);
		publicationDao.insertPublication(publication);
	}
	
	public List<Publication> findPublicationByPublisher(Publisher publisher){
		return publicationDao.findPublicationByPublisher(publisher);
	}
	
	public void deletePublication(Publication publication){
		
		publicationDao.deletePublication(publication);
	}
	
	public List <Publication> findPublicationsByTag (Tag tag){
		return publicationDao.findPublicationsByTag(tag);
	}
	
	public List <Publication> findPublicationsByMention (Publisher publisher){
		return publicationDao.findPublicationsByMention(publisher);
	}
	
	public void republish (Publication publication){
		publicationDao.republish(publication);
	}
	
	public List<Publication> findFollowingPublications(Publisher publisher) {
		return publicationDao.findFollowingPublications(publisher);
	}
	

}
