package com.scs.util.page;

import java.util.List;

public class PageView<T> {

	/** ��ҳ���� **/
	private List<T> records;
	/** ҳ�뿪ʼ�����ͽ������� **/
	private PageIndex pageIndex;
	/** ��ҳ�� **/
	private long totalPage = 1;
	/** ÿҳ��ʾ��¼�� **/
	private int maxResult = 15;
	/** ��ǰҳ **/
	private int currentPage = 1;
	/** �ܼ�¼�� **/
	private long totalRecord;
	/** ҳ������ **/
	private int pageCode = 5;

	
	public PageView(int maxResult, int currentPage) {
		this.maxResult = maxResult;
		this.currentPage = currentPage;
	}
	/** Ҫ��ȡ��¼�Ŀ�ʼ���� **/
	public int getFirstResult() {
		return (this.currentPage - 1) * this.maxResult;
	}

	public int getPageCode() {
		return pageCode;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	// ������,ÿҳ��ʾ��������¼����ǰҳ
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
