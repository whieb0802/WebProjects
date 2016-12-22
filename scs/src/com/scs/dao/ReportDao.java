package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.scs.model.Report;

@Component("reportDao")
public class ReportDao extends BaseDao {
	
	public void saveReport(Report report) {
		getHibernateTemplate().save(report);
	}
	
	public void deleteReport(Report report) {
		getHibernateTemplate().delete(report);
	}
	
	public void deleteAll(List<Report> report) {
		getHibernateTemplate().deleteAll(report);
	}
	
	public void updateReport(Report report) {
		getHibernateTemplate().update(report);
	}
	
	public Report getReport(Class<Report> report,int id) {
		return (Report)getHibernateTemplate().get(report, id);
	}
	
	public List<Report> findReport(String report) {
		return getHibernateTemplate().find(report);
	}

	public List<Report> findReport(String report,Object o) {
		return getHibernateTemplate().find(report, o);
	}
	
	public List<Report> findReport(String report,Object[] objects) {
		return getHibernateTemplate().find(report,objects);
	}
}
