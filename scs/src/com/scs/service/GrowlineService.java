package com.scs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.scs.dao.GrowlineDao;
import com.scs.model.Growline;

@Component("growlineService")
public class GrowlineService{
	
	private GrowlineDao growlineDao;
	
	@Resource
	public void setGrowlineDao(GrowlineDao growlineDao) {
		this.growlineDao = growlineDao;
	}

	public GrowlineDao getGrowlineDao() {
		return growlineDao;
	}

	public void updateGrowline(Growline growline) {
		growlineDao.updateGrowline(growline);
	}

	public void deleteGrowline(Growline growline) {
		growlineDao.deleteGrowline(growline);
	}
	
	public void deleteAll(List<Growline> growline) {
		growlineDao.deleteAll(growline);
	}


	public void saveGrowline(Growline growline) {
		growlineDao.saveGrowline(growline);

	}
	public Growline getGrowline(Class<Growline> growline,int id) {
		return (Growline)growlineDao.getGrowline(growline,id);
	}
	
	public List<Growline> findGrowline(String growline,Object o){
		return growlineDao.findGrowline(growline,o);
	}
	
	public List<Growline> findGrowline(String growline){
		return growlineDao.findGrowline(growline);
	}
	public List<Growline> findGrowline(String growline,Object[] objects){
		return growlineDao.findGrowline(growline,objects);
	}

}
