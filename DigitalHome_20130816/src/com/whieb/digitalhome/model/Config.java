package com.whieb.digitalhome.model;

/**
 * @author Vicky 2012-9-1 替代Parameter
 */
public class Config {
	private int id;
	private String name;// 参数名
	private String value;// 参数值
	private int type;// 参数类型:0-无/1-枚举型/2-文本型/3-特定格式-字符串空格划分型/4-数值型
	private String description;// 参数描述

	public Config() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
