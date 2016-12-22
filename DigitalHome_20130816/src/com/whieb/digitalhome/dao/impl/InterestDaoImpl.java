package com.whieb.digitalhome.dao.impl;

import java.util.List;

import com.whieb.digitalhome.dao.InterestDao;
import com.whieb.digitalhome.model.MyAttribute;
import com.whieb.digitalhome.model.MyInterest;
import com.whieb.digitalhome.util.UtilDao;

public class InterestDaoImpl implements InterestDao {

	private UtilDao utilDao;
	
	/*public List<InterestHibernate> findType(String sql, Object[] o,int limits) {	
		return utilDao.findMaxResult(sql, o, limits);
	}
	
	public List<InterestHibernate> findInterestSize(String sql, Object[] o) {
		return utilDao.find(sql, o);
	}
	
	public List<InterestHibernate> allInterestList(String userIdStr) {
		String sql = "select * from InterestHibernate interest where interest.user.id = ?";
		return utilDao.find(sql, new Object[]{userIdStr});
	}*/
	
	
	

	public List<MyInterest> findType(String sql, Object[] o, int limits) {
		return utilDao.findMaxResult(sql, o, limits);
	}

	public List<MyInterest> findInterest(String sql, Object[] o) {
		return utilDao.find(sql, o);
	}

	public List<MyInterest> allInterestList(String userIdStr) {
		String sql = "from MyInterest interest where interest.user.id = ?";
		return utilDao.find(sql, new Object[]{userIdStr});
	}

	public List<MyAttribute> allAttributeList(String userIdStr) {
		String sql = "from MyAttribute attribute where attribute.user.id = ? order by attribute.weight desc";
		return utilDao.find(sql, new Object[]{userIdStr});
	}
	
	public List<MyInterest> allInterestList(String userIdStr,int subjectType) {
		String sql = "from MyInterest interest where interest.user.id = ? and interest.subjectType = ?";
		return utilDao.find(sql, new Object[]{userIdStr , subjectType});
	}

	public void saveInterest(MyInterest myInterest) {
		utilDao.saveOrUpdate(myInterest);
	}
	
	public void saveAttribute(MyAttribute myAttribute) {
		utilDao.saveOrUpdate(myAttribute);
	}
	
	public void clear() {
		utilDao.execute("delete from MyAttribute");
		utilDao.execute("delete from MyInterest");
	}
	
	public UtilDao getUtilDao() {
		return utilDao;
	}
	
	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}
	
	
	

}
