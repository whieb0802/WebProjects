package com.scs.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.scs.dao.RelationDao;
import com.scs.model.Relation;

@Component("relationService")
public class RelationService{

	private RelationDao relationDao;
    @Resource
	public void setRelationDao(RelationDao relationDao) {
		this.relationDao = relationDao;
	}
   
	public RelationDao getRelationDao() {
		return relationDao;
	}
	
	public void saveRelation(Relation relation) {
		relationDao.saveRelation(relation);

	}
	
	public void deleteRelation(Relation relation) {
		relationDao.deleteRelation(relation);
	}
	
	public void deleteAll(List<Relation> relation) {
		relationDao.deleteAll(relation);
	}
	
	public void updateRelation(Relation relation) {
		relationDao.updateRelation(relation);
	}

	public Relation getRelation(Class<Relation> relation,int id) {
		return relationDao.getRelation(relation,id);
	}
	
	public List<Relation> findRelation(String relation,Object o){
		 return relationDao.findRelation(relation,o);
	}
	
	public List<Relation> findRelation(String relation){
		 return relationDao.findRelation(relation);
	}

}
