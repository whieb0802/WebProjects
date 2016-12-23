package com.whieb.digitalhome.model;

/*
 * @author   yujifang
 */
public class Template {
    private long id;
    private String type;
    
    protected Integer sequence;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
    
}
