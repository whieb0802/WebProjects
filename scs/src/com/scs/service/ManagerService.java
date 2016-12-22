package com.scs.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import com.scs.dao.ManagerDao;
import com.scs.model.Manager;

@Component("managerService")
public class ManagerService{

	private ManagerDao managerDao;
    @Resource
	public void setManagerDao(ManagerDao ManagerDao) {
		this.managerDao = ManagerDao;
	}

	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void saveManager(Manager Manager) {
		managerDao.saveManager(Manager);

	}
	
	public void deleteManager(Manager Manager) {
		managerDao.deleteManager(Manager);
	}
	
	public void deleteAll(List<Manager> Manager) {
		managerDao.deleteAll(Manager);
	}
	
	
	public void updateManager(Manager Manager) {
		managerDao.updateManager(Manager);
	}

	public Manager getManager(Class<Manager> Manager,int id) {
		return (Manager)managerDao.getManager(Manager,id);
	}
	
	public List<Manager> findManager(String Manager,Object o){
		return managerDao.findManager(Manager,o);
	}
	
	public List<Manager> findManager(String Manager){
		return managerDao.findManager(Manager);
	}

}
