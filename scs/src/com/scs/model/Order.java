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
 * Order entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_order")
public class Order implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer orderid;
	private Currentime currentime;
	private Integer ofrom;
	private Integer oto;
	private Integer p1price;
	private Integer p2price;
	private Integer p3price;
	private Integer countp1;
	private Integer countp2;
	private Integer countp3;
	private Integer iscomplete;

	public Order() {
	}

	/** full constructor */
	public Order(Currentime currentime, Integer ofrom, Integer oto,
			Integer p1price, Integer p2price, Integer p3price, Integer countp1,
			Integer countp2, Integer countp3) {
		this.currentime = currentime;
		this.ofrom = ofrom;
		this.oto = oto;
		this.p1price = p1price;
		this.p2price = p2price;
		this.p3price = p3price;
		this.countp1 = countp1;
		this.countp2 = countp2;
		this.countp3 = countp3;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "orderid", unique = true, nullable = false)
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "currentime", nullable = false)
	public Currentime getCurrentime() {
		return this.currentime;
	}

	public void setCurrentime(Currentime currentime) {
		this.currentime = currentime;
	}

	@Column(name = "ofrom", nullable = false)
	public Integer getOfrom() {
		return this.ofrom;
	}

	public void setOfrom(Integer ofrom) {
		this.ofrom = ofrom;
	}

	@Column(name = "oto", nullable = false)
	public Integer getOto() {
		return this.oto;
	}

	public void setOto(Integer oto) {
		this.oto = oto;
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

	@Column(name = "iscomplete", nullable = false)
	public Integer getIscomplete() {
		return iscomplete;
	}

	public void setIscomplete(Integer iscomplete) {
		this.iscomplete = iscomplete;
	}

}