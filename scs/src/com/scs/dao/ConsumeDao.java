package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.scs.model.Consume;

@Component("consumeDao")
public class ConsumeDao extends BaseDao  {
	
	public void updateConsume(Consume consume) {
		getHibernateTemplate().update(consume);
		
	}
	public void deleteConsume(Consume consume) {
		getHibernateTemplate().delete(consume);
	}
	public void deleteAll(List<Consume> consume) {
		getHibernateTemplate().deleteAll(consume);
	}
	public void saveConsume(Consume consume) {
		getHibernateTemplate().save(consume);
    }
	public  Consume getConsume(Class<Consume> consume,int id) {
		return (Consume)getHibernateTemplate().get(consume, id);
	}
	
	public List<Consume> findConsume(String consume) {
		return getHibernateTemplate().find(consume);
	}
	
	public List<Consume> findConsume(String consume,Object o) {
		return getHibernateTemplate().find(consume, o);
	}
	public List<Consume> findConsume(String consume,Object[] objects) {
		return getHibernateTemplate().find(consume,objects);
	}
	
}
