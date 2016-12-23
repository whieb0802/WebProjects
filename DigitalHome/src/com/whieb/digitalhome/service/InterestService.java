package com.whieb.digitalhome.service;

import java.util.ArrayList;
import java.util.List;

import org.duineframework.recommender.core.UserId;

import com.whieb.digitalhome.dao.InterestDao;
import com.whieb.digitalhome.model.MyAttribute;
import com.whieb.digitalhome.model.MyInterest;

public class InterestService {

	private InterestDao interestDao;
	
	public List<MyInterest> findInterest(int parameter, UserId user , int subjectType) {

		List<MyInterest> interests = new ArrayList<MyInterest>();
		String sql = "from MyInterest mi where mi.user.id = ? and mi.subjectType = ? order by mi.weight desc ";
		interests = interestDao.findType(sql, new Object[] { user.getId(),subjectType },
				parameter);
		return interests;
	}

	public List<MyAttribute> findAttribute(UserId user) {
		List<MyAttribute> attribute = new ArrayList<MyAttribute>();
		attribute = interestDao.allAttributeList(user.getId());
		return attribute;
		
	}

	public InterestDao getInterestDao() {
		return interestDao;
	}

	public void setInterestDao(InterestDao interestDao) {
		this.interestDao = interestDao;
	}



}
