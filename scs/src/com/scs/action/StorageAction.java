package com.scs.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scs.model.Currentime;
import com.scs.model.Fund;
import com.scs.model.Message;
import com.scs.model.Relation;
import com.scs.model.Role;
import com.scs.model.Storage;
import com.scs.model.Storageinfo;
import com.scs.model.User;
import com.scs.service.CurrentimeService;
import com.scs.service.FundService;
import com.scs.service.RoleService;
import com.scs.service.StorageService;
import com.scs.service.StorageinfoService;
import com.scs.service.UserService;

public class StorageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	Map<String, Object> request;
	private String storagestatus ;
	private int currentime;
	private String rentype;
	private String buytype;
	
   	private UserService userService;
	private StorageinfoService storageinfoService;
	private CurrentimeService currentimeService;
	private RoleService roleService;
	private StorageService storageService;
	private FundService fundService;
	
	public StorageAction() {
		request = (Map<String,Object>) ActionContext.getContext().get("request");
	}
	
	public String rentStorage(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		Currentime currentime1 = currentimeService.getCurrentime(Currentime.class, currentime);
	    List<Storage> list1 = storageService.findStorage("from Storage s where s.user=? and s.currentime=?",new Object[]{user,currentime1});
		if(list1.size()==0){
			Storage storage1 = new Storage();
			if(rentype.equals("小仓库")){
				storage1.setCurrentime(currentime1);
				storage1.setUser(user);
				storage1.setRent1count(1);
				storage1.setBuy1count(0);
				storage1.setBuy2count(0);
				storage1.setBuy3count(0);
				storage1.setRent2count(0);
				storage1.setRent3count(0);
				storageService.saveStorage(storage1);
			}
			if(rentype.equals("中仓库")){
				storage1.setCurrentime(currentime1);
				storage1.setUser(user);
				storage1.setRent1count(0);
				storage1.setRent2count(1);
				storage1.setRent3count(0);
				storage1.setBuy1count(0);
				storage1.setBuy2count(0);
				storage1.setBuy3count(0);
				
				storageService.saveStorage(storage1);
			}
			if(rentype.equals("大仓库")){
				storage1.setCurrentime(currentime1);
				storage1.setUser(user);
				storage1.setRent1count(0);
				storage1.setRent2count(0);
				storage1.setRent3count(1);
				storage1.setBuy1count(0);
				storage1.setBuy2count(0);
				storage1.setBuy3count(0);
				storageService.saveStorage(storage1);
			}
		}else{
			Storage storage1 = list1.get(0);
			if(rentype.equals("小仓库")){
				storage1.setRent1count(storage1.getRent1count()+1);
				storageService.updateStorage(storage1);
			}
			if(rentype.equals("中仓库")){
				storage1.setRent2count(storage1.getRent2count()+1);
				storageService.updateStorage(storage1);
			}
			if(rentype.equals("大仓库")){
				storage1.setRent3count(storage1.getRent3count()+1);
				storageService.updateStorage(storage1);
			}
		}
		request.put("message",Message.msg16);
		
		return "rentsuccess";
	}
	
	public String buyStorage(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		Currentime currentime1 = currentimeService.getCurrentime(Currentime.class, currentime);
	    List<Storage> list1 = storageService.findStorage("from Storage s where s.user=? and s.currentime=?",new Object[]{user,currentime1});
		List<Fund> fund = fundService.findFund("from Fund f where f.user=? and f.currentime=?", new Object[]{user,currentime1});
		Role role = ((Relation) ActionContext.getContext().getSession().get("relation")).getRole();
		int storageid = 1;
		if(buytype.equals("中仓库")){
			storageid = 2;
		}
		if(buytype.equals("大仓库")){
	     	storageid = 3;
		}
		List<Storageinfo> list2 = storageinfoService.findStorageinfo("from Storageinfo s where s.storageid=? and s.role=?", new Object[]{storageid,role});
		
		if(list2.get(0).getBuyprice()>fund.get(0).getCurrentmoney()){
			request.put("message",Message.msg26);
		}else{
			fund.get(0).setCurrentmoney(fund.get(0).getCurrentmoney()-list2.get(0).getBuyprice());
			fundService.updateFund(fund.get(0));
			if(list1.size()==0){
				Storage storage1 = new Storage();
				if(buytype.equals("小仓库")){
					storage1.setCurrentime(currentime1);
					storage1.setUser(user);
					storage1.setRent1count(0);
					storage1.setRent2count(0);
					storage1.setRent3count(0);
					storage1.setBuy1count(1);
					storage1.setBuy2count(0);
					storage1.setBuy3count(0);
					storageService.saveStorage(storage1);
				}
				if(buytype.equals("中仓库")){
					storage1.setCurrentime(currentime1);
					storage1.setUser(user);
					storage1.setRent1count(0);
					storage1.setRent2count(0);
					storage1.setRent3count(0);
					storage1.setBuy1count(0);
					storage1.setBuy2count(1);
					storage1.setBuy3count(0);
					storageService.saveStorage(storage1);
				}
				if(buytype.equals("大仓库")){
					storage1.setCurrentime(currentime1);
					storage1.setUser(user);
					storage1.setRent1count(0);
					storage1.setRent2count(0);
					storage1.setRent3count(0);
					storage1.setBuy1count(0);
					storage1.setBuy2count(0);
					storage1.setBuy3count(1);
					storageService.saveStorage(storage1);
				}
			}else{
				Storage storage1 = list1.get(0);
				if(buytype.equals("小仓库")){
					storage1.setBuy1count(storage1.getBuy1count()+1);
					storageService.updateStorage(storage1);
				}
				if(buytype.equals("中仓库")){
					storage1.setBuy2count(storage1.getBuy2count()+1);
					storageService.updateStorage(storage1);
				}
				if(buytype.equals("大仓库")){
					storage1.setBuy3count(storage1.getBuy3count()+1);
					storageService.updateStorage(storage1);
				}
			}
			request.put("message",Message.msg20);
		}
		return "buysuccess";
	}

	//查看仓库基本信息
	public String info(){
		User user = (User) ActionContext.getContext().getSession().get("user");		
		Currentime currenTime = currentimeService.getCurrentime(Currentime.class, currentime);
	    List<Storage> storages = storageService.findStorage("from Storage s where s.user = ? and s.currentime = ? ",new Object[]{user,currenTime});
	    Storage storage = storages.get(0); 	
	    ActionContext.getContext().put("storage", storage);
	    return "storageinfo";
	}
	


	public String getStoragestatus() {
		return storagestatus;
	}

	public void setStoragestatus(String storagestatus) {
		this.storagestatus = storagestatus;
	}
	
	public int getCurrentime() {
		return currentime;
	}

	public void setCurrentime(int currentime) {
		this.currentime = currentime;
	}
	
	public String getRentype() {
		return rentype;
	}

	public void setRentype(String rentype) {
		this.rentype = rentype;
	}

	public String getBuytype() {
		return buytype;
	}

	public void setBuytype(String buytype) {
		this.buytype = buytype;
	}
	
	public UserService getUserService() {
		return userService;
	}
   @Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public StorageinfoService getStorageinfoService() {
		return storageinfoService;
	}
	@Resource
	public void setStorageinfoService(StorageinfoService storageinfoService) {
		this.storageinfoService = storageinfoService;
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

	public StorageService getStorageService() {
		return storageService;
	}
	@Resource
	public void setStorageService(StorageService storageService) {
		this.storageService = storageService;
	}

	public FundService getFundService() {
		return fundService;
	}
	@Resource
	public void setFundService(FundService fundService) {
		this.fundService = fundService;
	}

}
