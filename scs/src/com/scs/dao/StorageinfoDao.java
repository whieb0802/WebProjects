package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.scs.model.Storageinfo;

@Component("storageinfoDao")
public class StorageinfoDao extends BaseDao {
	
	public void saveStorageinfo(Storageinfo storageinfo) {
		getHibernateTemplate().save(storageinfo);
	}
	
	public void deleteStorageinfo(Storageinfo storageinfo) {
		getHibernateTemplate().delete(storageinfo);
	}
	
	public void deleteAll(List<Storageinfo> storageinfo) {
		getHibernateTemplate().delete(storageinfo);
	}
	
	public void updateStorageinfo(Storageinfo storageinfo) {
		getHibernateTemplate().update(storageinfo);
	}
	
	public Storageinfo getStorageinfo(Class<Storageinfo> storageinfo,int id) {
		return (Storageinfo)getHibernateTemplate().get(storageinfo, id);
	}
	
	public List<Storageinfo> findStorageinfo(String storageinfo) {
		return getHibernateTemplate().find(storageinfo);
	}

	public List<Storageinfo> findStorageinfo(String storageinfo,Object o) {
		return getHibernateTemplate().find(storageinfo, o);
	}
	
	public List<Storageinfo> findStorageinfo(String storageinfo,Object[] objects) {
		return getHibernateTemplate().find(storageinfo,objects);
	}
}
