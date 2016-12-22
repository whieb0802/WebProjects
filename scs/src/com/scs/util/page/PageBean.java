package com.scs.util.page;

public class PageBean { 
	
	private int page;

	public int getPage() {
		return page<1?1:page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
    
  
}
