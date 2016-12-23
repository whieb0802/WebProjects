package com.whieb.digitalhome.model;

import java.util.Date;

/*
 * @author  yujifang
 */

public class Trade {
	private long id;
	private long userId;
	private long itemId;
	private Date date;
	private double totalPrice;

	public Trade() {
	}

	public Trade(long userId, long itemId, Date date, double totalPrice) {
		super();
		this.userId = userId;
		this.itemId = itemId;
		this.date = date;
		this.totalPrice = totalPrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
