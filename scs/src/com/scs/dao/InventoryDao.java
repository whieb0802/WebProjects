package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.scs.model.Currentime;
import com.scs.model.Inventory;
import com.scs.model.User;

@Component("inventoryDao")
public class InventoryDao extends BaseDao  {
	
	public void getInventory(Inventory inventory) {
		getHibernateTemplate().findByExample(inventory);
       	
	}
	public void updateInventory(Inventory inventory) {
		getHibernateTemplate().update(inventory);
		
	}
	public void deleteInventory(Inventory inventory) {
		getHibernateTemplate().delete(inventory);
		
	}
	public void deleteAll(List<Inventory> inventory) {
		getHibernateTemplate().deleteAll(inventory);
		
	}
	public void saveInventory(Inventory inventory) {
		getHibernateTemplate().save(inventory);
		
	}
	public Inventory getInventory(Class<Inventory> inventory,int id) {
		return (Inventory)getHibernateTemplate().get(inventory, id);
	}
	
	public List<Inventory> findInventory(String inventory) {
		return getHibernateTemplate().find(inventory);
	}
	
	public List<Inventory> findInventory(String inventory,Object o) {
		return getHibernateTemplate().find(inventory, o);
	}
	
	public List<Inventory> findInventory(String inventory, Object[] objects) {
		return getHibernateTemplate().find(inventory,objects);
	}
	
	public boolean ifinexists(User user ,Currentime currentime){
		List<Inventory> list = getHibernateTemplate().find("from Inventory i where i.user = ? and i.currentime = ?", new Object[]{user,currentime});
		if(list.get(0).getP1in() != 0 || list.get(0).getP2in() != 0||list.get(0).getP3in() != 0)
		   return true;
		else
		return false;
	}
	
	public boolean ifoutexists(User user ,Currentime currentime){
		List<Inventory> list = getHibernateTemplate().find("from Inventory i where i.user = ? and i.currentime = ?", new Object[]{user,currentime});
		if(list.get(0).getP1out() != 0 || list.get(0).getP2out() != 0||list.get(0).getP3out() != 0)
			return true;
		else
			return false;
	}

}
