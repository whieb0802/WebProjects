package com.scs.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Inventory implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer inventoryid;
	private Currentime currentime;
	private User user;
	private Integer currentp1;
	private Integer currentp2;
	private Integer currentp3;
	private Integer p1in;
	private Integer p2in;
	private Integer p3in;
	private Integer p1out;
	private Integer p2out;
	private Integer p3out;
	private Integer p1totalin;
	private Integer p2totalin;
	private Integer p3totalin;
	private Integer p1totalout;
	private Integer p2totalout;
	private Integer p3totalout;

	public Inventory() {
	}

	/** full constructor */
	public Inventory(Currentime currentime, User user, Integer currentp1,
			Integer currentp2, Integer currentp3, Integer p1in, Integer p2in,
			Integer p3in, Integer p1out, Integer p2out, Integer p3out,
			Integer p1totalin, Integer p2totalin, Integer p3totalin,
			Integer p1totalout, Integer p2totalout, Integer p3totalout) {
		this.currentime = currentime;
		this.user = user;
		this.currentp1 = currentp1;
		this.currentp2 = currentp2;
		this.currentp3 = currentp3;
		this.p1in = p1in;
		this.p2in = p2in;
		this.p3in = p3in;
		this.p1out = p1out;
		this.p2out = p2out;
		this.p3out = p3out;
		this.p1totalin = p1totalin;
		this.p2totalin = p2totalin;
		this.p3totalin = p3totalin;
		this.p1totalout = p1totalout;
		this.p2totalout = p2totalout;
		this.p3totalout = p3totalout;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "inventoryid", unique = true, nullable = false)
	public Integer getInventoryid() {
		return this.inventoryid;
	}

	public void setInventoryid(Integer inventoryid) {
		this.inventoryid = inventoryid;
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

	@Column(name = "currentp1", nullable = false)
	public Integer getCurrentp1() {
		return this.currentp1;
	}

	public void setCurrentp1(Integer currentp1) {
		this.currentp1 = currentp1;
	}

	@Column(name = "currentp2", nullable = false)
	public Integer getCurrentp2() {
		return this.currentp2;
	}

	public void setCurrentp2(Integer currentp2) {
		this.currentp2 = currentp2;
	}

	@Column(name = "currentp3", nullable = false)
	public Integer getCurrentp3() {
		return this.currentp3;
	}

	public void setCurrentp3(Integer currentp3) {
		this.currentp3 = currentp3;
	}

	@Column(name = "p1in", nullable = false)
	public Integer getP1in() {
		return this.p1in;
	}

	public void setP1in(Integer p1in) {
		this.p1in = p1in;
	}

	@Column(name = "p2in", nullable = false)
	public Integer getP2in() {
		return this.p2in;
	}

	public void setP2in(Integer p2in) {
		this.p2in = p2in;
	}

	@Column(name = "p3in", nullable = false)
	public Integer getP3in() {
		return this.p3in;
	}

	public void setP3in(Integer p3in) {
		this.p3in = p3in;
	}

	@Column(name = "p1out", nullable = false)
	public Integer getP1out() {
		return this.p1out;
	}

	public void setP1out(Integer p1out) {
		this.p1out = p1out;
	}

	@Column(name = "p2out", nullable = false)
	public Integer getP2out() {
		return this.p2out;
	}

	public void setP2out(Integer p2out) {
		this.p2out = p2out;
	}

	@Column(name = "p3out", nullable = false)
	public Integer getP3out() {
		return this.p3out;
	}

	public void setP3out(Integer p3out) {
		this.p3out = p3out;
	}

	@Column(name = "p1totalin", nullable = false)
	public Integer getP1totalin() {
		return this.p1totalin;
	}

	public void setP1totalin(Integer p1totalin) {
		this.p1totalin = p1totalin;
	}

	@Column(name = "p2totalin", nullable = false)
	public Integer getP2totalin() {
		return this.p2totalin;
	}

	public void setP2totalin(Integer p2totalin) {
		this.p2totalin = p2totalin;
	}

	@Column(name = "p3totalin", nullable = false)
	public Integer getP3totalin() {
		return this.p3totalin;
	}

	public void setP3totalin(Integer p3totalin) {
		this.p3totalin = p3totalin;
	}

	@Column(name = "p1totalout", nullable = false)
	public Integer getP1totalout() {
		return this.p1totalout;
	}

	public void setP1totalout(Integer p1totalout) {
		this.p1totalout = p1totalout;
	}

	@Column(name = "p2totalout", nullable = false)
	public Integer getP2totalout() {
		return this.p2totalout;
	}

	public void setP2totalout(Integer p2totalout) {
		this.p2totalout = p2totalout;
	}

	@Column(name = "p3totalout", nullable = false)
	public Integer getP3totalout() {
		return this.p3totalout;
	}

	public void setP3totalout(Integer p3totalout) {
		this.p3totalout = p3totalout;
	}

}