package com.scs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.scs.dao.GrowlineinfoDao;
import com.scs.model.Growlineinfo;

@Component("growlineinfoService")
public class GrowlineinfoService{
	
	private GrowlineinfoDao growlineinfoDao;
	
	@Resource
	public void setGrowlineinfoDao(GrowlineinfoDao growlineinfoDao) {
		this.growlineinfoDao = growlineinfoDao;
	}

	public GrowlineinfoDao getGrowlineinfoDao() {
		return growlineinfoDao;
	}

	public void updateGrowlineinfo(Growlineinfo growlineinfo) {
		growlineinfoDao.updateGrowlineinfo(growlineinfo);
	}

	public void deleteGrowlineinfo(Growlineinfo growlineinfo) {
		growlineinfoDao.deleteGrowlineinfo(growlineinfo);
	}
	
	public void deleteAll(List<Growlineinfo> growlineinfo) {
		growlineinfoDao.deleteAll(growlineinfo);
	}

	public void saveGrowlineinfo(Growlineinfo growlineinfo) {
		growlineinfoDao.saveGrowlineinfo(growlineinfo);

	}
	public Growlineinfo getGrowlineinfo(Class<Growlineinfo> growlineinfo,int id) {
		return (Growlineinfo)growlineinfoDao.getGrowlineinfo(growlineinfo,id);
	}
	
	public List<Growlineinfo> findGrowlineinfo(String growlineinfo,Object o){
		return growlineinfoDao.findGrowlineinfo(growlineinfo,o);
	}
	
	public List<Growlineinfo> findGrowlineinfo(String growlineinfo){
		return growlineinfoDao.findGrowlineinfo(growlineinfo);
	}
	public List<Growlineinfo> findGrowlineinfo(String growlineinfo,Object[] objects){
		return growlineinfoDao.findGrowlineinfo(growlineinfo,objects);
	}

}
