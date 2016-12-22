package com.whieb.digitalhome.model;


import java.io.Serializable;

import org.duineframework.recommender.core.UserId;

public class User implements Serializable {
	private static final long serialVersionUID = -6320531308066793646L;
	private Long key;
	private String password;
	private String name;
    
	private UserId id;

	public User() {
		super();
	}

	public User(Long key) {

		this.key = key;
	}

	public User(UserId id){
		this.id = id;
	}
	
	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
		this.id = new UserId(String.valueOf(key));
	}

	public Long getUserId() {
		return key;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserId getId() {
		return id;
	}

	public void setId(UserId id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [key=" + key + ", password=" + password + ", name=" + name
				+ ", id=" + id + "]";
	}

}
