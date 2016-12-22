package com.scs.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Growlineinfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Fields

	private Integer growlineid;
	private String growlinename;
	private Integer capacity;
	private Integer buyprice;
	private Integer rentprice;
	private Integer depretation;
	private Integer largerprice;
	private Integer largeredcapacity;

	public Growlineinfo() {
	}

	/** full constructor */
	public Growlineinfo(Integer growlineid, String growlinename,
			Integer capacity, Integer buyprice, Integer rentprice,
			Integer depretation, Integer largerprice, Integer largeredcapacity) {
		this.growlineid = growlineid;
		this.growlinename = growlinename;
		this.capacity = capacity;
		this.buyprice = buyprice;
		this.rentprice = rentprice;
		this.depretation = depretation;
		this.largerprice = largerprice;
		this.largeredcapacity = largeredcapacity;
	}

	@Id
	@Column(name = "growlineid", unique = true, nullable = false)
	public Integer getGrowlineid() {
		return this.growlineid;
	}

	public void setGrowlineid(Integer growlineid) {
		this.growlineid = growlineid;
	}

	@Column(name = "growlinename", nullable = false, length = 20)
	public String getGrowlinename() {
		return this.growlinename;
	}

	public void setGrowlinename(String growlinename) {
		this.growlinename = growlinename;
	}

	@Column(name = "capacity", nullable = false)
	public Integer getCapacity() {
		return this.capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Column(name = "buyprice", nullable = false)
	public Integer getBuyprice() {
		return this.buyprice;
	}

	public void setBuyprice(Integer buyprice) {
		this.buyprice = buyprice;
	}

	@Column(name = "rentprice", nullable = false)
	public Integer getRentprice() {
		return this.rentprice;
	}

	public void setRentprice(Integer rentprice) {
		this.rentprice = rentprice;
	}

	@Column(name = "depretation", nullable = false)
	public Integer getDepretation() {
		return this.depretation;
	}

	public void setDepretation(Integer depretation) {
		this.depretation = depretation;
	}

	@Column(name = "largerprice", nullable = false)
	public Integer getLargerprice() {
		return this.largerprice;
	}

	public void setLargerprice(Integer largerprice) {
		this.largerprice = largerprice;
	}

	@Column(name = "largeredcapacity", nullable = false)
	public Integer getLargeredcapacity() {
		return this.largeredcapacity;
	}

	public void setLargeredcapacity(Integer largeredcapacity) {
		this.largeredcapacity = largeredcapacity;
	}

}