package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.scs.model.Groupinfo;
import com.scs.model.Growline;

@Component("growlineDao")
public class GrowlineDao extends BaseDao {
	
	public void saveGrowline(Growline growline) {
		getHibernateTemplate().save(growline);
	}
	
	public void deleteGrowline(Growline growline) {
		getHibernateTemplate().delete(growline);
	}
	
	public void deleteAll(List<Growline> Growline) {
		getHibernateTemplate().deleteAll(Growline);
	}
	
	public void updateGrowline(Growline growline) {
		getHibernateTemplate().update(growline);
	}
	
	public Growline getGrowline(Class<Growline> growline,int id) {
		return (Growline)getHibernateTemplate().get(growline, id);
	}
	
	public List<Growline> findGrowline(String growline) {
		return getHibernateTemplate().find(growline);
	}

	public List<Growline> findGrowline(String growline,Object o) {
		return getHibernateTemplate().find(growline, o);
	}
	
	public List<Growline> findGrowline(String growline,Object[] objects) {
		return getHibernateTemplate().find(growline,objects);
	}
}
