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
import javax.persistence.Table;

/**
 * Bill entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_bill")
public class Bill implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer billid;
	private Currentime currentime;
	private Integer bfrom;
	private Integer bto;
	private Integer countp1;
	private Integer countp2;
	private Integer countp3;
	private Integer p1price;
	private Integer p2price;
	private Integer p3price;
	private Integer p1lack;
	private Integer p2lack;
	private Integer p3lack;
	private Integer receivetime;
	private Integer iscomplete;

	public Bill() {
	}

	public Bill(Currentime currentime, Integer bfrom, Integer countp1,
			Integer countp2, Integer countp3, Integer p1price, Integer p2price,
			Integer p3price, Integer p1lack, Integer p2lack, Integer p3lack,
			Integer receivetime) {
		this.currentime = currentime;
		this.bfrom = bfrom;
		this.countp1 = countp1;
		this.countp2 = countp2;
		this.countp3 = countp3;
		this.p1price = p1price;
		this.p2price = p2price;
		this.p3price = p3price;
		this.p1lack = p1lack;
		this.p2lack = p2lack;
		this.p3lack = p3lack;
		this.receivetime = receivetime;
	}

	public Bill(Currentime currentime, Integer bfrom, Integer bto,
			Integer countp1, Integer countp2, Integer countp3, Integer p1price,
			Integer p2price, Integer p3price, Integer p1lack, Integer p2lack,
			Integer p3lack, Integer receivetime) {
		this.currentime = currentime;
		this.bfrom = bfrom;
		this.bto = bto;
		this.countp1 = countp1;
		this.countp2 = countp2;
		this.countp3 = countp3;
		this.p1price = p1price;
		this.p2price = p2price;
		this.p3price = p3price;
		this.p1lack = p1lack;
		this.p2lack = p2lack;
		this.p3lack = p3lack;
		this.receivetime = receivetime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	public Integer getBillid() {
		return this.billid;
	}

	public void setBillid(Integer billid) {
		this.billid = billid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "currentime", nullable = false)
	public Currentime getCurrentime() {
		return this.currentime;
	}

	public void setCurrentime(Currentime currentime) {
		this.currentime = currentime;
	}

	@Column(name = "bfrom", nullable = false)
	public Integer getBfrom() {
		return this.bfrom;
	}

	public void setBfrom(Integer bfrom) {
		this.bfrom = bfrom;
	}

	@Column(name = "bto")
	public Integer getBto() {
		return this.bto;
	}

	public void setBto(Integer bto) {
		this.bto = bto;
	}

	@Column(name = "countp1", nullable = false)
	public Integer getCountp1() {
		return this.countp1;
	}

	public void setCountp1(Integer countp1) {
		this.countp1 = countp1;
	}

	@Column(name = "countp2", nullable = false)
	public Integer getCountp2() {
		return this.countp2;
	}

	public void setCountp2(Integer countp2) {
		this.countp2 = countp2;
	}

	@Column(name = "countp3", nullable = false)
	public Integer getCountp3() {
		return this.countp3;
	}

	public void setCountp3(Integer countp3) {
		this.countp3 = countp3;
	}

	@Column(name = "p1price", nullable = false)
	public Integer getP1price() {
		return this.p1price;
	}

	public void setP1price(Integer p1price) {
		this.p1price = p1price;
	}

	@Column(name = "p2price", nullable = false)
	public Integer getP2price() {
		return this.p2price;
	}

	public void setP2price(Integer p2price) {
		this.p2price = p2price;
	}

	@Column(name = "p3price", nullable = false)
	public Integer getP3price() {
		return this.p3price;
	}

	public void setP3price(Integer p3price) {
		this.p3price = p3price;
	}

	@Column(name = "p1lack", nullable = false)
	public Integer getP1lack() {
		return this.p1lack;
	}

	public void setP1lack(Integer p1lack) {
		this.p1lack = p1lack;
	}

	@Column(name = "p2lack", nullable = false)
	public Integer getP2lack() {
		return this.p2lack;
	}

	public void setP2lack(Integer p2lack) {
		this.p2lack = p2lack;
	}

	@Column(name = "p3lack", nullable = false)
	public Integer getP3lack() {
		return this.p3lack;
	}

	public void setP3lack(Integer p3lack) {
		this.p3lack = p3lack;
	}

	@Column(name = "receivetime", nullable = false)
	public Integer getReceivetime() {
		return this.receivetime;
	}

	public void setReceivetime(Integer receivetime) {
		this.receivetime = receivetime;
	}
	
	@Column(name = "iscomplete", nullable = false)
	public Integer getIscomplete() {
		return iscomplete;
	}

	public void setIscomplete(Integer iscomplete) {
		this.iscomplete = iscomplete;
	}

}