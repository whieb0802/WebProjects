package com.scs.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currentime implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer currentime;

	public Currentime() {
	}

	public Currentime(Integer currentime) {
		this.currentime = currentime;
	}

	@Id
	@Column(name = "currentime", unique = true, nullable = false)
	public Integer getCurrentime() {
		return this.currentime;
	}

	public void setCurrentime(Integer currentime) {
		this.currentime = currentime;
	}


}