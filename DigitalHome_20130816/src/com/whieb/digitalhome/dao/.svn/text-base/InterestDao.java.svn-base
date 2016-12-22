package com.whieb.digitalhome.dao;

import java.util.List;

import com.whieb.digitalhome.model.MyAttribute;
import com.whieb.digitalhome.model.MyInterest;

public interface InterestDao {
	
	/*public List<InterestHibernate> findType(String sql,Object[] o,int limits);
	
	public List<InterestHibernate> findInterestSize(String sql, Object[] o);
	
	public List<InterestHibernate> allInterestList(String userIdStr);*/
	
	public List<MyInterest> findType(String sql,Object[] o,int limits);
	
	public List<MyInterest> findInterest(String sql, Object[] o);
	
	public List<MyInterest> allInterestList(String userIdStr);
	
	public List<MyAttribute> allAttributeList(String userIdStr);
	
	public List<MyInterest> allInterestList(String userIdStr,int subjectType);
	
	public void saveInterest(MyInterest myInterest);
	
	public void saveAttribute(MyAttribute myAttribute);
	
	public void clear();
}
