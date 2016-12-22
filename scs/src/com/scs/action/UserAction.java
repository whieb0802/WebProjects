package com.scs.action;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scs.model.Area;
import com.scs.model.Currentime;
import com.scs.model.Fund;
import com.scs.model.Growline;
import com.scs.model.Inventory;
import com.scs.model.Message;
import com.scs.model.Product;
import com.scs.model.Relation;
import com.scs.model.Role;
import com.scs.model.Storage;
import com.scs.model.User;
import com.scs.service.AreaService;
import com.scs.service.CurrentimeService;
import com.scs.service.FundService;
import com.scs.service.GrowlineService;
import com.scs.service.InventoryService;
import com.scs.service.ProductService;
import com.scs.service.RelationService;
import com.scs.service.RoleService;
import com.scs.service.StorageService;
import com.scs.service.UserService;
import com.scs.util.FinanceManage;
import com.scs.util.page.PageBean;
import com.scs.util.page.PageView;
import com.scs.util.page.ResultType;
import com.scs.util.page.UtilDao;

public class UserAction extends ActionSupport implements ModelDriven<PageBean> {
	private static final long serialVersionUID = 1L;

	PageBean pageBean = new PageBean();
	Map<String, Object> request;
	UtilDao ud;
	private UserService userService;
	private CurrentimeService currentimeService;
	private RoleService roleService;
	private AreaService areaService;
	private FundService fundService;
	private InventoryService inventoryService;
	private ProductService productService;
	private RelationService relationService;
	private StorageService storageService;
	private GrowlineService growlineService;
	
	User user = (User) ActionContext.getContext().getSession().get("user");
	Relation  relation = (Relation) ActionContext.getContext().getSession().get("relation");
	

	@SuppressWarnings("unchecked")
	public UserAction() {
		request = (Map<String, Object>) ActionContext.getContext().get(
				"request");
	}

	public String excute() {
		return "succss";
	}

	//关于状态值的改变，自己的状态值为0即代表自己可以开始，开始后更改为-1
	public String dqks() {
		User user = (User) ActionContext.getContext().getSession().get("session");
		if(user.getIscomplete() == 0){
			user.setIscomplete(-1);
			userService.updateUser(user);
			ActionContext.getContext().put("message", Message.msg3);
			return SUCCESS;
		}else{
			ActionContext.getContext().put("message", Message.msg4);
			return ERROR;
		}
	}
	//关于状态值，只要点击“本周结束”，就会更改为1，最后一个完成的人点击后时期增加1,所有人的状态值都改为0
	public String dqjs() {
		String changeFund = changeFund();
	
		if (changeFund.equals("failed")) {
			request.put("message", Message.msg19);
		} else {
			Currentime currentime = new Currentime();
			List<Currentime> list1 = currentimeService
					.findCurrentime("from Currentime");
			user.setIscomplete(1);
			userService.updateUser(user);
			List<User> list2 = userService.findUser("from User");
			int a = 1;
			for (User u : list2) {
				if (u.getIscomplete() != 1) {
					a = 0;
					break;
				}
			}
			
			if (a == 1) {
				//本周最后一个人结束成功后，把所有人的状态值更新为0；
				List<User> list3 = userService.findUser("from User");
				for (User u : list3) {
					u.setIscomplete(0);
					userService.updateUser(u);
				}
				currentime.setCurrentime(list1.get(list1.size() - 1).getCurrentime() + 1);
				currentimeService.saveCurrentime(currentime);
				addFund();
			}
			ActionContext.getContext().put("message", Message.msg13);
		}
		return "dqjs";
	}

	public String changeFund() {
		FinanceManage financeManage = new FinanceManage();


		Role role = roleService.getRole(Role.class, relation.getRole().getRoleid());
		List<Currentime> list3 = currentimeService.findCurrentime("from Currentime");
		List<Fund> funds1 = fundService.findFund("from Fund f where f.user = ? and f.currentime = ?",
				new Object[] { user, list3.get(list3.size() - 1) });
		List<Inventory> listInventory = inventoryService.findInventory("from Inventory i where i.user=? and i.currentime=?",
				new Object[] { user, list3.get(list3.size() - 1) });
		List<Product> listProduct1 = productService.findProduct("from Product p where p.role=?", role);

		// List<Product> listProduct1 =
		// productService.findProduct("from Product p where p.role=? and p.productid=?",
		// new Object[] {role, 1 });
		// List<Product> listProduct2 =
		// productService.findProduct("from Product p where p.role=? and p.productid=?",
		// new Object[] {role, 2 });
		// List<Product> listProduct3 =
		// productService.findProduct("from Product p where p.role=? and p.productid=?",
		// new Object[] {role, 3 }) ;
		int storageCostCount = listInventory.get(0).getCurrentp1()
				* listProduct1.get(0).getIcost() + listInventory.get(0).getCurrentp2()
				* listProduct1.get(1).getIcost() + listInventory.get(0).getCurrentp3()
				* listProduct1.get(2).getIcost();
		int rentBedMoney = 0;
		rentBedMoney = financeManage.rentCost(role, user, list3.get(list3.size()-1));
		Fund fund1 = funds1.get(0);
		float totalCost = fund1.getInterest() + rentBedMoney + storageCostCount;
		if (totalCost > fund1.getCurrentmoney()) {
			return "failed";
		} else {
			fund1.setCurrentmoney((int)(fund1.getCurrentmoney() - totalCost));
			fundService.updateFund(fund1);
			return "successed";
		}
	}
	
//每周结束后，每个人<资金表>增加一条记录；
	public void addFund() {

		List<Currentime> currentimelist = currentimeService.findCurrentime("from Currentime");
		Currentime currentime = currentimelist.get(currentimelist.size() - 2);
		Currentime currentime2 = currentimelist.get(currentimelist.size() - 1);
		List<User> userlist = userService.findUser("from User");
		for (User u : userlist) {
			
			
			
			//每周结束后，每个人<资金表>增加一条记录；
			List<Fund> funds = fundService.findFund(
					"from Fund f where f.user = ? and f.currentime = ?",
					new Object[] { u, currentime });
			
			Fund fund = funds.get(0);
			fund.setCurrentime(currentime2);
			fund.setCurrentloan(0);
			fund.setRemaintime(fund.getRemaintime() - 1);
			fundService.saveFund(fund);
			
			//每周结束后，每个人<库存表>增加一条记录；
			List<Inventory> inventories = inventoryService.findInventory(
					"from Inventory i where i.user = ? and i.currentime = ?",
					new Object[] { u, currentime });
			
			Inventory inventory = inventories.get(0);
			inventory.setCurrentime(currentime2);
			inventory.setP1in(0);
			inventory.setP2in(0);
			inventory.setP3in(0);
			inventory.setP1out(0);
			inventory.setP2out(0);
			inventory.setP3out(0);
			inventoryService.saveInventory(inventory);
			
			//每周结束后，每个人<仓库表>增加一条记录；
			List<Storage> storages = storageService.findStorage("from Storage s where s.user = ? and s.currentime = ?",
					new Object[] { u, currentime });
			Storage storage = storages.get(0);
			storage.setCurrentime(currentime2);
			storageService.saveStorage(storage);
			
			//每周结束后，每个生产商<生产线表>增加一条记录；
			if(relationService.findRelation("from Relation r where r.userid = ?", u.getUserid()).get(0).getRole().getRoleid()==1){
				List<Growline> growlines = growlineService.findGrowline("from Growline g where g.user = ? and g.currentime = ?",new Object[] { u, currentime });
				Growline growline = growlines.get(0);
				growline.setCurrentime(currentime2);
				growlineService.saveGrowline(growline);
			}
			
			
		}
	}
	


	public String userList() {
		List<Role> role = roleService.findRole("from Role");
		List<Area> area = areaService.findArea("from Area");
		request.put("role", role);
		request.put("area", area);
		PageView<User> pageView = new PageView<User>(8, pageBean.getPage());
		ResultType<User> qr = ud.fenye(User.class, pageView.getFirstResult(),
				pageView.getMaxResult());
		pageView.setResultType(qr);
		request.put("pageView", pageView);
		return SUCCESS;
	}

	// 本周还原，除订单之外所以本周数据清空
	public String back() {
		// 恢复本周开始前状态

		return "back";
	}

	public PageBean getModel() {
		return pageBean;
	}

	
	public UserService getUserService() {
		return userService;
	}
    @Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public CurrentimeService getCurrentimeService() {
		return currentimeService;
	}
	@Resource
	public void setCurrentimeService(CurrentimeService currentimeService) {
		this.currentimeService = currentimeService;
	}

	public RoleService getRoleService() {
		return roleService;
	}
	@Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public AreaService getAreaService() {
		return areaService;
	}
	@Resource
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	public FundService getFundService() {
		return fundService;
	}
	@Resource
	public void setFundService(FundService fundService) {
		this.fundService = fundService;
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

	public RelationService getRelationService() {
		return relationService;
	}
	@Resource
	public void setRelationService(RelationService relationService) {
		this.relationService = relationService;
	}

	public StorageService getStorageService() {
		return storageService;
	}
	@Resource
	public void setStorageService(StorageService storageService) {
		this.storageService = storageService;
	}

	public GrowlineService getGrowlineService() {
		return growlineService;
	}
	@Resource
	public void setGrowlineService(GrowlineService growlineService) {
		this.growlineService = growlineService;
	}
}
