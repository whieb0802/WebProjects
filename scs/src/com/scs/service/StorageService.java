package com.scs.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.scs.dao.StorageDao;
import com.scs.model.Storage;

@Component("storageService")
public class StorageService{

	private StorageDao storageDao;
	
    @Resource
	public void setStorageDao(StorageDao storageDao) {
		this.storageDao = storageDao;
	}

	public StorageDao getStorageDao() {
		return storageDao;
	}

	public void saveStorage(Storage storage) {
		storageDao.saveStorage(storage);

	}
	
	public void deleteStorage(Storage storage) {
		storageDao.deleteStorage(storage);
	}
	
	public void deleteAll(List<Storage> storage) {
		storageDao.deleteAll(storage);
	}
	
	public void updateStorage(Storage storage) {
		storageDao.updateStorage(storage);
	}

	public Storage getStorage(Class<Storage> storage,int id) {
		return (Storage)storageDao.getStorage(storage,id);
	}
	
	public List<Storage> findStorage(String storage,Object o){
		return storageDao.findStorage(storage,o);
	}
	public List<Storage> findStorage(String storage,Object[] o){
		return storageDao.findStorage(storage,o);
	}
	
	public List<Storage> findStorage(String storage){
		return storageDao.findStorage(storage);
	}

}
