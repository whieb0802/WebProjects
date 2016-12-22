package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import com.scs.model.Manager;

@Component("managerDao")
public class ManagerDao extends BaseDao {

	public void updateManager(Manager Manager) {
		getHibernateTemplate().update(Manager);
	}

	public void deleteManager(Manager Manager) {
		getHibernateTemplate().delete(Manager);
	}
	
	public void deleteAll(List<Manager> Manager) {
		getHibernateTemplate().deleteAll(Manager);
	}

	public void saveManager(Manager Manager) {
		getHibernateTemplate().save(Manager);
	}

	public Manager getManager(Class<Manager> Manager,int id) {
		return (Manager) getSession().load(Manager ,id);
	}
	
	public List<Manager> findManager(String Manager,Object o) {
		return getHibernateTemplate().find(Manager, o);
	}
	
	public List<Manager> findManager(String Manager) {
		return getHibernateTemplate().find(Manager);
	}
	

}
