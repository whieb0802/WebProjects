package com.scs.action;

import java.util.List;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scs.model.Bill;
import com.scs.model.Currentime;
import com.scs.model.Relation;
import com.scs.model.Role;
import com.scs.model.User;
import com.scs.service.BillService;
import com.scs.service.CurrentimeService;
import com.scs.service.RoleService;

public class BillAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private int current;
	
	private CurrentimeService currentimeService;
	private RoleService roleService;
	private BillService billService;
	
	public BillAction(){
		
	}
	
	//bill有欠货量+发货量 即可求出来需求量
	public String selectBill(){
			
		    User user = (User) ActionContext.getContext().getSession().get("user");
			Currentime currentime = currentimeService.getCurrentime(Currentime.class, current);
			List<Bill> bills = billService.findBill("from Bill b where b.bfrom = ?  and b.currentime <= ?", new Object[]{user.getUserid(),currentime});
			
			ActionContext.getContext().put("bills", bills);
			return "select";
	}
	
	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
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

	public BillService getBillService() {
		return billService;
	}
    @Resource
	public void setBillService(BillService billService) {
		this.billService = billService;
	}
}
