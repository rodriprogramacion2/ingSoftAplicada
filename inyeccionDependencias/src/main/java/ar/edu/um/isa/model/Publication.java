package ar.edu.um.isa.model;

import java.util.Date;
import java.util.List;

public class Publication {
	private int idPublication;
	public int getIdPublication() {
		return idPublication;
	}
	public void setIdPublication(int idPublication) {
		this.idPublication = idPublication;
	}
	private Publisher publisher;
	private List<Tag> tags;
	private List<Publisher> mentions;
	private Date date;
	private String content;
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public List<Publisher> getMentions() {
		return mentions;
	}
	public void setMentions(List<Publisher> mentions) {
		this.mentions = mentions;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
