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
public class Growline implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Fields

	private Integer growlineid;
	private Currentime currentime;
	private User user;
	private Integer buyp1growline;
	private Integer buyp2growline;
	private Integer buyp3growline;
	private Integer rentp1growline;
	private Integer rentp2growline;
	private Integer rentp3growline;
	private Integer islarged;

	public Growline() {
	}

	public Growline(Currentime currentime, User user, Integer buyp1growline,
			Integer buyp2growline, Integer buyp3growline,
			Integer rentp1growline, Integer rentp2growline,
			Integer rentp3growline) {
		this.currentime = currentime;
		this.user = user;
		this.buyp1growline = buyp1growline;
		this.buyp2growline = buyp2growline;
		this.buyp3growline = buyp3growline;
		this.rentp1growline = rentp1growline;
		this.rentp2growline = rentp2growline;
		this.rentp3growline = rentp3growline;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "growlineid", unique = true, nullable = false)
	public Integer getGrowlineid() {
		return this.growlineid;
	}

	public void setGrowlineid(Integer growlineid) {
		this.growlineid = growlineid;
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

	@Column(name = "buyp1growline", nullable = false)
	public Integer getBuyp1growline() {
		return this.buyp1growline;
	}

	public void setBuyp1growline(Integer buyp1growline) {
		this.buyp1growline = buyp1growline;
	}

	@Column(name = "buyp2growline", nullable = false)
	public Integer getBuyp2growline() {
		return this.buyp2growline;
	}

	public void setBuyp2growline(Integer buyp2growline) {
		this.buyp2growline = buyp2growline;
	}

	@Column(name = "buyp3growline", nullable = false)
	public Integer getBuyp3growline() {
		return this.buyp3growline;
	}

	public void setBuyp3growline(Integer buyp3growline) {
		this.buyp3growline = buyp3growline;
	}

	@Column(name = "rentp1growline", nullable = false)
	public Integer getRentp1growline() {
		return this.rentp1growline;
	}

	public void setRentp1growline(Integer rentp1growline) {
		this.rentp1growline = rentp1growline;
	}

	@Column(name = "rentp2growline", nullable = false)
	public Integer getRentp2growline() {
		return this.rentp2growline;
	}

	public void setRentp2growline(Integer rentp2growline) {
		this.rentp2growline = rentp2growline;
	}

	@Column(name = "rentp3growline", nullable = false)
	public Integer getRentp3growline() {
		return this.rentp3growline;
	}

	public void setRentp3growline(Integer rentp3growline) {
		this.rentp3growline = rentp3growline;
	}

	@Column(name = "islarged", nullable = false)
	public Integer getIslarged() {
		return islarged;
	}

	public void setIslarged(Integer islarged) {
		this.islarged = islarged;
	}

}