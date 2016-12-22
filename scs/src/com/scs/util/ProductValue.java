package com.scs.util;

import java.util.List;
import javax.annotation.Resource;
import com.scs.model.Bill;
import com.scs.model.Currentime;
import com.scs.model.Inventory;
import com.scs.model.User;
import com.scs.service.BillService;
import com.scs.service.CurrentimeService;
import com.scs.service.InventoryService;
import com.scs.service.UserService;

public class ProductValue {
	
	private static CurrentimeService currentimeService;
	private static InventoryService inventoryService;
	private static UserService userService;
	private static BillService billService;

	//直接成本
	public static int directCost(int currentimeid,int userid){
		
		User user = userService.getUser(User.class, userid);
		Currentime currentime = currentimeService.getCurrentime(Currentime.class, currentimeid);
		
		List<Bill> list3 = billService.findBill("from Bill b where b.currentime=? and b.bfrom=?",new Object[]{currentime,userid});
		List<Bill> list4 = billService.findBill("from Bill b where b.currentime<=? and b.bto=?", new Object[]{currentime,userid});
        
		List<Inventory> list1 = inventoryService.findInventory("from Inventory i where i.user=? and i.currentime=?", new Object[]{user,currentime});
		List<Inventory> list2 = inventoryService.findInventory("from Inventory i where i.user=? and i.currentime<=?", new Object[]{user,currentime});

        
		if(list1.size()==0){
			return 0;
		}else{
			Inventory inventory = list1.get(0);
			int p1 = inventory.getP1out();
			int p2 = inventory.getP2out();
			int p3 = inventory.getP3out();
			int p1Cost = 0;
			int p2Cost = 0;
			int p3Cost = 0;
			
	        if(list2 == null){
	        	return 0;
	        }else if(list2.size()==1){
	        	p1Cost = p1*list3.get(0).getP1price();
	        	p2Cost = p2*list3.get(0).getP2price();
	        	p3Cost = p3*list3.get(0).getP3price();
	        }//需要修改
	        else if(list2.size()==2){
	        	p1Cost = p1*list3.get(0).getP1price();
	        	p2Cost = p2*list3.get(0).getP2price();
	        	p3Cost = p3*list3.get(0).getP3price();
	        }
	        else{
	        	if(inventory.getP1totalout()<list4.get(0).getCountp1()){
	        		p1Cost = p1*list4.get(0).getP1price();
	        	}
	        	if(inventory.getP2totalout()<list4.get(0).getCountp2()){
	        		p2Cost = p2*list4.get(0).getP2price();
	        	}
	        	if(inventory.getP3totalout()<list4.get(0).getCountp3()){
	        		p3Cost = p3*list4.get(0).getP3price();
	        	}
	        	for(int i=0;i<list2.size()-2;i++){
	        		Inventory inventory1 = list2.get(i);
	        		Inventory inventory2 = list2.get(i+1);
	            	Bill bill2 = list4.get(i);
	            	Bill bill3 = list4.get(i+1);
	            	if(inventory.getP1totalout()>=inventory1.getP1totalin() &&inventory.getP1totalout()<=inventory2.getP1totalin()){
	            		int a = inventory.getP1totalout()-inventory1.getP1totalin();
	            		p1Cost = a*bill3.getP1price()+(p1-a)*bill2.getP1price();
	            	}
	            	if(inventory.getP2totalout()>=inventory1.getP2totalin() &&inventory.getP2totalout()<=inventory2.getP2totalin()){
	            		int a = inventory.getP2totalout()-inventory1.getP2totalin();
	            		p1Cost = a*bill3.getP2price()+(p2-a)*bill2.getP2price();
	            	}
	            	if(inventory.getP3totalout()>=inventory1.getP3totalin() &&inventory.getP3totalout()<=inventory2.getP3totalin()){
	            		int a = inventory.getP3totalout()-inventory1.getP3totalin();
	            		p1Cost = a*bill3.getP3price()+(p3-a)*bill2.getP3price();
	            	}
	            }
	        }
	        return p1Cost+p2Cost+p3Cost;
		}
	}
	
	//库存产品
	public static int leftCost(int currentimeid,int userid){
		
		Currentime currentime = currentimeService.getCurrentime(Currentime.class, currentimeid);
		//入库
		List<Bill> list4 = billService.findBill("from Bill b where b.currentime<=? and b.bto=?", new Object[]{currentime,userid});
		//产品入库累计总价
		int incometotal = 0;
		for(Bill b:list4){
			incometotal += b.getCountp1()*b.getP1price()+ b.getCountp2()*b.getP2price()+ b.getCountp3()*b.getP3price();
		}
		//产品出库累计总价
		int outcometotal = 0;
		for(int i=1;i<=currentimeid;i++){
			outcometotal += ProductValue.directCost(i, userid);
		}
		return incometotal-outcometotal;
	}
	
	public CurrentimeService getCurrentimeService() {
		return currentimeService;
	}
    @Resource
	public void setCurrentimeService(CurrentimeService currentimeService) {
		ProductValue.currentimeService = currentimeService;
	}

	public InventoryService getInventoryService() {
		return inventoryService;
	}
	@Resource
	public void setInventoryService(InventoryService inventoryService) {
		ProductValue.inventoryService = inventoryService;
	}

	public UserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserService userService) {
		ProductValue.userService = userService;
	}
	
	public static BillService getBillService() {
		return billService;
	}
    @Resource
	public static void setBillService(BillService billService) {
		ProductValue.billService = billService;
	}
}
