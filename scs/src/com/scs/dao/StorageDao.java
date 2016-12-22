package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import com.scs.model.Storage;

@Component("storageDao")
public class StorageDao extends BaseDao {

	public void updateStorage(Storage storage) {
		getHibernateTemplate().update(storage);
	}

	public void deleteStorage(Storage storage) {
		getHibernateTemplate().delete(storage);
	}
	
	public void deleteAll(List<Storage> storage) {
		getHibernateTemplate().deleteAll(storage);
	}

	public void saveStorage(Storage storage) {
		getHibernateTemplate().save(storage);
	}

	public Storage getStorage(Class<Storage> storage,int id) {
		return (Storage) getSession().load(storage ,id);
	}
	
	public List<Storage> findStorage(String storage,Object o) {
		return getHibernateTemplate().find(storage, o);
	}
	
	public List<Storage> findStorage(String storage,Object[] o) {
		return getHibernateTemplate().find(storage, o);
	}
	
	public List<Storage> findStorage(String storage) {
		return getHibernateTemplate().find(storage);
	}
	

}
