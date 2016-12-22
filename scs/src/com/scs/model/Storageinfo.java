package com.scs.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Storageinfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Role role;
	private Integer storageid;
	private String storagename;
	private Integer p1count;
	private Integer p2count;
	private Integer p3count;
	private Integer rentprice;
	private Integer buyprice;

	public Storageinfo() {
	}

	public Storageinfo(Integer id, Role role, Integer storageid,
			String storagename, Integer p1count, Integer p2count,
			Integer p3count, Integer rentprice, Integer buyprice) {
		this.id = id;
		this.role = role;
		this.storageid = storageid;
		this.storagename = storagename;
		this.p1count = p1count;
		this.p2count = p2count;
		this.p3count = p3count;
		this.rentprice = rentprice;
		this.buyprice = buyprice;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleid", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "storageid", nullable = false)
	public Integer getStorageid() {
		return this.storageid;
	}

	public void setStorageid(Integer storageid) {
		this.storageid = storageid;
	}

	@Column(name = "storagename", nullable = false, length = 20)
	public String getStoragename() {
		return this.storagename;
	}

	public void setStoragename(String storagename) {
		this.storagename = storagename;
	}

	@Column(name = "p1count", nullable = false)
	public Integer getP1count() {
		return this.p1count;
	}

	public void setP1count(Integer p1count) {
		this.p1count = p1count;
	}

	@Column(name = "p2count", nullable = false)
	public Integer getP2count() {
		return this.p2count;
	}

	public void setP2count(Integer p2count) {
		this.p2count = p2count;
	}

	@Column(name = "p3count", nullable = false)
	public Integer getP3count() {
		return this.p3count;
	}

	public void setP3count(Integer p3count) {
		this.p3count = p3count;
	}

	@Column(name = "rentprice", nullable = false)
	public Integer getRentprice() {
		return this.rentprice;
	}

	public void setRentprice(Integer rentprice) {
		this.rentprice = rentprice;
	}

	@Column(name = "buyprice", nullable = false)
	public Integer getBuyprice() {
		return this.buyprice;
	}

	public void setBuyprice(Integer buyprice) {
		this.buyprice = buyprice;
	}

}