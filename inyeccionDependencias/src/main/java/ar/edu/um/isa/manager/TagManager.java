package ar.edu.um.isa.manager;

import java.util.List;

import ar.edu.um.isa.dao.TagDao;
import ar.edu.um.isa.model.Tag;

public class TagManager {

	TagDao tagDao;

	public TagDao getTagDao() {
		return tagDao;
	}

	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}
	
	public  List <Tag> findPopularTags(){
		return tagDao.findPopularTags();
	}
	
	public void createTag(Tag tag){
		tagDao.createTag(tag);
	}
	public List<Tag> findTag(Tag tag){
		return tagDao.findTag(tag);
	}
}
