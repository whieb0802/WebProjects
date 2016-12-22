package com.scs.util.page;

import java.util.List;

public class PageView<T> {

	/** 分页数据 **/
	private List<T> records;
	/** 页码开始索引和结束索引 **/
	private PageIndex pageIndex;
	/** 总页数 **/
	private long totalPage = 1;
	/** 每页显示记录数 **/
	private int maxResult = 15;
	/** 当前页 **/
	private int currentPage = 1;
	/** 总记录数 **/
	private long totalRecord;
	/** 页码数量 **/
	private int pageCode = 5;

	
	public PageView(int maxResult, int currentPage) {
		this.maxResult = maxResult;
		this.currentPage = currentPage;
	}
	/** 要获取记录的开始索引 **/
	public int getFirstResult() {
		return (this.currentPage - 1) * this.maxResult;
	}

	public int getPageCode() {
		return pageCode;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	// 构造器,每页显示多少条记录，当前页
	public void setResultType(ResultType<T> rt) {
		setTotalRecord(rt.getTotalRecord());
		setRecords(rt.getResultList());
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
		setTotalPage(this.totalRecord % this.maxResult == 0 ? this.totalRecord
				/ this.maxResult : this.totalRecord / this.maxResult + 1);
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public PageIndex getPageIndex() {
		return pageIndex;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
		this.pageIndex = PageIndex.getPageIndex(pageCode, currentPage,
				totalPage);
	}

	public int getMaxResult() {
		return maxResult;
	}

	public int getCurrentPage() {
			return currentPage;
	}
}
