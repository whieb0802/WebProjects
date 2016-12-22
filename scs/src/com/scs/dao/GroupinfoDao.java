package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.scs.model.Groupinfo;

@Component("groupinfoDao")
public class GroupinfoDao extends BaseDao {
	
	public void saveGroupinfo(Groupinfo groupinfo) {
		getHibernateTemplate().save(groupinfo);
	}
	
	public void deleteGroupinfo(Groupinfo groupinfo) {
		getHibernateTemplate().delete(groupinfo);
	}
	
	public void deleteAll(List<Groupinfo> groupinfo) {
		getHibernateTemplate().deleteAll(groupinfo);
	}
	
	public void updateGroupinfo(Groupinfo groupinfo) {
		getHibernateTemplate().update(groupinfo);
	}
	
	public Groupinfo getGroupinfo(Class<Groupinfo> groupinfo,int id) {
		return (Groupinfo)getHibernateTemplate().get(groupinfo, id);
	}
	
	public List<Groupinfo> findGroupinfo(String groupinfo) {
		return getHibernateTemplate().find(groupinfo);
	}

	public List<Groupinfo> findGroupinfo(String groupinfo,Object o) {
		return getHibernateTemplate().find(groupinfo, o);
	}
	
	public List<Groupinfo> findGroupinfo(String groupinfo,Object[] objects) {
		return getHibernateTemplate().find(groupinfo,objects);
	}
}
