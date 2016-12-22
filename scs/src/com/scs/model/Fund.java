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
public class Fund implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer fundid;
	private Currentime currentime;
	private User user;
	private Integer currentmoney;
	private Integer totaloan;
	private Integer currentloan;
	private Float interest;
	private Integer remaintime;


	public Fund() {
	}

	public Fund(Currentime currentime, User user, Integer currentmoney,
			Integer totaloan, Integer currentloan, Float interest,
			Integer remaintime) {
		this.currentime = currentime;
		this.user = user;
		this.currentmoney = currentmoney;
		this.totaloan = totaloan;
		this.currentloan = currentloan;
		this.interest = interest;
		this.remaintime = remaintime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "fundid", unique = true, nullable = false)
	public Integer getFundid() {
		return this.fundid;
	}

	public void setFundid(Integer fundid) {
		this.fundid = fundid;
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

	@Column(name = "currentmoney", nullable = false)
	public Integer getCurrentmoney() {
		return this.currentmoney;
	}

	public void setCurrentmoney(Integer currentmoney) {
		this.currentmoney = currentmoney;
	}

	@Column(name = "totaloan", nullable = false)
	public Integer getTotaloan() {
		return this.totaloan;
	}

	public void setTotaloan(Integer totaloan) {
		this.totaloan = totaloan;
	}

	@Column(name = "currentloan", nullable = false)
	public Integer getCurrentloan() {
		return this.currentloan;
	}

	public void setCurrentloan(Integer currentloan) {
		this.currentloan = currentloan;
	}

	@Column(name = "interest", nullable = false, precision = 12, scale = 0)
	public Float getInterest() {
		return this.interest;
	}

	public void setInterest(Float interest) {
		this.interest = interest;
	}

	@Column(name = "remaintime", nullable = false)
	public Integer getRemaintime() {
		return this.remaintime;
	}

	public void setRemaintime(Integer remaintime) {
		this.remaintime = remaintime;
	}

}