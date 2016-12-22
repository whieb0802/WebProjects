package com.scs.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Relation implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer userid;
	private Area area;
	private User user;
	private Role role;
	private Integer upstream;

	// Constructors

	/** default constructor */
	public Relation() {
	}

	/** full constructor */
	public Relation(Integer userid, Area area, User user, Role role,
			Integer upstream) {
		this.userid = userid;
		this.area = area;
		this.user = user;
		this.role = role;
		this.upstream = upstream;
	}

	// Property accessors
	@Id
	@Column(name = "userid", unique = true, nullable = false)
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "areaid", nullable = false)
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", unique = true, nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "roleid", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "upstream", nullable = false)
	public Integer getUpstream() {
		return this.upstream;
	}

	public void setUpstream(Integer upstream) {
		this.upstream = upstream;
	}

}