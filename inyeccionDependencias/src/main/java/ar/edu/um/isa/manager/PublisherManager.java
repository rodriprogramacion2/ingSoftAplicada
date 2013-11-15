package ar.edu.um.isa.manager;

import java.util.List;

import ar.edu.um.isa.dao.PublisherDao;
import ar.edu.um.isa.model.Publisher;

public class PublisherManager {

	PublisherDao publisherDao;

	public PublisherDao getPublisherDao() {
		return publisherDao;
	}

	public void setPublisherDao(PublisherDao publisherDao) {
		this.publisherDao = publisherDao;
	}
	
	public void followPublisher(Publisher followed, Publisher follower){
		publisherDao.followPublisher(followed, follower);
	}
	public void unFollowPublisher(Publisher followed, Publisher follower){
		publisherDao.unFollowPublisher(followed, follower);
	}
	public List <Publisher> findFollowers(Publisher publisher){
		return publisherDao.findFollowers(publisher);
	}
	public List <Publisher> findFollowedBy(Publisher publisher){
		return publisherDao.findFollowedBy(publisher);
	}
	public void createPublisher(Publisher publisher){
		publisherDao.createPublisher(publisher);
	}
	public List<Publisher> findPublisher(Publisher publisher){
		return publisherDao.findPublisher(publisher);
	}

	
}
