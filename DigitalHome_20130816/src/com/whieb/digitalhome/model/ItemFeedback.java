package com.whieb.digitalhome.model;

import java.util.Date;

import org.duineframework.recommender.core.IFeedback;
import org.duineframework.recommender.core.IRatableItem;

public class ItemFeedback implements IFeedback{
	
	private IRatableItem item;
	private double value;
	private double certainty;
	private Date lastModification;
	
	public ItemFeedback() {
		super();
	}
	
	public ItemFeedback(IRatableItem item, double value) {
		super();
		this.item = item;
		this.value = value;
	}
		
	public ItemFeedback(IRatableItem item, double value, double certainty) {
		super();
		this.item = item;
		this.value = value;
		this.certainty = certainty;
	}

	public ItemFeedback(IRatableItem item, double value, double certainty,
			Date lastModification) {
		super();
		this.item = item;
		this.value = value;
		this.certainty = certainty;
		this.lastModification = lastModification;
	}


	public IRatableItem getItem() {
		return item;
	}
	public void setItem(IRatableItem item) {
		this.item = item;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getCertainty() {
		return certainty;
	}
	public void setCertainty(double certainty) {
		this.certainty = certainty;
	}
	public Date getLastModification() {
		return lastModification;
	}
	public void setLastModification(Date lastModification) {
		this.lastModification = lastModification;
	}

	
}
