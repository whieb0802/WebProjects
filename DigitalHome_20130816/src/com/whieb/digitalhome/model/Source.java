package com.whieb.digitalhome.model;

import java.util.Date;

public class Source {
	private long id;
	private String TVid;// 电视机ID
	private String name;// 视频名称
	private Date s_time;// 播放开始时间
	private Date e_time;// 播放结束时间

	public Source() {
		super();
	}

	public Source(String tVid, String name, Date s_time, Date e_time) {
		super();
		TVid = tVid;
		this.name = name;
		this.s_time = s_time;
		this.e_time = e_time;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTVid() {
		return TVid;
	}

	public void setTVid(String tVid) {
		TVid = tVid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getS_time() {
		return s_time;
	}

	public void setS_time(Date s_time) {
		this.s_time = s_time;
	}

	public Date getE_time() {
		return e_time;
	}

	public void setE_time(Date e_time) {
		this.e_time = e_time;
	}

}
