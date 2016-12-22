package com.scs.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

@Entity
public class Area implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer areaid;
	private String areaname;


	public Area() {
	}

	public Area(String areaname) {
		this.areaname = areaname;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "areaid", unique = true, nullable = false)
	public Integer getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	public String getAreaname() {
		return this.areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

}