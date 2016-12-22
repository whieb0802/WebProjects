package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import com.scs.model.Area;

@Component("areaDao")
public class AreaDao extends BaseDao {

	public void updateArea(Area area) {
		getHibernateTemplate().update(area);
	}

	public void deleteArea(Area area) {
		getHibernateTemplate().delete(area);
	}
	
	public void deleteAll(List<Area> area) {
		getHibernateTemplate().deleteAll(area);
	}

	public void saveArea(Area area) {
		getHibernateTemplate().save(area);
	}

	public Area getArea(Class<Area> area,int id) {
		return (Area) getSession().load(area ,id);
	}
	
	public List<Area> findArea(String area,Object o) {
		return getHibernateTemplate().find(area, o);
	}
	
	public List<Area> findArea(String area) {
		return getHibernateTemplate().find(area);
	}
	

}
