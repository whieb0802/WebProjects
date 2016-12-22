package com.scs.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import com.scs.dao.AreaDao;
import com.scs.model.Area;

@Component("areaService")
public class AreaService{

	private AreaDao areaDao;
    @Resource
	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}

	public AreaDao getAreaDao() {
		return areaDao;
	}

	public void saveArea(Area area) {
		areaDao.saveArea(area);

	}
	
	public void deleteArea(Area area) {
		areaDao.deleteArea(area);
	}
	
	public void deleteAll(List<Area> area) {
		areaDao.deleteAll(area);
	}
	
	
	public void updateArea(Area area) {
		areaDao.updateArea(area);
	}

	public Area getArea(Class<Area> area,int id) {
		return (Area)areaDao.getArea(area,id);
	}
	
	public List<Area> findArea(String area,Object o){
		return areaDao.findArea(area,o);
	}
	
	public List<Area> findArea(String area){
		return areaDao.findArea(area);
	}

}
