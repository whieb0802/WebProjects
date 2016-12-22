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
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private Role role;
	private Integer productid;
	private String pname;
	private Integer inprice;
	private Integer outprice;
	private Integer icost;
	private Integer advance;

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(Role role, Integer productid, String pname, Integer icost,
			Integer advance) {
		this.role = role;
		this.productid = productid;
		this.pname = pname;
		this.icost = icost;
		this.advance = advance;
	}

	/** full constructor */
	public Product(Role role, Integer productid, String pname, Integer inprice,
			Integer outprice, Integer icost, Integer advance) {
		this.role = role;
		this.productid = productid;
		this.pname = pname;
		this.inprice = inprice;
		this.outprice = outprice;
		this.icost = icost;
		this.advance = advance;
	}

	// Property accessors
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
	@JoinColumn(name = "roleid", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "productid", nullable = false)
	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	@Column(name = "pname", nullable = false, length = 10)
	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Column(name = "inprice")
	public Integer getInprice() {
		return this.inprice;
	}

	public void setInprice(Integer inprice) {
		this.inprice = inprice;
	}

	@Column(name = "outprice")
	public Integer getOutprice() {
		return this.outprice;
	}

	public void setOutprice(Integer outprice) {
		this.outprice = outprice;
	}

	@Column(name = "icost", nullable = false)
	public Integer getIcost() {
		return this.icost;
	}

	public void setIcost(Integer icost) {
		this.icost = icost;
	}

	@Column(name = "advance", nullable = false)
	public Integer getAdvance() {
		return this.advance;
	}

	public void setAdvance(Integer advance) {
		this.advance = advance;
	}

}