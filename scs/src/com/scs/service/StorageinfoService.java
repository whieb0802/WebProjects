package com.scs.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.scs.dao.StorageinfoDao;
import com.scs.model.Storageinfo;

@Component("storageinfoService")

public class StorageinfoService{

	private StorageinfoDao storageinfoDao;
	
    @Resource(name="storageinfoDao")
	public void setStorageinfoDao(StorageinfoDao storageinfoDao) {
		this.storageinfoDao = storageinfoDao;
	}

	public StorageinfoDao getStorageinfoDao() {
		return storageinfoDao;
	}

	public void saveStorageinfo(Storageinfo storageinfo) {
		storageinfoDao.saveStorageinfo(storageinfo);

	}
	
	public void deleteStorageinfo(Storageinfo storageinfo) {
		storageinfoDao.deleteStorageinfo(storageinfo);
	}
	
	public void deleteAll(List<Storageinfo> storageinfo) {
		storageinfoDao.deleteAll(storageinfo);
	}
	
	public void updateStorageinfo(Storageinfo storageinfo) {
		storageinfoDao.updateStorageinfo(storageinfo);
	}
	public Storageinfo getStorageinfo(Class<Storageinfo> storageinfo,int id) {
		return (Storageinfo)storageinfoDao.getStorageinfo(storageinfo,id);
	}
	
	public List<Storageinfo> findStorageinfo(String storageinfo,Object o){
		return storageinfoDao.findStorageinfo(storageinfo,o);
	}
	
	public List<Storageinfo> findStorageinfo(String storageinfo,Object[] o){
		return storageinfoDao.findStorageinfo(storageinfo,o);
	}
	
	public List<Storageinfo> findStorageinfo(String storageinfo){
		return storageinfoDao.findStorageinfo(storageinfo);
	}

}
