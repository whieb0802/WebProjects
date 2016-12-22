package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.scs.model.Role;

@Component("roleDao")
public class RoleDao extends BaseDao{
	
	public void saveRole(Role role) {
		getHibernateTemplate().save(role);
	}
	
	public void deleteRole(Role role) {
		getHibernateTemplate().delete(role);
	}
	
	public void deleteAll(List<Role> role) {
		getHibernateTemplate().deleteAll(role);
	}


	public void updateRole(Role role) {
		getHibernateTemplate().update(role);
	}

	public Role getRole(Class<Role> role,int id) {
		return (Role)getHibernateTemplate().get(role, id);
	}
	
	public List<Role> findRole(String role,Object o) {
		return getHibernateTemplate().find(role, o);
	}
	
	public List<Role> findRole(String role) {
		return getHibernateTemplate().find(role);
	}

}
