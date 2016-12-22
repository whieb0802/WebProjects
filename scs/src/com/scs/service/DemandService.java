package com.scs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.scs.dao.DemandDao;
import com.scs.model.Demand;

@Component("demandService")
public class DemandService{
	
	private DemandDao demandDao;
	

	@Resource
	public void setDemandDao(DemandDao demandDao) {
		this.demandDao = demandDao;
	}

	public DemandDao getDemandDao() {
		return demandDao;
	}

	
	public void updateDemand(Demand demand) {
		demandDao.updateDemand(demand);

	}

	public void deleteDemand(Demand demand) {
		demandDao.deleteDemand(demand);

	}
	
	public void deleteAll(List<Demand> demand) {
		demandDao.deleteAll(demand);

	}

	public void saveDemand(Demand demand) {
		demandDao.saveDemand(demand);

	}

	public Demand getDemand(Class<Demand> demand,int id) {
		return (Demand)demandDao.getDemand(demand,id);
	}
	
	public List<Demand> findDemand(String demand,Object o){
		return demandDao.findDemand(demand,o);
	}
	
	public List<Demand> findDemand(String demand){
		return demandDao.findDemand(demand);
	}
	public List<Demand> findDemand(String demand,Object[] objects){
		return demandDao.findDemand(demand,objects);
	}
}
