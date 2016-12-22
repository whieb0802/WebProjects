package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.scs.model.Currentime;
import com.scs.model.Fund;
import com.scs.model.User;

@Component("fundDao")
public class FundDao extends BaseDao{
	
	public void saveFund(Fund fund) {
		getHibernateTemplate().save(fund);
	}

	public void updateFund(Fund fund) {
		getHibernateTemplate().update(fund);
	}

	public void deleteFund(Fund fund) {
		getHibernateTemplate().delete(fund);
	}

	public void deleteAll(List<Fund> fund) {
		getHibernateTemplate().deleteAll(fund);
	}

	public Fund getFund(Class<Fund> fund,int id) {
		return (Fund)getHibernateTemplate().get(fund, id);
	}
	

	public List<Fund> findFund(String fund) {
		return getHibernateTemplate().find(fund);
	}

	public List<Fund> findFund(String fund,Object o) {
		return getHibernateTemplate().find(fund, o);
	}
	
	public List<Fund> findFund(String fund,Object[] objects){
		return getHibernateTemplate().find(fund, objects);
	}
	
		public boolean ifexists(User user ,Currentime currentime){
		List list = getHibernateTemplate().find("from Fund f where f.user = ? and f.currentime = ?  and f.currentloan != ?", new Object[]{user,currentime,0});
		if(list.size() != 0)
		   return true;
		else
		return false;
	}
	
}
