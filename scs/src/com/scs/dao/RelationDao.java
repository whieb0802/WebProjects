package com.scs.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import com.scs.model.Relation;

@Component("relationDao")
public class RelationDao extends BaseDao {
	
	public Relation getRelation(Class<Relation> relation,int id) {
		return (Relation)getHibernateTemplate().get(relation, id);
	}
	public void updateRelation(Relation relation) {
		getHibernateTemplate().update(relation);
		
	}
	public void deleteRelation(Relation relation) {
		getHibernateTemplate().delete(relation);
		
	}
	
	public void deleteAll(List<Relation> relation) {
		getHibernateTemplate().deleteAll(relation);
		
	}
	public void saveRelation(Relation relation) {
		getHibernateTemplate().save(relation);
	}
	public List<Relation> findRelation(String relation,Object o){
		return getHibernateTemplate().find(relation, o);
	}
	
	public List<Relation> findRelation(String relation){
		return getHibernateTemplate().find(relation);
	}

}
