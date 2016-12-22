package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.scs.model.Currentime;
import com.scs.model.Demand;

@Component("demandDao")
public class DemandDao extends BaseDao  {
	
	public void updateDemand(Demand demand) {
		getHibernateTemplate().update(demand);
		
	}
	public void deleteDemand(Demand demand) {
		getHibernateTemplate().delete(demand);
		
	}
	public void deleteAll(List<Demand> demand) {
		getHibernateTemplate().deleteAll(demand);
	}
	public void saveDemand(Demand demand) {
		getHibernateTemplate().save(demand);
    }
	public  Demand getDemand(Class<Demand> demand,int id) {
		return (Demand)getHibernateTemplate().get(demand, id);
	}
	
	public List<Demand> findDemand(String demand) {
		return getHibernateTemplate().find(demand);
	}
	
	public List<Demand> findDemand(String demand,Object o) {
		return getHibernateTemplate().find(demand, o);
	}
	public List<Demand> findDemand(String demand,Object[] objects) {
		return getHibernateTemplate().find(demand,objects);
	}
	
}
