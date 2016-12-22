package com.scs.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

@Entity
public class Demand implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Fields

	private Integer demandid;
	private Integer currentime;
	private Integer p1mindemand;
	private Integer p2mindemand;
	private Integer p3mindemand;
	private Integer p1maxdemand;
	private Integer p2maxdemand;
	private Integer p3maxdemand;

	public Demand() {
	}

	public Demand(Integer currentime, Integer p1mindemand, Integer p2mindemand,
			Integer p3mindemand, Integer p1maxdemand, Integer p2maxdemand,
			Integer p3maxdemand) {
		this.currentime = currentime;
		this.p1mindemand = p1mindemand;
		this.p2mindemand = p2mindemand;
		this.p3mindemand = p3mindemand;
		this.p1maxdemand = p1maxdemand;
		this.p2maxdemand = p2maxdemand;
		this.p3maxdemand = p3maxdemand;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "demandid", unique = true, nullable = false)
	public Integer getDemandid() {
		return this.demandid;
	}

	public void setDemandid(Integer demandid) {
		this.demandid = demandid;
	}

	@Column(name = "currentime", nullable = false)
	public Integer getCurrentime() {
		return this.currentime;
	}

	public void setCurrentime(Integer currentime) {
		this.currentime = currentime;
	}

	@Column(name = "p1mindemand", nullable = false)
	public Integer getP1mindemand() {
		return this.p1mindemand;
	}

	public void setP1mindemand(Integer p1mindemand) {
		this.p1mindemand = p1mindemand;
	}

	@Column(name = "p2mindemand", nullable = false)
	public Integer getP2mindemand() {
		return this.p2mindemand;
	}

	public void setP2mindemand(Integer p2mindemand) {
		this.p2mindemand = p2mindemand;
	}

	@Column(name = "p3mindemand", nullable = false)
	public Integer getP3mindemand() {
		return this.p3mindemand;
	}

	public void setP3mindemand(Integer p3mindemand) {
		this.p3mindemand = p3mindemand;
	}

	@Column(name = "p1maxdemand", nullable = false)
	public Integer getP1maxdemand() {
		return this.p1maxdemand;
	}

	public void setP1maxdemand(Integer p1maxdemand) {
		this.p1maxdemand = p1maxdemand;
	}

	@Column(name = "p2maxdemand", nullable = false)
	public Integer getP2maxdemand() {
		return this.p2maxdemand;
	}

	public void setP2maxdemand(Integer p2maxdemand) {
		this.p2maxdemand = p2maxdemand;
	}

	@Column(name = "p3maxdemand", nullable = false)
	public Integer getP3maxdemand() {
		return this.p3maxdemand;
	}

	public void setP3maxdemand(Integer p3maxdemand) {
		this.p3maxdemand = p3maxdemand;
	}

}