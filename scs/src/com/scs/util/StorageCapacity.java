package com.scs.util;

import java.util.List;
import javax.annotation.Resource;
import com.scs.model.Currentime;
import com.scs.model.Inventory;
import com.scs.model.Relation;
import com.scs.model.Role;
import com.scs.model.Storage;
import com.scs.model.Storageinfo;
import com.scs.model.User;
import com.scs.service.CurrentimeService;
import com.scs.service.InventoryService;
import com.scs.service.RelationService;
import com.scs.service.StorageService;
import com.scs.service.StorageinfoService;
import com.scs.service.UserService;

public class StorageCapacity{
	private static final long serialVersionUID = 1L;

	private static UserService userService;
	private static StorageinfoService storageinfoService;
	private static CurrentimeService currentimeService;
	private static StorageService storageService;
	private static RelationService relationService;
	private static InventoryService inventoryService;
	
	public static boolean isFull(int userid,int currentime,int p1,int p2,int p3){
		User user = userService.getUser(User.class, userid);
		Role role = relationService.getRelation(Relation.class, userid).getRole();
		Currentime currentime1 = currentimeService.getCurrentime(Currentime.class, currentime);
	    List<Storage> list1 = storageService.findStorage("from Storage s where s.user=? and s.currentime<=?",new Object[]{user,currentime1});
		Storageinfo storageinfo1 = storageinfoService.findStorageinfo("from Storageinfo s where s.id=? and s.role=?", new Object[]{1,role}).get(0);
		Storageinfo storageinfo2 = storageinfoService.findStorageinfo("from Storageinfo s where s.id=? and s.role=?", new Object[]{2,role}).get(0);
		Storageinfo storageinfo3 = storageinfoService.findStorageinfo("from Storageinfo s where s.id=? and s.role=?", new Object[]{3,role}).get(0);
		
		//小仓库个数
		int smallCount = 0;
		for(Storage s:list1){
			smallCount += s.getBuy1count()+s.getRent1count();
		}
		//中仓库个数
		int middleCount = 0;
		for(Storage s:list1){
			middleCount += s.getBuy2count()+s.getRent2count();
		}
		//大仓库个数
		int bigCount = 0;
		for(Storage s:list1){
			bigCount += s.getBuy3count()+s.getRent3count();
		}
		
		//可以存放每种产品的总个数
		int p1count1 = smallCount*storageinfo1.getP1count() + middleCount*storageinfo2.getP1count()+bigCount*storageinfo3.getP1count();
		int p2count1 = smallCount*storageinfo1.getP2count() + middleCount*storageinfo2.getP2count()+bigCount*storageinfo3.getP2count();
		int p3count1 = smallCount*storageinfo1.getP3count() + middleCount*storageinfo2.getP3count()+bigCount*storageinfo3.getP3count();
        
		//库存每种产品的个数
        List<Inventory> inventory = inventoryService.findInventory("from Inventory i where i.user=? and i.currentime=?", new Object[]{user,currentime1});
		int p1count2 = inventory.get(0).getCurrentp1();
		int p2count2 = inventory.get(0).getCurrentp2();
		int p3count2 = inventory.get(0).getCurrentp3();
		
		double a = (p1count2+p1)/p1count1 + (p2count2+p2)/p2count1 + (p3count2+p3)/p3count1;
		if(a>=1){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isFull(User user,Role role,Currentime currentime,int p1,int p2,int p3,Inventory inventory){
	    List<Storage> list1 = storageService.findStorage("from Storage s where s.user=? and s.currentime<=?",new Object[]{user,currentime});
	    Storageinfo storageinfo1 = storageinfoService.findStorageinfo("from Storageinfo s where s.id=? and s.role=?", new Object[]{1,role}).get(0);
		Storageinfo storageinfo2 = storageinfoService.findStorageinfo("from Storageinfo s where s.id=? and s.role=?", new Object[]{2,role}).get(0);
		Storageinfo storageinfo3 = storageinfoService.findStorageinfo("from Storageinfo s where s.id=? and s.role=?", new Object[]{3,role}).get(0);
		//小仓库个数
		int smallCount = 0;
		for(Storage s:list1){
			smallCount += s.getBuy1count()+s.getRent1count();
		}
		//中仓库个数
		int middleCount = 0;
		for(Storage s:list1){
			middleCount += s.getBuy2count()+s.getRent2count();
		}
		//大仓库个数
		int bigCount = 0;
		for(Storage s:list1){
			bigCount += s.getBuy3count()+s.getRent3count();
		}
		
		//可以存放每种产品的总个数
		int p1count1 = smallCount*storageinfo1.getP1count() + middleCount*storageinfo2.getP1count()+bigCount*storageinfo3.getP1count();
		int p2count1 = smallCount*storageinfo1.getP2count() + middleCount*storageinfo2.getP2count()+bigCount*storageinfo3.getP2count();
		int p3count1 = smallCount*storageinfo1.getP3count() + middleCount*storageinfo2.getP3count()+bigCount*storageinfo3.getP3count();
        
		//库存每种产品的个数
		int p1count2 = inventory.getCurrentp1();
		int p2count2 = inventory.getCurrentp2();
		int p3count2 = inventory.getCurrentp3();
		
		double a = (double)(p1count2+p1)/p1count1 + (double)(p2count2+p2)/p2count1 + (double)(p3count2+p3)/p3count1;
		if(a>=1){
			return true;
		}else{
			return false;
		}
	}
	
	public UserService getUserService() {
		return userService;
	}
    @Resource
	public void setUserService(UserService userService) {
		StorageCapacity.userService = userService;
	}

	public StorageinfoService getStorageinfoService() {
		return storageinfoService;
	}
	@Resource
	public void setStorageinfoService(StorageinfoService storageinfoService) {
		StorageCapacity.storageinfoService = storageinfoService;
	}

	public CurrentimeService getCurrentimeService() {
		return currentimeService;
	}
	@Resource
	public void setCurrentimeService(CurrentimeService currentimeService) {
		StorageCapacity.currentimeService = currentimeService;
	}

	public RelationService getRelationService() {
		return relationService;
	}
	@Resource
	public void setRelationService(RelationService relationService) {
		StorageCapacity.relationService = relationService;
	}

	public InventoryService getInventoryService() {
		return inventoryService;
	}
	@Resource
	public void setInventoryService(InventoryService inventoryService) {
		StorageCapacity.inventoryService = inventoryService;
	}

	public StorageService getStorageService() {
		return storageService;
	}
   @Resource
	public void setStorageService(StorageService storageService) {
		StorageCapacity.storageService = storageService;
	}

}