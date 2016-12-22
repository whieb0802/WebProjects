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
public class Storage implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Currentime currentime;
	private User user;
	private Integer rent1count;
	private Integer rent2count;
	private Integer rent3count;
	private Integer buy1count;
	private Integer buy2count;
	private Integer buy3count;

	public Storage() {
	}

	public Storage(Currentime currentime, User user) {
		this.currentime = currentime;
		this.user = user;
	}

	public Storage(Currentime currentime, User user, Integer rent1count,
			Integer rent2count, Integer rent3count, Integer buy1count,
			Integer buy2count, Integer buy3count) {
		this.currentime = currentime;
		this.user = user;
		this.rent1count = rent1count;
		this.rent2count = rent2count;
		this.rent3count = rent3count;
		this.buy1count = buy1count;
		this.buy2count = buy2count;
		this.buy3count = buy3count;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Column(name = "rent1count")
	public Integer getRent1count() {
		return this.rent1count;
	}

	public void setRent1count(Integer rent1count) {
		this.rent1count = rent1count;
	}

	@Column(name = "rent2count")
	public Integer getRent2count() {
		return this.rent2count;
	}

	public void setRent2count(Integer rent2count) {
		this.rent2count = rent2count;
	}

	@Column(name = "rent3count")
	public Integer getRent3count() {
		return this.rent3count;
	}

	public void setRent3count(Integer rent3count) {
		this.rent3count = rent3count;
	}

	@Column(name = "buy1count")
	public Integer getBuy1count() {
		return this.buy1count;
	}

	public void setBuy1count(Integer buy1count) {
		this.buy1count = buy1count;
	}

	@Column(name = "buy2count")
	public Integer getBuy2count() {
		return this.buy2count;
	}

	public void setBuy2count(Integer buy2count) {
		this.buy2count = buy2count;
	}

	@Column(name = "buy3count")
	public Integer getBuy3count() {
		return this.buy3count;
	}

	public void setBuy3count(Integer buy3count) {
		this.buy3count = buy3count;
	}

}