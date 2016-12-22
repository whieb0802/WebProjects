package com.scs.action;

import java.util.List;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scs.model.Currentime;
import com.scs.model.Growline;
import com.scs.model.Growlineinfo;
import com.scs.model.Message;
import com.scs.model.Relation;
import com.scs.model.User;
import com.scs.service.CurrentimeService;
import com.scs.service.GrowlineService;
import com.scs.service.GrowlineinfoService;
import com.scs.service.UserService;

public class GrowlineAction extends ActionSupport implements ModelDriven<Growline>{

	private int current;
	Growline growline = new Growline();
	
	GrowlineService growlineService;
	UserService userService;
	CurrentimeService currentimeService;
	GrowlineinfoService growlineinfoService;

	public String newline(){
	
		User user = (User) ActionContext.getContext().getSession().get("user");
		Currentime currenTime = currentimeService.getCurrentime(Currentime.class, current);
		if(growline.getBuyp1growline() == null) growline.setBuyp1growline(0);
		if(growline.getBuyp2growline() == null) growline.setBuyp2growline(0);
		if(growline.getBuyp3growline() == null) growline.setBuyp3growline(0);
		if(growline.getRentp1growline() == null) growline.setRentp1growline(0);
		if(growline.getRentp2growline() == null) growline.setRentp2growline(0);
		if(growline.getRentp3growline() == null) growline.setRentp3growline(0);
		 List<Growline> list1 = growlineService.findGrowline("from Growline g where g.user = ? and g.currentime = ? ",new Object[]{user,currenTime});
		 Growline newgrowline = list1.get(0);
		 newgrowline.setBuyp1growline(newgrowline.getBuyp1growline() + growline.getBuyp1growline());
		 newgrowline.setBuyp2growline(newgrowline.getBuyp2growline() + growline.getBuyp2growline());
		 newgrowline.setBuyp3growline(newgrowline.getBuyp3growline() + growline.getBuyp3growline());
		 newgrowline.setRentp1growline(newgrowline.getRentp1growline() + growline.getRentp1growline());
		 newgrowline.setRentp2growline(newgrowline.getRentp2growline() + growline.getRentp2growline());
		 newgrowline.setRentp3growline(newgrowline.getRentp3growline() + growline.getRentp3growline());
		 newgrowline.setUser(user);
		 newgrowline.setCurrentime(currenTime);
		
		 growlineService.updateGrowline(newgrowline);
	       	
	    ActionContext.getContext().put("message", Message.msg28);
	    return "newsuccess";
	}

	

	public String info(){
	    User user = (User) ActionContext.getContext().getSession().get("user");
  		Currentime currenTime = currentimeService.getCurrentime(Currentime.class, current);
		 List<Growline> growlines = growlineService.findGrowline("from Growline g where g.user = ? and g.currentime = ? ",new Object[]{user,currenTime});
	       	
	    ActionContext.getContext().put("growlines", growlines);
	    return "lineinfo";
	}
	
	//生产线扩大后的产能
	public String large(){
		
		List<Growlineinfo> growlineinfos = growlineinfoService.findGrowlineinfo("from Growlineinfo");
		
		ActionContext.getContext().put("growlineinfos", growlineinfos);
		ActionContext.getContext().put("current", current);
		return "largeinfo";
	}
	
	//扩大生产线
	public String newlarge(){
		
		
		return "newlarge";
	}
	


	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	@Override
	public Growline getModel() {
		// TODO Auto-generated method stub
		return growline;
	}
	
	public GrowlineService getGrowlineService() {
		return growlineService;
	}
    @Resource
	public void setGrowlineService(GrowlineService growlineService) {
		this.growlineService = growlineService;
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

	public GrowlineinfoService getGrowlineinfoService() {
		return growlineinfoService;
	}
	@Resource
	public void setGrowlineinfoService(GrowlineinfoService growlineinfoService) {
		this.growlineinfoService = growlineinfoService;
	}
	
}
