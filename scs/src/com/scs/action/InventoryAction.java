package com.scs.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scs.model.Bill;
import com.scs.model.Currentime;
import com.scs.model.Fund;
import com.scs.model.Inventory;
import com.scs.model.Message;
import com.scs.model.Product;
import com.scs.model.Relation;
import com.scs.model.Role;
import com.scs.model.User;
import com.scs.service.BillService;
import com.scs.service.CurrentimeService;
import com.scs.service.FundService;
import com.scs.service.InventoryService;
import com.scs.service.ProductService;
import com.scs.service.RoleService;
import com.scs.service.UserService;
import com.scs.util.StorageCapacity;

public class InventoryAction extends ActionSupport implements ModelDriven<Bill> {
	private static final long serialVersionUID = 1L;
	private int currentime;
	private int current;
	private int billtime;

	private CurrentimeService currentimeService;
	private BillService billService;
	private InventoryService inventoryService;
	private FundService fundService;
	private UserService userService;
	private ProductService productService;
	private RoleService roleService;
	
	Bill bill = new Bill();

	public InventoryAction() {

	}

	public String retailerincome() {

			Role role = ((Relation)ActionContext.getContext().getSession().get("relation")).getRole();
			User user = (User) ActionContext.getContext().getSession().get("user");
			// 得到提前期和产品名
			List<Product> products1 = productService.findProduct("from Product p where p.role = ? and p.productid= ?",new Object[] { role, 1 });
			Product p1 = products1.get(0);
			// 得到到货时间
			int time = current - p1.getAdvance() + 1; 
			
			//前几周没有可以入库的产品，未发送任何订单
			if(time <= 0){
				ActionContext.getContext().put("message", Message.msg31);
				return "noincome";
			}

			Currentime ct = currentimeService.getCurrentime(Currentime.class,time);
			int up2 = ((Relation)ActionContext.getContext().getSession().get("relation")).getUpstream();
			List<Bill> bills = billService.findBill("from Bill b where b.bfrom = ? and b.bto = ? and b.currentime =? ",
							new Object[] { up2,user.getUserid(), ct });
			if(bills.size() == 0){
				ActionContext.getContext().put("message", Message.msg31);
				return "noincome";
			}else{
			Bill bill = bills.get(0);

			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("bill", bill);
			ActionContext.getContext().put("currentime", currentime);
			return "rincome";}
		}
    
	public String rbillconfirm() {

		User user = (User) ActionContext.getContext().getSession().get("user");
		Relation relation = (Relation)ActionContext.getContext().getSession().get("relation"); 
		Role role = relation.getRole();
		// 此處billtime為從bill單子中傳遞過來的
		Currentime bt = currentimeService.getCurrentime(Currentime.class,billtime);

		List<Bill> bills = billService.findBill(
						"from Bill b where b.bfrom = ? and b.bto = ? and b.currentime =? ",
						new Object[] {relation.getUpstream(), user.getUserid(), bt });
		Bill bill = bills.get(0);

		Currentime ct = currentimeService.getCurrentime(Currentime.class,current);
		List<Inventory> inventoris = inventoryService.findInventory(
				"from Inventory i where i.user = ? and i.currentime = ?",
				new Object[] { user, ct });
		Inventory inventory = inventoris.get(0);
		int p1 = bill.getCountp1();
	    int p2 = bill.getCountp2();
		int p3 = bill.getCountp3();
		
		//判断仓库是否已经不足
		if(StorageCapacity.isFull(user, role, bt, p1, p2, p3, inventory)){
			ActionContext.getContext().put("message", Message.msg27);
		}
		// 判断本周是否已经入库
		if (inventoryService.ifinexists(user, ct)){
			ActionContext.getContext().put("message", Message.msg33);
			return "outexists";
		} 
		else{
			List<Fund> funds = fundService.findFund("from Fund f where f.user = ? and f.currentime = ?",
					new Object[] { user, ct });
			Fund fund = funds.get(0);
			int totle = bill.getCountp1() * bill.getP1price() + bill.getCountp2()
					* bill.getP2price() + bill.getCountp3() * bill.getP3price();
			int currency = fund.getCurrentmoney() - totle;
			if (currency < 0) {
				ActionContext.getContext().put("message", Message.msg8);
			} else {
				inventory.setCurrentp1(bill.getCountp1() + inventory.getCurrentp1());
				inventory.setCurrentp2(bill.getCountp2() + inventory.getCurrentp2());
				inventory.setCurrentp3(bill.getCountp3() + inventory.getCurrentp3());
				
				inventory.setP1in(bill.getCountp1());
				inventory.setP2in(bill.getCountp2());
				inventory.setP3in(bill.getCountp3());
				inventory.setP1totalin(inventory.getP1totalout() + bill.getCountp1());
				inventory.setP2totalin(inventory.getP2totalout() + bill.getCountp2());
				inventory.setP3totalin(inventory.getP3totalout() + bill.getCountp3());
				inventoryService.updateInventory(inventory);				
				
				//入库后bill单状态更新为0，表示尚未收款
				bill.setIscomplete(0);
				billService.updateBill(bill);
				
				fund.setCurrentmoney(currency);
				fundService.updateFund(fund);
				ActionContext.getContext().put("message", Message.msg7);
			}
		}
		return "rbillconfirm";
	}

	public String retaileroutcome(){
		
		Currentime ct = currentimeService.getCurrentime(Currentime.class,current);
		User user = (User) ActionContext.getContext().getSession().get("user");
		List<Inventory> inventories = inventoryService.findInventory(
				"from Inventory i where i.user = ? and i.currentime = ?",
				new Object[] { user, ct });
		Inventory inventory = inventories.get(0);

		// 出庫量不能为空
		if (bill.getCountp1() == null || bill.getCountp2() == null
				|| bill.getCountp3() == null) {
			ActionContext.getContext().put("message", Message.msg10);
			return "outcomerror";
		}

		// 判断填写数量不能大于库存量
		if (bill.getCountp1() > inventory.getCurrentp1()
				|| bill.getCountp2() > inventory.getCurrentp2()
				|| bill.getCountp3() > inventory.getCurrentp3()) {
			ActionContext.getContext().put("message", Message.msg21);
			return "kcbz";
		} 
		
		// 判断本周是否已经出库
		if (inventoryService.ifoutexists(user, ct)){
			ActionContext.getContext().put("message", Message.msg32);
			return "outexists";
		} 
		
		else {
			bill.setBfrom(user.getUserid());
			bill.setCurrentime(ct);
			bill.setP1lack(bill.getP1lack()-bill.getCountp1());
			bill.setP2lack(bill.getP2lack()-bill.getCountp2());
			bill.setP3lack(bill.getP3lack()-bill.getCountp3());
			bill.setReceivetime(0);
			bill.setIscomplete(1);
			billService.saveBill(bill);

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

			ActionContext.getContext().put("message", Message.msg9);
			return "routcome";
		}
	}
		
	
	public String findall() {

		User user = (User) ActionContext.getContext().getSession().get("user");
		List<Inventory> inventories = inventoryService.findInventory(
						"from Inventory i where i.user = ? order by i.currentime",user);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("inventories", inventories);
		return "rfindall";
	}



	public int getCurrentime() {
		return currentime;
	}

	public void setCurrentime(int currentime) {
		this.currentime = currentime;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public int getBilltime() {
		return billtime;
	}

	public void setBilltime(int billtime) {
		this.billtime = billtime;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}
	
	@Override
	public Bill getModel() {
		return bill;
	}
	
	public CurrentimeService getCurrentimeService() {
		return currentimeService;
	}
    @Resource
	public void setCurrentimeService(CurrentimeService currentimeService) {
		this.currentimeService = currentimeService;
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