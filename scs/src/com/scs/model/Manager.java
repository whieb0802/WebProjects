package com.scs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manager {
	
	private String manager;
	private String password;
	
	@Id
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
