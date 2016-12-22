package com.scs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scs.model.Bill;
import com.scs.model.Currentime;
import com.scs.model.Fund;
import com.scs.model.Inventory;
import com.scs.model.Message;
import com.scs.model.Product;
import com.scs.model.Role;
import com.scs.model.Storage;
import com.scs.model.User;
import com.scs.service.BillService;
import com.scs.service.CurrentimeService;
import com.scs.service.FundService;
import com.scs.service.InventoryService;
import com.scs.service.ProductService;
import com.scs.service.RoleService;
import com.scs.service.StorageService;
import com.scs.service.UserService;

public class InventoryAction2 extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private int userid = 3;
	private int current = 1;
	private Bill bill = new Bill();

	CurrentimeService currentimeService;
	BillService billService;
	InventoryService inventoryService;
	FundService fundService;
	UserService userService;
	ProductService productService;
	RoleService roleService;
	StorageService storageService;

	public InventoryAction2() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		currentimeService = (CurrentimeService) ctx.getBean("currentimeService");
		billService = (BillService) ctx.getBean("billService");
		inventoryService = (InventoryService) ctx.getBean("inventoryService");
		fundService = (FundService) ctx.getBean("fundService");
		userService = (UserService) ctx.getBean("userService");
		productService = (ProductService) ctx.getBean("productService");
		roleService = (RoleService) ctx.getBean("roleService");
		storageService = (StorageService) ctx.getBean("storageService");

	}


    @Test
	public void retaileroutcome(){
		
		Currentime ct = currentimeService.getCurrentime(Currentime.class, current);
		User user = userService.getUser(User.class, userid);
		
		bill.setBfrom(userid);
		bill.setCurrentime(ct);
		bill.setP1lack(8);
		bill.setP2lack(8);
		bill.setP3lack(8);
		billService.saveBill(bill);
		
		
		System.out.println("routcome");
		}
	

	

}