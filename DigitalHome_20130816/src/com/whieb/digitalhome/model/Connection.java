package com.whieb.digitalhome.model;

/*
 * @author   yujifang
 */

public class Connection {
   private long id;
   private long resourceId;
   private long relativeId;
   private double supportLevel;
   private Double confidence;
   
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public Long getRelativeId() {
		return relativeId;
	}

	public void setRelativeId(Long relativeId) {
		this.relativeId = relativeId;
	}

	public double getSupportLevel() {
		return supportLevel;
	}

	public void setSupportLevel(double supportLevel) {
		this.supportLevel = supportLevel;
	}

	public Double getConfidence() {
		return confidence;
	}

	public void setConfidence(Double confidence) {
		this.confidence = confidence;
	}

}
