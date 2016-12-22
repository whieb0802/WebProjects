package com.scs.action;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scs.model.Currentime;
import com.scs.model.Fund;
import com.scs.model.Manager;
import com.scs.model.Message;
import com.scs.model.Relation;
import com.scs.model.Role;
import com.scs.model.User;
import com.scs.service.CurrentimeService;
import com.scs.service.FundService;
import com.scs.service.InventoryService;
import com.scs.service.ManagerService;
import com.scs.service.RelationService;
import com.scs.service.RoleService;
import com.scs.service.UserService;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	private RelationService relationService;
	private RoleService roleService;
	private CurrentimeService currentimeService;
	private InventoryService inventoryService;
	private FundService fundService;
	private ManagerService managerService;
	private Currentime currentime;
	private String username;
	private String password;
	private String manager;
	Map<String, Object> session;
	
	public String login() 
	{
		
		List<User> list1 = userService.findUser("from User u where u.username = ?", username);
		
		if (list1.size() == 0){
			ActionContext.getContext().put("message", Message.msg37);
			return "error";
		}
		else{
		
		User user = list1.get(0);
		if(user.getIscomplete()==null){
			ActionContext.getContext().put("message", Message.msg39);
			return "error";
		}
				
		if (password.equals(user.getPassword()))
		{
//			List<Currentime> ctlist = currentimeService.findCurrentime("from Currentime");
//			currentime = ctlist.get(ctlist.size()-1);
//			Currentime ct = currentimeService.getCurrentime(Currentime.class, currentime.getCurrentime());
			
//			List<Fund> funds = fundService.findFund("from Fund f where f.user = ? and f.currentime = ?",new Object[]{user,ct});
//			Fund fund = funds.get(0);
			
			List<Role> list2 = roleService.findRole("from Role");
			Relation re = relationService.getRelation(Relation.class, user.getUserid());
			
//			List<Inventory> inventories = inventoryService.findInventory("from Inventory i where i.user = ? and i.currentime = ? ",new Object[]{user,ct});
//			Inventory inventory = inventories.get(0);
			
			session = ActionContext.getContext().getSession();
		    HttpServletRequest request = ServletActionContext.getRequest();
			session.put("user", user);
//			session.put("currentime", ct);
//			request.setAttribute("fund", fund);
			session.put("relation", re);			
//			request.setAttribute("inventory", inventory);
			
		   if ((re.getRole().getRoleid()).equals(list2.get(0).getRoleid()))
				return "manufacturer";
			else if ((re.getRole().getRoleid()).equals(list2.get(1).getRoleid()))
				return "agent";
			else if ((re.getRole().getRoleid()).equals(list2.get(2).getRoleid()))
				return "retailer";
		}
		    ActionContext.getContext().put("message", Message.msg36);
			return "error";
		}
	}
	
	public String managerLogin(){
		List<Manager> list = managerService.findManager("from Manager");
		for(Manager m:list){
			if(m.getManager().equals(manager)&&m.getPassword().equals(password)){
				return "loginSuccess";
			}
		}
		ActionContext.getContext().put("message", Message.msg36);
		return "loginFail";
	}
	
	public String index(){
		
		   User user = (User) ActionContext.getContext().getSession().get("user");
		   List<Currentime> list2 = currentimeService.findCurrentime("from Currentime");
		   Currentime currenTime = list2.get(list2.size()-1);
		   List<Fund> funds = fundService.findFund("from Fund f where f.user = ? and f.currentime = ?",new Object[]{user,currenTime});
		   Fund fund = funds.get(0);
		   
		   ActionContext.getContext().put("fund", fund);
		   ActionContext.getContext().put("currentime", currenTime);
		
		   return "index";
	}

	
	public RelationService getRelationService() {
		return relationService;
	}
	public RoleService getRoleService() {
		return roleService;
	}
	public UserService getUserService() {
		return userService;
	}
	public CurrentimeService getCurrentimeService() {
		return currentimeService;
	}
	public InventoryService getInventoryService() {
		return inventoryService;
	}
	public FundService getFundService() {
		return fundService;
	}

	@Resource
	public void setRelationService(RelationService relationService) {
		this.relationService = relationService;
	}

	@Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Resource
	public void setCurrentimeService(CurrentimeService currentimeService) {
		this.currentimeService = currentimeService;
	}
	@Resource
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
    @Resource
	public void setFundService(FundService fundService) {
		this.fundService = fundService;
	}


	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Currentime getCurrentime() {
		return currentime;
	}

	public void setCurrentime(Currentime currentime) {
		this.currentime = currentime;
	}
	
	public ManagerService getManagerService() {
		return managerService;
	}
    @Resource
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
}
