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
import com.scs.model.Groupinfo;
import com.scs.model.Growline;
import com.scs.model.Inventory;
import com.scs.model.Relation;
import com.scs.model.Role;
import com.scs.model.Storage;
import com.scs.model.User;
import com.scs.service.CurrentimeService;
import com.scs.service.FundService;
import com.scs.service.GroupinfoService;
import com.scs.service.GrowlineService;
import com.scs.service.InventoryService;
import com.scs.service.RelationService;
import com.scs.service.StorageService;
import com.scs.service.UserService;
import com.scs.util.Group;

public class GroupAction extends ActionSupport implements ModelDriven<Groupinfo>{
	
	private int userid;
	
	private GroupinfoService groupinfoService;
	private UserService userService;
	private CurrentimeService currentimeService;
	private RelationService relationService;
	private StorageService storageService;
	private FundService fundService;
	private InventoryService inventoryService;
	private GrowlineService growlineService ;
	
	Groupinfo groupInfo = new Groupinfo();
	Map<String,Object> request;
   

	public GroupAction(){
		request = (Map<String, Object>) ActionContext.getContext().get("request");
	}
	
	public String updateGroupInfo(){
		List<Groupinfo> list = groupinfoService.findGroupinfo("from Groupinfo");
		list.get(list.size()-1).setGroupCount(groupInfo.getGroupCount());
		list.get(list.size()-1).setManCount(groupInfo.getManCount());
		list.get(list.size()-1).setAgentCount(groupInfo.getAgentCount());
		list.get(list.size()-1).setRetailerCount(groupInfo.getRetailerCount());
		groupinfoService.updateGroupinfo(list.get(list.size()-1));
		return "updateGroupInfo";
	}
	
	public String groupInfoGet(){
		Groupinfo groupInfo = groupinfoService.getGroupinfo(Groupinfo.class,1);
		request.put("groupInfo", groupInfo);
		return "groupInfoGet";
	}
	
	public String commonGroup(){
		Area area = relationService.getRelation(Relation.class, userid).getArea();
		List<Relation> list = relationService.findRelation("from Relation r where r.area=?", area);
		request.put("list", list);
		return "commonGroup";
	}
	
	public String groupBegin(){
		
		List<User> list = userService.findUser("from User");
		Group group = new Group();
		group.saveRelation();
		group.groupBegin();
		Currentime currentime = currentimeService.getCurrentime(Currentime.class, 1);
		Fund fund = new Fund();
		Storage storage = new Storage();
		Growline growline = new Growline();
		Inventory inventory = new Inventory();
		for(User u:list){
			
			u.setIscomplete(0);
			userService.updateUser(u);
			
			Role role = relationService.getRelation(Relation.class, u.getUserid()).getRole();
			fund.setCurrentime(currentime);
			fund.setUser(u);
			fund.setCurrentloan(0);
			fund.setCurrentmoney(role.getInitialmoney());
			fund.setInterest(0f);
			fund.setTotaloan(0);
			fund.setTotaloan(0);
			fund.setRemaintime(0);
			fundService.saveFund(fund);
			
			storage.setUser(u);
			storage.setCurrentime(currentime);
			storage.setBuy1count(role.getSmallStorage());
			storage.setBuy2count(role.getMiddleStorage());
			storage.setBuy3count(role.getBigStorage());
			storage.setRent1count(0);
			storage.setRent2count(0);
			storage.setRent3count(0);
			storageService.saveStorage(storage);
			
			inventory.setUser(u);
			inventory.setCurrentime(currentime);
			inventory.setCurrentp1(role.getInitialp1());
			inventory.setCurrentp2(role.getInitialp2());
			inventory.setCurrentp3(role.getInitialp3());
			inventory.setP1in(0);
			inventory.setP1out(0);
			inventory.setP2in(0);
			inventory.setP2out(0);
			inventory.setP3in(0);
			inventory.setP3out(0);
			inventory.setP1totalin(0);
			inventory.setP1totalout(0);
			inventory.setP2totalin(0);
			inventory.setP2totalout(0);
			inventory.setP3totalin(0);
			inventory.setP3totalout(0);
			inventoryService.saveInventory(inventory);
			
			if(role.getRoleid() == 1){
				growline.setUser(u);
				growline.setCurrentime(currentime);
				growline.setBuyp1growline(role.getP1growline());
				growline.setBuyp2growline(role.getP2growline());
				growline.setBuyp3growline(role.getP3growline());
				growline.setRentp1growline(0);
				growline.setRentp2growline(0);
				growline.setRentp3growline(0);
                growline.setIslarged(0);
                growlineService.saveGrowline(growline);
			}
		}
		return "groupBegin";
	}

	public Groupinfo getModel() {
		return groupInfo;
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public GroupinfoService getGroupinfoService() {
		return groupinfoService;
	}
    @Resource
	public void setGroupinfoService(GroupinfoService groupinfoService) {
		this.groupinfoService = groupinfoService;
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

	public GrowlineService getGrowlineService() {
		return growlineService;
	}
	@Resource
	public void setGrowlineService(GrowlineService growlineService) {
		this.growlineService = growlineService;
	}

}
