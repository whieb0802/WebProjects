package com.scs.action;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scs.model.Role;
import com.scs.service.RoleService;

public class RoleAction extends ActionSupport implements ModelDriven<Role> {
	
	RoleService rs;
	Role role = new Role();
	Map<String,Object> request;
	
	public RoleAction(){
		request = (Map<String,Object>)ActionContext.getContext().get("request");
	}

	public String roleParamSet(){
		List<Role> list = rs.findRole("from Role");
		request.put("list", list);
		return "roleParamSet";
	}
	
	public String roleParamUpdate(){
		Role role1 = rs.getRole(Role.class,role.getRoleid() );
		role1.setInitialmoney(role.getInitialmoney());
		role1.setInitialp1(role.getInitialp1());
		role1.setInitialp2(role.getInitialp2());
		role1.setInitialp3(role.getInitialp3());
		role1.setBigStorage(role.getBigStorage());
		role1.setMiddleStorage(role.getMiddleStorage());
		role1.setSmallStorage(role.getSmallStorage());
		role1.setP1growline(role.getP1growline());
		role1.setP2growline(role.getP2growline());
		role1.setP3growline(role.getP3growline());
		role1.setInterestrate(role.getInterestrate());
		role1.setMaxloan(role.getMaxloan());
		
		rs.updateRole(role1);
		return SUCCESS;
	}

	public Role getModel() {
		return role;
	}

	public RoleService getRs() {
		return rs;
	}
    @Resource(name="roleService")
	public void setRs(RoleService rs) {
		this.rs = rs;
	}

}
