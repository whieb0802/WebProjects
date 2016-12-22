package com.scs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.scs.dao.CurrentimeDao;
import com.scs.model.Currentime;

@Component("currentimeService")
public class CurrentimeService {

	private CurrentimeDao currentimeDao;
	
public CurrentimeService() {
	// TODO Auto-generated constructor stub
}

	@Resource(name="currentimeDao")
	public void setCurrentimeDao(CurrentimeDao currentimeDao) {
		this.currentimeDao = currentimeDao;
	}

	public CurrentimeDao getCurrentimeDao() {
		return currentimeDao;
	}
	
	public void saveCurrentime(Currentime currentime) {
		currentimeDao.saveCurrentime(currentime);

	}
	
	public void deleteCurrentime(Currentime currentime) {
		currentimeDao.deleteCurrentime(currentime);

	}
	
	public void deleteAll(List<Currentime> currentime) {
		currentimeDao.deleteAll(currentime);

	}
	
	public void updateCurrentime(Currentime currentime) {
		currentimeDao.updateCurrentime(currentime);

	}
	
	public Currentime getCurrentime(Class<Currentime> area,int id) {
		return (Currentime)currentimeDao.getCurrentime(area,id);
	}
	
	public List<Currentime> findCurrentime(String area,Object o){
		return currentimeDao.findCurrentime(area,o);
	}

	public List<Currentime> findCurrentime(String area){
		return currentimeDao.findCurrentime(area);
	}

    

}
