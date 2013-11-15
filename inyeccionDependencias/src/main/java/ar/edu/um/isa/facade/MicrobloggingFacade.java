package ar.edu.um.isa.facade;

import java.util.List;

import ar.edu.um.isa.manager.MicrobloggingManager;
import ar.edu.um.isa.manager.PublisherManager;
import ar.edu.um.isa.manager.TagManager;
import ar.edu.um.isa.model.Publication;
import ar.edu.um.isa.model.Publisher;
import ar.edu.um.isa.model.Tag;

public class MicrobloggingFacade {
	
	MicrobloggingManager microbloggingManager;
	TagManager tagManager;
	PublisherManager publisherManager;
	
//-----------------getter y setters----------------
	public TagManager getTagManager() {
		return tagManager;
	}

	public void setTagManager(TagManager tagManager) {
		this.tagManager = tagManager;
	}

	public PublisherManager getPublisherManager() {
		return publisherManager;
	}

	public void setPublisherManager(PublisherManager publisherManager) {
		this.publisherManager = publisherManager;
	}
	
	public MicrobloggingManager getMicrobloggingManager() {
		return microbloggingManager;
	}

	public void setMicrobloggingManager(MicrobloggingManager microbloggingManager) {
		this.microbloggingManager = microbloggingManager;
	}
	
//---------------------------metodos-------------------------
	public void publish(Publication publication){
		microbloggingManager.publish(publication);
	}
	public List<Publication> findPublicationByPublisher(Publisher publisher){
		return microbloggingManager.findPublicationByPublisher(publisher);
	}
	public void deletePublication(Publication publication){
		microbloggingManager.deletePublication(publication);
	}
	public List <Publication> findPublicationsByTag (Tag tag){
		return microbloggingManager.findPublicationsByTag(tag);
	}
	public List <Publication> findPublicationsByMention (Publisher publisher){
		return microbloggingManager.findPublicationsByMention(publisher);
	}
	public void republish (Publication publication){
		microbloggingManager.republish(publication);
	}
	public void followPublisher(Publisher followed, Publisher follower){
		publisherManager.followPublisher(followed, follower);
	}
	
	public void unFollowPublisher(Publisher followed, Publisher follower){
		publisherManager.unFollowPublisher(followed, follower);
	}
	
	public List <Publisher> findFollowers(Publisher publisher){
		return publisherManager.findFollowers(publisher);
	}
	
	public List <Publisher> findFollowedBy(Publisher publisher){
		return publisherManager.findFollowedBy(publisher);
	}
	
	public  List <Tag> findPopularTags(){
		return tagManager.findPopularTags();
	}
	public void createPublisher(Publisher publisher){
		publisherManager.createPublisher(publisher);
	}
	public List <Publication> findFollowingPublications(Publisher publisher){
		return microbloggingManager.findFollowingPublications(publisher);
	}
	
	
}
