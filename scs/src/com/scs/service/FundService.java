package com.scs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.scs.dao.FundDao;
import com.scs.model.Currentime;
import com.scs.model.Fund;
import com.scs.model.User;

@Component("fundService")
public class FundService{

	private FundDao fundDao;
	
    @Resource
	public void setFundDao(FundDao fundDao) {
		this.fundDao = fundDao;
	}

	public FundDao getFundDao() {
		return fundDao;
	}

	public void saveFund(Fund fund) {
		fundDao.saveFund(fund);

	}
	
	public void deleteFund(Fund fund) {
		fundDao.deleteFund(fund);
	}
	public void deleteAll(List<Fund> fund) {
		fundDao.deleteAll(fund);
	}
	
	public void updateFund(Fund fund) {
		fundDao.updateFund(fund);
	}

	public Fund getFund(Class<Fund> fund,int id) {
		return (Fund)fundDao.getFund(fund,id);
	}
	
	public List<Fund> findFund(String fund,Object o){
		return fundDao.findFund(fund,o);
	}
	
	public List<Fund> findFund(String fund){
		return fundDao.findFund(fund);
	}
	public List<Fund> findFund(String fund,Object[] objects){
		return fundDao.findFund(fund, objects);
	}

	public boolean ifexists(User user ,Currentime currentime){
		return fundDao.ifexists(user, currentime);
	}

}
