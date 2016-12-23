package com.whieb.digitalhome.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.whieb.digitalhome.service.ItemService;
import com.whieb.digitalhome.service.ParameterService;
import com.whieb.digitalhome.service.UserService;
import com.whieb.digitalhome.util.Configuration;
import com.whieb.digitalhome.util.UtilDao;

/**
 * 基本Action对象，其它Action的父类
 * @author Li Yongqiang
 */
public class BaseAction extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware {
	private static final long serialVersionUID = 1L;
	/**
	 * Map类型的request
	 */
	protected Map<String, Object> request;
	/**
	 * Map类型的session
	 */
	protected Map<String, Object> session;
	/**
	 * Map类型的application
	 */
	protected Map<String, Object> application;

	/**
	 * 注入service
	 */
	@Resource
	protected UserService userService;
	@Resource
	protected ItemService itemService;
	@Resource(name = "configuration")
	protected Configuration config;
	@Resource
	protected ParameterService parameterService;
	@Resource
	protected UtilDao utilDao;

	@Override
	public void setRequest(Map<String, Object> request) {
		// 获取Map类型的request赋值
		this.request = request;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		// 获取Map类型的application赋值
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// 获取Map类型的session赋值
		this.session = session;
	}

}
