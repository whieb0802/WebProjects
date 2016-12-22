package com.scs.action;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scs.model.Bill;
import com.scs.model.Currentime;
import com.scs.model.Fund;
import com.scs.model.Inventory;
import com.scs.model.Message;
import com.scs.model.Order;
import com.scs.model.User;
import com.scs.service.BillService;
import com.scs.service.CurrentimeService;
import com.scs.service.FundService;
import com.scs.service.InventoryService;
import com.scs.service.OrderService;
import com.scs.service.ProductService;
import com.scs.service.UserService;

public class AgentActionTest extends ActionSupport implements ModelDriven<Bill>{
	private static final long serialVersionUID = 1L;

	private int userid;
	private int roleid;
	private int currentime;
	private int current;
	private Bill bill = new Bill();

	CurrentimeService currentimeService;
	OrderService orderService;
	BillService billService;
	InventoryService inventoryService;
	FundService fundService;
	UserService userService;
	ProductService productService;

	public AgentActionTest() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		currentimeService = (CurrentimeService) ctx.getBean("currentimeService");
		orderService = (OrderService) ctx.getBean("orderService");
		billService = (BillService) ctx.getBean("billService");
		inventoryService = (InventoryService) ctx.getBean("inventoryService");
		fundService = (FundService) ctx.getBean("fundService");
		userService = (UserService) ctx.getBean("userService");
		productService = (ProductService) ctx.getBean("productService");
	}

	
//获得各下游用户的报价单
	public String outcome(){
		
		Currentime ct = currentimeService.getCurrentime(Currentime.class,current-1);
		List<Order> orders = orderService.findOrder("from Order o where o.currentime = ? and o.oto = ?",new Object[]{ct,userid} );
		ActionContext.getContext().put("orders", orders);
	    return "outcome";
 
	}
	
//根据报价单出库
public String outcome2(){
		
		Currentime ct = currentimeService.getCurrentime(Currentime.class,current);
		User user = userService.getUser(User.class, userid);
		List<Inventory> inventories = inventoryService.findInventory(
				"from Inventory i where i.user = ? and i.currentime = ?",
				new Object[] { user, ct });
		Inventory inventory = inventories.get(0);

		// 出庫量不能为空
		if (bill.getCountp1() == null || bill.getCountp2() == null
				|| bill.getCountp3() == null) {
			ActionContext.getContext().put("message", Message.msg10);
			return "null";
		}

		// 判断填写数量不能大于库存量
		if (bill.getCountp1() > inventory.getCurrentp1()
				|| bill.getCountp2() > inventory.getCurrentp2()
				|| bill.getCountp3() > inventory.getCurrentp3()){
			ActionContext.getContext().put("message", Message.msg21);
			return "kcbz";
		} else {

			bill.setCurrentime(ct);
			bill.setP1lack(bill.getP1lack()-bill.getCountp1());
			bill.setP2lack(bill.getP2lack()-bill.getCountp2());
			bill.setP3lack(bill.getP3lack()-bill.getCountp3());
			billService.saveBill(bill);

			inventory.setCurrentp1(inventory.getCurrentp1() - bill.getCountp1());
			inventory.setCurrentp2(inventory.getCurrentp2() - bill.getCountp2());
			inventory.setCurrentp3(inventory.getCurrentp3() - bill.getCountp3());
			inventory.setInventoryid(inventory.getInventoryid());
			inventoryService.updateInventory(inventory);

			List<Fund> funds = fundService.findFund(
					"from Fund f where f.user = ? and f.currentime = ?",
					new Object[] { user, ct });
			Fund fund = funds.get(0);
			int totle = bill.getCountp1() * bill.getP1price()
					+ bill.getCountp2() * bill.getP2price() + bill.getCountp3()
					* bill.getP3price();
			int currency = fund.getCurrentmoney() + totle;
			fund.setCurrentmoney(currency);
			fundService.updateFund(fund);

			ActionContext.getContext().put("message", Message.msg9);
			return "success";
		}

	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getCurrentime() {
		return currentime;
	}

	public void setCurrentime(int currentime) {
		this.currentime = currentime;
	}

	

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}


	public int getCurrent() {
		return current;
	}


	public void setCurrent(int current) {
		this.current = current;
	}


	@Override
	public Bill getModel() {
		// TODO Auto-generated method stub
		return bill;
	}


}