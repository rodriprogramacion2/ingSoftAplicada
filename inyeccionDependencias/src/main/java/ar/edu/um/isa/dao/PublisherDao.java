package ar.edu.um.isa.dao;

import java.util.List;

import ar.edu.um.isa.model.Publisher;

public interface PublisherDao {
	public void followPublisher(Publisher followed, Publisher follower);
	public void unFollowPublisher(Publisher followed, Publisher follower);
	public List <Publisher> findFollowers(Publisher publisher);
	public List <Publisher> findFollowedBy(Publisher publisher);
	public void createPublisher(Publisher publisher);//creado! y probado
	public List <Publisher> findPublisher(Publisher publisher);
}
