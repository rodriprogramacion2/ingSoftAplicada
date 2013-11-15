package ar.edu.um.isa.manager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ar.edu.um.isa.model.Publication;
import ar.edu.um.isa.model.Publisher;
import ar.edu.um.isa.model.Tag;

public class Parser {
	TagManager tagManager;
	PublisherManager publisherManager;
	Tag tag;
	Publisher publisher;
	
	public Publication parseTweet(Publication publication){
		String patternStr = "(?:\\s|\\A)[##]+([A-Za-z0-9-_]+)";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(publication.getContent());
		String foundValue = "";
		
		//---------------------HASH TAGS-----------------------------
		while (matcher.find()){
			foundValue = matcher.group();
			foundValue = foundValue.replace(" ","");
			foundValue = foundValue.replace("#", "");
			tag.setTagName(foundValue);
			if(tagManager.findTag(tag) == null){
				tagManager.createTag(tag);
			}
			publication.getTags().add(tagManager.findTag(tag).get(0)); //magia probar que funciona!!!!!!
			}
		
		//---------------------USERS-----------------------------
		patternStr = "(?:\\s|\\A)[@]+([A-Za-z0-9-_]+)";
		pattern = Pattern.compile(patternStr);
		matcher = pattern.matcher(publication.getContent());
		while (matcher.find()){
			foundValue = matcher.group();
			foundValue = foundValue.replace(" ","");
			String rawName = foundValue.replace("@","");
			publisher.setName(rawName);
			if(publisherManager.findPublisher(publisher) == null){
				
			}else{
				publication.getMentions().add(publisherManager.findPublisher(publisher).get(0));//magia probar que funciona!!!!!!
			}
		}
		return publication;
	}

	
}
