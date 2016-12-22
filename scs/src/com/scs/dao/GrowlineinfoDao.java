package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.scs.model.Growline;
import com.scs.model.Growlineinfo;

@Component("growlineinfoDao")
public class GrowlineinfoDao extends BaseDao {
	
	public void saveGrowlineinfo(Growlineinfo growlineinfo) {
		getHibernateTemplate().save(growlineinfo);
	}
	
	public void deleteGrowlineinfo(Growlineinfo growlineinfo) {
		getHibernateTemplate().delete(growlineinfo);
	}
	
	public void deleteAll(List<Growlineinfo> Growlineinfo) {
		getHibernateTemplate().deleteAll(Growlineinfo);
	}
	
	public void updateGrowlineinfo(Growlineinfo growlineinfo) {
		getHibernateTemplate().update(growlineinfo);
	}
	
	public Growlineinfo getGrowlineinfo(Class<Growlineinfo> growlineinfo,int id) {
		return (Growlineinfo)getHibernateTemplate().get(growlineinfo, id);
	}
	
	public List<Growlineinfo> findGrowlineinfo(String growlineinfo) {
		return getHibernateTemplate().find(growlineinfo);
	}

	public List<Growlineinfo> findGrowlineinfo(String growlineinfo,Object o) {
		return getHibernateTemplate().find(growlineinfo, o);
	}
	
	public List<Growlineinfo> findGrowlineinfo(String growlineinfo,Object[] objects) {
		return getHibernateTemplate().find(growlineinfo,objects);
	}
}
