package com.scs.model;
// default package

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Consume implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer consumeid;
	private Currentime currentime;
	private User user;
	private Integer p1demand;
	private Integer p2demand;
	private Integer p3demand;

	public Consume() {
	}

	public Consume( Currentime currentime, User user,Integer p1demand, Integer p2demand, Integer p3demand) {
		
		this.currentime = currentime;
		this.user = user;
		this.p1demand = p1demand;
		this.p2demand = p2demand;
		this.p3demand = p3demand;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "consumeid", unique = true, nullable = false)
	public Integer getConsumeid() {
		return this.consumeid;
	}

	public void setConsumeid(Integer consumeid) {
		this.consumeid = consumeid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "currentime", nullable = false)
	public Currentime getCurrentime() {
		return this.currentime;
	}

	public void setCurrentime(Currentime currentime) {
		this.currentime = currentime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "p1demand", nullable = false)
	public Integer getP1demand() {
		return this.p1demand;
	}

	public void setP1demand(Integer p1demand) {
		this.p1demand = p1demand;
	}

	@Column(name = "p2demand", nullable = false)
	public Integer getP2demand() {
		return this.p2demand;
	}

	public void setP2demand(Integer p2demand) {
		this.p2demand = p2demand;
	}

	@Column(name = "p3demand", nullable = false)
	public Integer getP3demand() {
		return this.p3demand;
	}

	public void setP3demand(Integer p3demand) {
		this.p3demand = p3demand;
	}

}