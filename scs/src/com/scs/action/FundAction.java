package com.scs.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scs.model.Currentime;
import com.scs.model.Fund;
import com.scs.model.Message;
import com.scs.model.Relation;
import com.scs.model.Role;
import com.scs.model.User;
import com.scs.service.CurrentimeService;
import com.scs.service.FundService;
import com.scs.service.RoleService;
import com.scs.service.UserService;

public class FundAction extends ActionSupport {

	private int currentime;
	private int currentloan;
	private int loantime;
	
	private FundService fundService;
	private UserService userService;
	private CurrentimeService currentimeService;
	private RoleService roleService;
	
	public FundAction() {
	}

	public String financeSet() {
		return "financeSet";
	}
	
	public String newloan(){
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		Currentime currenTime = currentimeService.getCurrentime(Currentime.class, currentime);
		if(fundService.ifexists(user, currenTime)){
			
			ActionContext.getContext().put("message", Message.msg22);
	    	return "exists";			
		}else{
			
		Relation relation = (Relation) ActionContext.getContext().getSession().get("relation");
		Role  role = relation.getRole();
		
	    List<Fund> funds = fundService.findFund("from Fund f where f.user = ? and f.currentime = ? ", new Object[]{user,currenTime});
	    Fund fund = funds.get(0);
	    int tloan = fund.getTotaloan() + currentloan;
	    
	    if(tloan > role.getMaxloan()){
	    	ActionContext.getContext().put("message", Message.msg2);
	    	return "loanfail";
	    }
	    else{
	    	
	    	fund.setCurrentloan(currentloan);
	    	fund.setCurrentmoney(fund.getCurrentmoney() + currentloan);
	    
	    	fund.setTotaloan(tloan);
	    	fund.setInterest(tloan*role.getInterestrate());
	    	fund.setRemaintime(loantime);
	    	fundService.updateFund(fund);
	       	
	    	ActionContext.getContext().put("message", Message.msg1);
	       	return "loansuccess";
	   }
	 }
	}


	public int getCurrentime() {
		return currentime;
	}

	public void setCurrentime(int currentime) {
		this.currentime = currentime;
	}

	public int getCurrentloan() {
		return currentloan;
	}

	public void setCurrentloan(int currentloan) {
		this.currentloan = currentloan;
	}

	public int getLoantime() {
		return loantime;
	}

	public void setLoantime(int loantime) {
		this.loantime = loantime;
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
	
	
}
