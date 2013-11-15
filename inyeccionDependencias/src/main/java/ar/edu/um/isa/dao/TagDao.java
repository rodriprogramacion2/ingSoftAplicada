package ar.edu.um.isa.dao;

import java.util.List;

import ar.edu.um.isa.model.Tag;

public interface TagDao {
	public  List <Tag> findPopularTags();
	public void createTag(Tag tag);
	public List<Tag> findTag(Tag tag);
}
