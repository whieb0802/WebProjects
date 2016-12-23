package com.whieb.digitalhome.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.whieb.digitalhome.model.User;
import com.whieb.digitalhome.util.page.PageView;


@Component("userAction")
@Scope("prototype")
public class UserAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private String  name;
	private String  password;
	
	private Integer page;
	private Integer order;
	
	
	/**
	 * 用户登录
	 */
	public String login(){
		int flag = userService.checkLogin(name, password);
		if (flag == -1) {
			request.put("message", "用户名不存在");
			return "fail";
		}else if (flag == 0) {
			request.put("message", "密码不正确");
			return "fail";
		}else if (flag ==1) {
			User user = userService.findUser("from User u where u.name = ?", new Object[]{name}).get(0);
			session.put("user", user);
		}
		return "success";
	}
	
	/**
	 *  查找所有用户
	 */
	public String listAll(){
		if (page == null) {page = 1;}
		PageView<User> pageView = userService.listUser(page);
		request.put("pageView", pageView);
		return "list";
	}
	
	/**
	 * 退出登录，清除session
	 * @return
	 */
	public String logout(){
		session.clear();
		request.put("message", "注销登录");
		return "logout";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}


	
	
}
