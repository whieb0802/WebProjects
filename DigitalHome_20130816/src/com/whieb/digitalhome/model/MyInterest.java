package com.whieb.digitalhome.model;


import org.duineframework.recommender.core.UserId;

public class MyInterest{

	private Long id;	
	private UserId user;
	private int subjectType;
	private String subject;
	private double weight;
	private int counts;
	
	public MyInterest() {
		super();
	}
	
	public MyInterest(UserId user, int subjectType, String subject,double weight) {
		super();
		this.user = user;
		this.subjectType = subjectType;
		this.subject = subject;
		this.weight = weight;
	}
	
	
	
	public MyInterest(UserId user, int subjectType, String subject,double weight, int counts) {
		super();
		this.user = user;
		this.subjectType = subjectType;
		this.subject = subject;
		this.weight = weight;
		this.counts = counts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserId getUser() {
		return user;
	}
	public void setUser(UserId user) {
		this.user = user;
	}
	public int getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(int subjectType) {
		this.subjectType = subjectType;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}
	
	
	
}
