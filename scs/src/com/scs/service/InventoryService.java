package com.scs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.scs.dao.InventoryDao;
import com.scs.model.Currentime;
import com.scs.model.Inventory;
import com.scs.model.User;

@Component("inventoryService")
public class InventoryService {

	private InventoryDao inventoryDao;

	@Resource
	public void setInverntoryDao(InventoryDao inverntoryDao) {
		this.inventoryDao = inverntoryDao;
	}

	public InventoryDao getInverntoryDao() {
		return inventoryDao;
	}

	public void getInventory(Inventory inventory) {
		inventoryDao.getInventory(inventory);

	}

	public void updateInventory(Inventory inventory) {
		inventoryDao.updateInventory(inventory);

	}

	public void deleteInventory(Inventory inventory) {
		inventoryDao.deleteInventory(inventory);

	}
	public void deleteAll(List<Inventory> inventory) {
		inventoryDao.deleteAll(inventory);

	}

	public void saveInventory(Inventory inventory) {
		inventoryDao.saveInventory(inventory);

	}
	
	public List<Inventory> findInventory(String inventory){
		return inventoryDao.findInventory(inventory);
	}
	
	public Inventory getInventory(Class<Inventory> inventory,int id) {
		return (Inventory)inventoryDao.getInventory(inventory,id);
	}
	
	public List<Inventory> findInventory(String inventory,Object o){
		return inventoryDao.findInventory(inventory,o);
	}
	
	public List<Inventory> findInventory(String inventory,Object[] objects){
		return inventoryDao.findInventory(inventory,objects);
	}
	
	public boolean ifinexists(User user,Currentime currentime){
		return inventoryDao.ifinexists(user, currentime);
	}
	
	public boolean ifoutexists(User user,Currentime currentime){
		return inventoryDao.ifoutexists(user, currentime);
	}

}
