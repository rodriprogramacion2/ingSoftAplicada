package ar.edu.um.isa.mb.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ar.edu.um.isa.common.ServiceLocator;
import ar.edu.um.isa.facade.MicrobloggingFacade;
import ar.edu.um.isa.model.Publication;
import ar.edu.um.isa.model.Publisher;

@WebService(serviceName="MicrobloggingWebService")
public class MicrobloggingWebService {

	@WebMethod
	public void publish(@WebParam(name="publication") Publication publication){
		try {
			MicrobloggingFacade microbloggingFacade = (MicrobloggingFacade) ServiceLocator.getInstance().getService("microbloggingFacade");
			microbloggingFacade.publish(publication);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public List<Publication> findPublicationByPublisher(@WebParam(name="publisher") Publisher publisher){
		try {
			MicrobloggingFacade microbloggingFacade = (MicrobloggingFacade) ServiceLocator.getInstance().getService("microbloggingFacade");
			return microbloggingFacade.findPublicationByPublisher(publisher);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@WebMethod
	public void createPublisher(@WebParam(name="publisher") Publisher publisher){
		try {
			MicrobloggingFacade microbloggingFacade = (MicrobloggingFacade) ServiceLocator.getInstance().getService("microbloggingFacade");
			microbloggingFacade.createPublisher(publisher);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public void followPublisher(@WebParam(name="followed") Publisher follower, @WebParam(name="follower") Publisher followed){
		try {
			MicrobloggingFacade microbloggingFacade = (MicrobloggingFacade) ServiceLocator.getInstance().getService("microbloggingFacade");
			microbloggingFacade.followPublisher(followed, follower);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public void unFollowPublisher(@WebParam(name="followed") Publisher follower, @WebParam(name="follower") Publisher followed){
		try {
			MicrobloggingFacade microbloggingFacade = (MicrobloggingFacade) ServiceLocator.getInstance().getService("microbloggingFacade");
			microbloggingFacade.unFollowPublisher(followed, follower);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@WebMethod
	public List <Publisher> findFollowers(@WebParam(name="Publisher") Publisher publisher){
		try {
			MicrobloggingFacade microbloggingFacade = (MicrobloggingFacade) ServiceLocator.getInstance().getService("microbloggingFacade");
			return microbloggingFacade.findFollowers(publisher);
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod
	public List <Publisher> findFollowedBy(@WebParam(name="Publisher") Publisher publisher){
		try {
			MicrobloggingFacade microbloggingFacade = (MicrobloggingFacade) ServiceLocator.getInstance().getService("microbloggingFacade");
			return microbloggingFacade.findFollowedBy(publisher);
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	@WebMethod
	public List <Publication> findFollowingPublications(@WebParam(name="Publisher") Publisher publisher){
		try {
			MicrobloggingFacade microbloggingFacade = (MicrobloggingFacade) ServiceLocator.getInstance().getService("microbloggingFacade");
			return microbloggingFacade.findFollowingPublications(publisher);
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
}
