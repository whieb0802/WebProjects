package com.scs.action;

import java.util.List;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scs.model.Bill;
import com.scs.model.Currentime;
import com.scs.model.Message;
import com.scs.model.Product;
import com.scs.model.Relation;
import com.scs.model.Role;
import com.scs.model.Storage;
import com.scs.model.Storageinfo;
import com.scs.model.User;
import com.scs.service.BillService;
import com.scs.service.CurrentimeService;
import com.scs.service.ProductService;
import com.scs.service.RoleService;
import com.scs.service.StorageService;
import com.scs.service.StorageinfoService;
import com.scs.service.UserService;

public class ManufacturerAction extends ActionSupport implements ModelDriven<Bill> {
	private static final long serialVersionUID = 1L;

	private int currentime;
	private int current;

	private CurrentimeService currentimeService;
	private BillService billService;
	private UserService userService;
	private ProductService productService;
	private RoleService roleService;
	private StorageinfoService storageinfoService;
	private StorageService storageService;

	private Storage storage;
	Bill bill = new Bill();

	public ManufacturerAction() {

	}

	// 下一批生产计划，填写t_bill
	public String produce() {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		Relation relation = (Relation)ActionContext.getContext().getSession().get("relation");
		Currentime ct = currentimeService.getCurrentime(Currentime.class,
				current);
		Role role = relation.getRole();

		// 生产量不能为空
		if (bill.getCountp1() == null || bill.getCountp2() == null
				|| bill.getCountp3() == null) {
			ActionContext.getContext().put("message", Message.msg10);
			return "null";
		}

		// 判断是否已经制定本周生产计划
		if (billService.ifexists(user.getUserid(), user.getUserid(), ct)) {

			ActionContext.getContext().put("message", Message.msg30);
			return "exists";
		}

		else {

			List<Product> products = productService.findProduct(
					"from Product p where p.role = ?", role);

			bill.setCurrentime(ct);
			bill.setBfrom(user.getUserid());
			bill.setBto(user.getUserid());
			bill.setP1price(products.get(0).getIcost());
			bill.setP2price(products.get(1).getIcost());
			bill.setP3price(products.get(2).getIcost());
			bill.setP1lack(0);
			bill.setP2lack(0);
			bill.setP3lack(0);
			bill.setReceivetime(products.get(0).getAdvance() + current - 1);
			bill.setIscomplete(-1);
			billService.saveBill(bill);

			ActionContext.getContext().put("message", Message.msg29);
			return "success";
		}

	}

	public String factoryinfo() {
		Relation relation = (Relation)ActionContext.getContext().getSession().get("relation");
		List<Storageinfo> storageinfos = storageinfoService.findStorageinfo(
				"from Storageinfo s where s.role = ?", relation.getRole());

		ActionContext.getContext().put("storageinfos", storageinfos);
		ActionContext.getContext().put("currentime", current);
		return "info";
	}

	public String addfactory() {

		User user = (User) ActionContext.getContext().getSession().get("user");
		Currentime currenTime = currentimeService.getCurrentime(
				Currentime.class, current);
		if (storage.getBuy1count() == null)
			storage.setBuy1count(0);
		if (storage.getBuy2count() == null)
			storage.setBuy2count(0);
		if (storage.getBuy3count() == null)
			storage.setBuy3count(0);
		if (storage.getRent1count() == null)
			storage.setRent1count(0);
		if (storage.getRent2count() == null)
			storage.setRent2count(0);
		if (storage.getRent3count() == null)
			storage.setRent3count(0);
		List<Storage> list1 = storageService.findStorage(
				"from Storage s where s.user = ? and s.currentime = ? ",
				new Object[] { user, currenTime });
		Storage newstorage = list1.get(0);

		newstorage.setBuy1count(newstorage.getBuy1count()
				+ storage.getBuy1count());
		newstorage.setBuy2count(newstorage.getBuy2count()
				+ storage.getBuy2count());
		newstorage.setBuy3count(newstorage.getBuy3count()
				+ storage.getBuy3count());
		newstorage.setRent2count(newstorage.getRent2count()
				+ storage.getRent2count());
		newstorage.setRent1count(newstorage.getRent1count()
				+ storage.getRent1count());
		newstorage.setRent3count(newstorage.getRent3count()
				+ storage.getRent3count());

		newstorage.setUser(user);
		newstorage.setCurrentime(currenTime);

		storageService.updateStorage(newstorage);

		ActionContext.getContext().put("message", Message.msg35);
		return "addfactory";
	}

	// 右侧查看厂房信息功能
	public String info() {

		User user = (User) ActionContext.getContext().getSession().get("user");
		Currentime currenTime = currentimeService.getCurrentime(
				Currentime.class, current);
		List<Storage> storages = storageService.findStorage(
				"from Storage s where s.user = ? and s.currentime = ? ",
				new Object[] { user, currenTime });

		ActionContext.getContext().put("storages", storages);
		return "ckcfxx";
	}

	public int getCurrentime() {
		return currentime;
	}

	public void setCurrentime(int currentime) {
		this.currentime = currentime;
	}


	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
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

	public BillService getBillService() {
		return billService;
	}

	@Resource
	public void setBillService(BillService billService) {
		this.billService = billService;
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

	public StorageinfoService getStorageinfoService() {
		return storageinfoService;
	}

	@Resource
	public void setStorageinfoService(StorageinfoService storageinfoService) {
		this.storageinfoService = storageinfoService;
	}

	public StorageService getStorageService() {
		return storageService;
	}

	@Resource
	public void setStorageService(StorageService storageService) {
		this.storageService = storageService;
	}

}