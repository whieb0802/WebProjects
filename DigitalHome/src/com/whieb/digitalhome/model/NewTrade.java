package com.whieb.digitalhome.model;

import java.util.Date;

/**
 * @author Vicky 2012-11-8 统计后的交易记录表
 */
public class NewTrade {
	private long id;
	private long userId;
	private long itemId;
	private Date date;
	private int times;

	public NewTrade() {
		super();
	}

	public NewTrade(long userId, long itemId, int times) {
		super();
		this.userId = userId;
		this.itemId = itemId;
		this.times = times;
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

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

}
