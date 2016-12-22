package com.scs.action;

import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scs.dto.UserRegisterInfo;
import com.scs.model.Currentime;
import com.scs.model.Message;
import com.scs.model.User;
import com.scs.service.CurrentimeService;
import com.scs.service.UserService;

public class RegisterAction extends ActionSupport implements ModelDriven<UserRegisterInfo>{
	
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	private CurrentimeService currentimeService;
	private UserRegisterInfo info = new UserRegisterInfo();
	
	@Override
	public String execute() throws Exception {
		
		List<Currentime> list = currentimeService.findCurrentime("from Currentime");
		if(list.size()>0){
			ActionContext.getContext().put("message", Message.msg41);
			return "register";
		}
		
		List<User> list1 = userService.findUser("from User u where u.username = ?", info.getUsername());
		if (list1.size() != 0){
			ActionContext.getContext().put("message", Message.msg40);
			return "fail";
		}
		else {
			User user = new User();
			user.setUsername(info.getUsername());
			user.setPassword(info.getPassword());
			user.setRealname(info.getRealname());
			userService.saveUser(user);
			ActionContext.getContext().put("message", Message.msg42);
			return "register";
		}
		
	}
	
	
	public UserRegisterInfo getModel() {
		return info;
	}
	
	public CurrentimeService getCurrentimeService() {
		return currentimeService;
	}
	@Resource
	public void setCurrentimeService(CurrentimeService currentimeService) {
		this.currentimeService = currentimeService;
	}

	public UserRegisterInfo getInfo() {
		return info;
	}
	public void setInfo(UserRegisterInfo info) {
		this.info = info;
	}
	public UserService getUserService() {
		return userService;
	}
	
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
