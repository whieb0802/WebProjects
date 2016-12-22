package com.scs.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Groupinfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private Integer manCount;
	private Integer agentCount;
	private Integer retailerCount;
	private Integer groupCount;

	public Groupinfo() {
	}

	public Groupinfo(Integer id, Integer manCount, Integer agentCount,
			Integer retailerCount, Integer groupCount) {
		this.id = id;
		this.manCount = manCount;
		this.agentCount = agentCount;
		this.retailerCount = retailerCount;
		this.groupCount = groupCount;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "manCount", nullable = false)
	public Integer getManCount() {
		return this.manCount;
	}

	public void setManCount(Integer manCount) {
		this.manCount = manCount;
	}

	@Column(name = "agentCount", nullable = false)
	public Integer getAgentCount() {
		return this.agentCount;
	}

	public void setAgentCount(Integer agentCount) {
		this.agentCount = agentCount;
	}

	@Column(name = "retailerCount", nullable = false)
	public Integer getRetailerCount() {
		return this.retailerCount;
	}

	public void setRetailerCount(Integer retailerCount) {
		this.retailerCount = retailerCount;
	}

	@Column(name = "groupCount", nullable = false)
	public Integer getGroupCount() {
		return this.groupCount;
	}

	public void setGroupCount(Integer groupCount) {
		this.groupCount = groupCount;
	}

}