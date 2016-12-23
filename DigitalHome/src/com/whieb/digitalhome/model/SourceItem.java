package com.whieb.digitalhome.model;

public class SourceItem {
	private long id;
	private String name;    //节目名称
	private String cpname;	//电视台名称
	private int playtimes;	//播放次数
	private int num;		//户数
	private float avetimes;		//平均播放次数
	private int fee;		//计费金额
	
	
	public SourceItem() {
		super();
	}


	public SourceItem(String name, int playtimes, float avetimes) {
		super();
		this.name = name;
		this.playtimes = playtimes;
		this.avetimes = avetimes;
	}


	public SourceItem(long id, String name, String cpname, int playtimes,
			int num, float avetimes, int fee) {
		super();
		this.id = id;
		this.name = name;
		this.cpname = cpname;
		this.playtimes = playtimes;
		this.num = num;
		this.avetimes = avetimes;
		this.fee = fee;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCpname() {
		return cpname;
	}


	public void setCpname(String cpname) {
		this.cpname = cpname;
	}


	public int getPlaytimes() {
		return playtimes;
	}


	public void setPlaytimes(int playtimes) {
		this.playtimes = playtimes;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public float getAvetimes() {
		return avetimes;
	}


	public void setAvetimes(float avetimes) {
		this.avetimes = avetimes;
	}


	public int getFee() {
		return fee;
	}


	public void setFee(int fee) {
		this.fee = fee;
	}
	
	
	
	
}
