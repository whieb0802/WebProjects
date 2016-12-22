package com.scs.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

@Entity
public class Role implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer roleid;
	private String rolename;
	private Integer initialp1;
	private Integer initialp2;
	private Integer initialp3;
	private Integer smallStorage;
	private Integer middleStorage;
	private Integer bigStorage;
	private Integer p1growline;
	private Integer p2growline;
	private Integer p3growline;
	private Integer initialmoney;
	private Integer maxloan;
	private Float interestrate;

	public Role() {
	}

	/** minimal constructor */
	public Role(String rolename, Integer initialp1, Integer initialp2,
			Integer initialp3, Integer initialmoney, Integer maxloan,
			Float interestrate) {
		this.rolename = rolename;
		this.initialp1 = initialp1;
		this.initialp2 = initialp2;
		this.initialp3 = initialp3;
		this.initialmoney = initialmoney;
		this.maxloan = maxloan;
		this.interestrate = interestrate;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "roleid", unique = true, nullable = false)
	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	@Column(name = "rolename", nullable = false, length = 20)
	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Column(name = "initialp1", nullable = false)
	public Integer getInitialp1() {
		return this.initialp1;
	}

	public void setInitialp1(Integer initialp1) {
		this.initialp1 = initialp1;
	}

	@Column(name = "initialp2", nullable = false)
	public Integer getInitialp2() {
		return this.initialp2;
	}

	public void setInitialp2(Integer initialp2) {
		this.initialp2 = initialp2;
	}

	@Column(name = "initialp3", nullable = false)
	public Integer getInitialp3() {
		return this.initialp3;
	}

	public void setInitialp3(Integer initialp3) {
		this.initialp3 = initialp3;
	}

	@Column(name = "initialmoney", nullable = false)
	public Integer getInitialmoney() {
		return this.initialmoney;
	}

	public void setInitialmoney(Integer initialmoney) {
		this.initialmoney = initialmoney;
	}

	@Column(name = "maxloan", nullable = false)
	public Integer getMaxloan() {
		return this.maxloan;
	}

	public void setMaxloan(Integer maxloan) {
		this.maxloan = maxloan;
	}

	@Column(name = "interestrate", nullable = false, precision = 12, scale = 0)
	public Float getInterestrate() {
		return this.interestrate;
	}

	public void setInterestrate(Float interestrate) {
		this.interestrate = interestrate;
	}
	
	public Integer getSmallStorage() {
		return smallStorage;
	}

	public void setSmallStorage(Integer smallStorage) {
		this.smallStorage = smallStorage;
	}

	public Integer getMiddleStorage() {
		return middleStorage;
	}

	public void setMiddleStorage(Integer middleStorage) {
		this.middleStorage = middleStorage;
	}

	public Integer getBigStorage() {
		return bigStorage;
	}

	public void setBigStorage(Integer bigStorage) {
		this.bigStorage = bigStorage;
	}

	public Integer getP1growline() {
		return p1growline;
	}

	public void setP1growline(Integer p1growline) {
		this.p1growline = p1growline;
	}

	public Integer getP2growline() {
		return p2growline;
	}

	public void setP2growline(Integer p2growline) {
		this.p2growline = p2growline;
	}

	public Integer getP3growline() {
		return p3growline;
	}

	public void setP3growline(Integer p3growline) {
		this.p3growline = p3growline;
	}

}