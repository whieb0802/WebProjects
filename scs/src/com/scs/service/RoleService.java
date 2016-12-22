package com.scs.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import com.scs.dao.RoleDao;
import com.scs.model.Role;

@Component("roleService")
public class RoleService{
	
     private RoleDao roleDao;
	@Resource
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void saveRole(Role role) {
		roleDao.saveRole(role);

	}
	
	public void deleteRole(Role role) {
		roleDao.deleteRole(role);
	}
	
	public void deleteAll(List<Role> role) {
		roleDao.deleteAll(role);
	}
	
	public void updateRole(Role role) {
		roleDao.updateRole(role);
	}

	public Role getRole(Class<Role> role,int id) {
		return (Role)roleDao.getRole(role,id);
	}
	
	public List<Role> findRole(String role,Object o){
		return roleDao.findRole(role,o);
	}
	
	public List<Role> findRole(String role){
		return roleDao.findRole(role);
	}

}
