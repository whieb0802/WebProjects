package com.scs.action;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scs.model.Bill;
import com.scs.model.Currentime;
import com.scs.model.Message;
import com.scs.model.Order;
import com.scs.model.Product;
import com.scs.model.Role;
import com.scs.service.BillService;
import com.scs.service.CurrentimeService;
import com.scs.service.OrderService;
import com.scs.service.ProductService;
import com.scs.service.RoleService;



public class OrdeTest{
	
	private static final long serialVersionUID = 1L;
	private Order order;
	private int current = 1;
	private int userid = 3;
	private int upstream = 2;
	Map<String, Object> request;
	
	OrderService orderService;
	CurrentimeService currentimeService;
	RoleService roleService;
	ProductService productService;
	BillService billService;
	
	public OrdeTest(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		orderService = (OrderService) ctx.getBean("orderService");
		currentimeService = (CurrentimeService) ctx.getBean("currentimeService");
		roleService = (RoleService) ctx.getBean("roleService");
		productService = (ProductService) ctx.getBean("productService");
		billService = (BillService) ctx.getBean("billService");
		
	}
	
    @Test
	public void retailer(){
		 Currentime currentime = currentimeService.getCurrentime(Currentime.class, current);
		
		
		 if(orderService.ifexists(userid, upstream, currentime)){
			System.out.println("exists");		    }
	
		
	} 
	
	
	public String selectOrder(){
		
		List<Order> orders = orderService.findOrder("from Order o where o.ofrom = ?",userid);
		Currentime currentime = currentimeService.getCurrentime(Currentime.class, current);
		Role role = roleService.getRole(Role.class, 3);

		//得到提前期和产品名
		List<Product> products1 = productService.findProduct("from Product p where p.role = ? and p.productid= ?", new Object[]{role,1});
		List<Product> products2 = productService.findProduct("from Product p where p.role = ? and p.productid= ?", new Object[]{role,2});
		List<Product> products3 = productService.findProduct("from Product p where p.role = ? and p.productid= ?", new Object[]{role,3});
		Product p1 = products1.get(0);
		Product p2 = products2.get(0);
		Product p3 = products3.get(0);

		//取得发货时间，找到到货bill
		Currentime currentime1 = currentimeService.getCurrentime(Currentime.class, current-p1.getAdvance());
		Currentime currentime2 = currentimeService.getCurrentime(Currentime.class, current-p2.getAdvance());
		Currentime currentime3 = currentimeService.getCurrentime(Currentime.class, current-p3.getAdvance());
		
		List<Bill> bills1 = billService.findBill("from bill b where b.bfrom = ? and b.bto = ? and b.currentime = ?", new Object[]{upstream,userid,currentime1});
		List<Bill> bills2 = billService.findBill("from bill b where b.bfrom = ? and b.bto = ? and b.currentime = ?", new Object[]{upstream,userid,currentime2});
		List<Bill> bills3 = billService.findBill("from bill b where b.bfrom = ? and b.bto = ? and b.currentime = ?", new Object[]{upstream,userid,currentime3});
		Bill bill1 = bills1.get(0);
		Bill bill2 = bills2.get(0);
		Bill bill3 = bills3.get(0);
		
		request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("orders", orders);
		request.put("p1", p1);
		request.put("p2", p2);
		request.put("p3", p3);
		request.put("b1", bill1);
		request.put("b2", bill2);
		request.put("b3", bill3);
		
		
		return "select";
	}
	
	
	//订单量有欠货量+发货量 即可求出来 order量
	@Test
	public void selectOrder2(){
			
			Currentime currentime = currentimeService.getCurrentime(Currentime.class, 1);
			Role role = roleService.getRole(Role.class, 3);

			//得到提前期和产品名P1p2p3提前期相同  
			List<Product> products1 = productService.findProduct("from Product p where p.role = ? and p.productid= ?", new Object[]{role,1});
			Product p1 = products1.get(0);
			int billtime = 1 - p1.getAdvance() + 1; //得到到货时间time = 2

			//取得发货时间，找到到货bill
			Currentime bt = currentimeService.getCurrentime(Currentime.class, billtime);
			
			List<Bill> bills = billService.findBill("from Bill b where b.bfrom = ? and b.bto = ? and b.currentime >= ?", new Object[]{upstream,userid,bt});
			System.out.println(bills.get(0).getCountp1());
			System.out.println(bills.get(1).getCountp1());
			System.out.println(bills.get(2).getCountp1());
		}
	
	
	@Test
	public void selectall(){
		
		Currentime currentime = currentimeService.getCurrentime(Currentime.class, 1);
		Role role = roleService.getRole(Role.class, 3);

		//得到提前期和产品名P1p2p3提前期相同  
		List<Product> products1 = productService.findProduct("from Product p where p.role = ? and p.productid= ?", new Object[]{role,1});
		Product p1 = products1.get(0);
		int billtime = 1 - p1.getAdvance() + 1; //得到到货时间time = 2

		//取得发货时间，找到到货bill
		Currentime bt = currentimeService.getCurrentime(Currentime.class, billtime);
		List<Bill> bills = billService.findBill("from Bill b where b.bfrom = ? and b.bto = ? and b.currentime >= ?", new Object[]{upstream,userid,bt});
		System.out.println(bills.get(0).getBfrom());
		System.out.println(bills.get(1).getBfrom());
		System.out.println(bills.get(2).getBfrom());
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public int getUpstream() {
		return upstream;
	}


	public void setUpstream(int upstream) {
		this.upstream = upstream;
	}

}
