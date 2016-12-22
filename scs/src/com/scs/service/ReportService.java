package com.scs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.scs.dao.ReportDao;
import com.scs.model.Report;

@Component("reportService")
public class ReportService{
	
	private ReportDao reportDao;
	
	@Resource
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}

	public ReportDao getReportDao() {
		return reportDao;
	}

	public void updateReport(Report report) {
		reportDao.updateReport(report);
	}

	public void deleteReport(Report report) {
		reportDao.deleteReport(report);
	}
	
	public void deleteAll(List<Report> report) {
		reportDao.deleteAll(report);
	}

	public void saveReport(Report report) {
		reportDao.saveReport(report);

	}
	public Report getReport(Class<Report> report,int id) {
		return (Report)reportDao.getReport(report,id);
	}
	
	public List<Report> findReport(String report,Object o){
		return reportDao.findReport(report,o);
	}
	
	public List<Report> findReport(String report){
		return reportDao.findReport(report);
	}
	public List<Report> findReport(String report,Object[] objects){
		return reportDao.findReport(report,objects);
	}

}
