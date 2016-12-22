package com.scs.util;

import java.util.List;
import javax.annotation.Resource;
import com.scs.model.Currentime;
import com.scs.model.Inventory;
import com.scs.model.Product;
import com.scs.model.Relation;
import com.scs.model.Role;
import com.scs.model.User;
import com.scs.service.InventoryService;
import com.scs.service.ProductService;
import com.scs.service.RelationService;

public class StorageCost {

	private RelationService relationService;
	private InventoryService inventoryService;
	private ProductService productService;

	public StorageCost() {
	}
	
	//产品库存费用
	public int storageCost(User user,Currentime currentime){
		
		Role role = relationService.getRelation(Relation.class, user.getUserid()).getRole();
		List<Inventory> list1 = inventoryService.findInventory("from Inventory i where i.user=? and i.currentime=?", new Object[]{user,currentime});
		if(list1.size()==0){
			return 0;
		}
		Inventory inventory = list1.get(0);
		return product(1,role).getIcost()*inventory.getCurrentp1()+
		       product(2,role).getIcost()*inventory.getCurrentp2()+
		       product(3,role).getIcost()*inventory.getCurrentp3();
	}
	
	//根据产品名称获得产品对象
	public Product product(int productid,Role role){
		List<Product> list2 = productService.findProduct("from Product p where p.productid=? and p.role=?",new Object[]{productid,role});
		return list2.get(0);
	}
	
	public RelationService getRelationService() {
		return relationService;
	}
    @Resource
	public void setRelationService(RelationService relationService) {
		this.relationService = relationService;
	}

	public InventoryService getInventoryService() {
		return inventoryService;
	}
	@Resource
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	public ProductService getProductService() {
		return productService;
	}
	@Resource
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
