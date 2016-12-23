package com.whieb.digitalhome.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.whieb.digitalhome.model.Config;

@Component("parameterAction")
@Scope("prototype")
public class ParameterAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private Config config;
		
	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}


	/**
	 *  查找Parameter
	 */
	public String execute(){
		List<Config> configs = parameterService.getConfigs();
		request.put("configs", configs);
		return SUCCESS;
	}
	/**
	 * 更新参数
	 * @return
	 */
	public String update(){
		System.out.println(config.getName());
		Config config2 = parameterService.findConfig(config.getName());
		config2.setValue(config.getValue());
		config2.setDescription(config.getDescription());
		parameterService.saveOrUpdate(config2);
		return "update";
	}
	

}
