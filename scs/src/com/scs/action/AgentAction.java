package com.scs.action;

import java.util.List;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scs.model.Currentime;
import com.scs.model.Fund;
import com.scs.model.Inventory;
import com.scs.model.Message;
import com.scs.model.Order;
import com.scs.model.Product;
import com.scs.model.Role;
import com.scs.model.Bill;
import com.scs.model.User;
import com.scs.service.BillService;
import com.scs.service.CurrentimeService;
import com.scs.service.FundService;
import com.scs.service.InventoryService;
import com.scs.service.OrderService;
import com.scs.service.ProductService;
import com.scs.service.RoleService;
import com.scs.service.UserService;

public class AgentAction extends ActionSupport implements ModelDriven<Bill>{
	private static final long serialVersionUID = 1L;

	private int userid;
	private int roleid;
	private int currentime;
	private int current;
	private Bill bill = new Bill();

	private CurrentimeService currentimeService;
	private OrderService orderService;
	private BillService billService;
	private InventoryService inventoryService;
	private FundService fundService;
	private UserService userService;
	private ProductService productService;
	private RoleService roleService;

	public AgentAction() {
	}

//更新应收款
	public String addfund(){
		User user = userService.getUser(User.class, userid);
		Currentime ct = currentimeService.getCurrentime(Currentime.class,current);
		Role role = roleService.getRole(Role.class, roleid+1);

		// 得到提前期和产品名
		List<Product> products1 = productService.findProduct(
				"from Product p where p.role = ? and p.productid= ?",
				new Object[] { role, 1 });
		Product p1 = products1.get(0);
		int time = current - p1.getAdvance() + 1; // 得到到货时间

		Currentime bt = currentimeService.getCurrentime(Currentime.class,time);

		List<Bill> bills = billService.findBill("from Bill b where b.bfrom = ?  and b.currentime =? ",
						new Object[] { userid, bt });
		
		List<Fund> funds = fundService.findFund("from Fund f where f.user = ? and f.currentime = ?",
				new Object[] { user, ct });
		Fund fund = funds.get(0);
		int currency = fund.getCurrentmoney();
		
		for(Bill bill : bills){
			if(bill.getIscomplete() == 1){
				ActionContext.getContext().put("message", Message.msg34);
			    return "exists";
			}else{
		
		int totle = bill.getCountp1() * bill.getP1price() + bill.getCountp2()
			* bill.getP2price() + bill.getCountp3() * bill.getP3price();
		currency += totle;
		//更新应收款后，将bill状态值设为1，表示完成
		bill.setIscomplete(1);
		billService.updateBill(bill);
		}
	}
		fund.setFundid(fund.getFundid());
		fund.setCurrentmoney(currency);
		fundService.updateFund(fund);
		
		ActionContext.getContext().put("message", Message.msg25);
	    return "addedfund";
	 }
	
	
//获得各下游用户的报价单
	public String outcome(){
		
		Currentime bt = currentimeService.getCurrentime(Currentime.class,current-1);
		Currentime ct = currentimeService.getCurrentime(Currentime.class,current);
		List<Order> orders = orderService.findOrder("from Order o where o.currentime = ? and o.oto = ? and o.iscomplete = ?",new Object[]{bt,userid,0} );
		List<Bill> bills =  billService.findBill("from Bill b where b.currentime = ? and b.bfrom = ?",new Object[]{ct,userid});
		ActionContext.getContext().put("orders", orders);
		ActionContext.getContext().put("bills", bills);
	    return "outcome";
 
	}
	
//根据报价单出库
public String outcome2(){
		
		Currentime ct = currentimeService.getCurrentime(Currentime.class,current);
		User user = userService.getUser(User.class, bill.getBfrom());
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
				|| bill.getCountp3() > inventory.getCurrentp3()) {
			ActionContext.getContext().put("message", Message.msg21);
			return "kcbz";
		} else {
			
			Role role = roleService.getRole(Role.class, roleid);
			// 得到提前期和产品名
			List<Product> products1 = productService.findProduct(
					"from Product p where p.role = ? and p.productid= ?",
					new Object[] { role, 1 });
			Product p1 = products1.get(0);
			bill.setCurrentime(ct);
			bill.setP1lack(bill.getP1lack()-bill.getCountp1());
			bill.setP2lack(bill.getP2lack()-bill.getCountp2());
			bill.setP3lack(bill.getP3lack()-bill.getCountp3());
			bill.setReceivetime(p1.getAdvance()+1);
			bill.setIscomplete(-1);
			billService.saveBill(bill);

			inventory.setCurrentp1(inventory.getCurrentp1() - bill.getCountp1());
			inventory.setCurrentp2(inventory.getCurrentp2() - bill.getCountp2());
			inventory.setCurrentp3(inventory.getCurrentp3() - bill.getCountp3());
			inventory.setP1out(bill.getCountp1());
			inventory.setP2out(bill.getCountp2());
			inventory.setP3out(bill.getCountp3());
			inventory.setP1totalout(inventory.getP1totalout() + bill.getCountp1());
			inventory.setP2totalout(inventory.getP2totalout() + bill.getCountp2());
			inventory.setP3totalout(inventory.getP3totalout() + bill.getCountp3());
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

			int time = bill.getCurrentime().getCurrentime() - 1; // 得到填写订单时间
			Currentime bt = currentimeService.getCurrentime(Currentime.class,time);
			List<Order> orders = orderService.findOrder("from Order o where o.currentime = ? and o.oto = ? and o.ofrom = ?",new Object[]{bt,bill.getBfrom(),bill.getBto()} );
			Order order = orders.get(0);
			order.setIscomplete(1);
			orderService.updateOrder(order);
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
	public CurrentimeService getCurrentimeService() {
		return currentimeService;
	}
	@Resource
	public void setCurrentimeService(CurrentimeService currentimeService) {
		this.currentimeService = currentimeService;
	}

	public OrderService getOrderService() {
		return orderService;
	}
	@Resource
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public BillService getBillService() {
		return billService;
	}
	@Resource
	public void setBillService(BillService billService) {
		this.billService = billService;
	}

	public InventoryService getInventoryService() {
		return inventoryService;
	}
	@Resource
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	public FundService getFundService() {
		return fundService;
	}
	@Resource
	public void setFundService(FundService fundService) {
		this.fundService = fundService;
	}

	public UserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
    
	public ProductService getProductService() {
		return productService;
	}
	@Resource
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public RoleService getRoleService() {
		return roleService;
	}
    @Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}


}