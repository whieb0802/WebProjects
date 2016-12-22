package com.scs.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component("baseDao")
public class BaseDao extends HibernateDaoSupport {
	
	@Resource(name="sessionFactory")
	public void baseSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

}
