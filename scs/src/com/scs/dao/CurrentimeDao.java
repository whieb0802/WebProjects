package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.scs.model.Area;
import com.scs.model.Currentime;

@Component("currentimeDao")
public class CurrentimeDao extends BaseDao{
	
	public void getCurrentime(Currentime currentime) {
		getHibernateTemplate().findByExample(currentime);
       	
	}
	public void updateCurrentime(Currentime currentime) {
		getHibernateTemplate().update(currentime);
		
	}
	public void deleteCurrentime(Currentime currentime) {
		getHibernateTemplate().delete(currentime);
	}
	public void deleteAll(List<Currentime> currentime) {
		getHibernateTemplate().deleteAll(currentime);
	}
	public void saveCurrentime(Currentime currentime) {
		getHibernateTemplate().save(currentime);
		
	}
	public Currentime getCurrentime(Class<Currentime> currentime, int id) {
		return (Currentime) getHibernateTemplate().get(currentime, id);
	}
	public List<Currentime> findCurrentime(String currentime, Object o) {
		return getHibernateTemplate().find(currentime, o);
	}
	
	public List<Currentime> findCurrentime(String currentime) {
		return getHibernateTemplate().find(currentime);
	}

}
