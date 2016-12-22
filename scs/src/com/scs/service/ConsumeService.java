package com.scs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.scs.dao.ConsumeDao;
import com.scs.model.Bill;
import com.scs.model.Consume;

@Component("consumeService")
public class ConsumeService{
	
	private ConsumeDao consumeDao;
	

	@Resource
	public void setconsumeDao(ConsumeDao consumeDao) {
		this.consumeDao = consumeDao;
	}

	public ConsumeDao getconsumeDao() {
		return consumeDao;
	}

	
	public void updateConsume(Consume consume) {
		consumeDao.updateConsume(consume);

	}

	public void deleteConsume(Consume consume) {
		consumeDao.deleteConsume(consume);

	}
	
	public void deleteAll(List<Consume> consume) {
		consumeDao.deleteAll(consume);
	}

	public void saveConsume(Consume consume) {
		consumeDao.saveConsume(consume);

	}

	public Consume getConsume(Class<Consume> consume,int id) {
		return (Consume)consumeDao.getConsume(consume,id);
	}
	
	public List<Consume> findConsume(String consume,Object o){
		return consumeDao.findConsume(consume,o);
	}
	
	public List<Consume> findConsume(String consume){
		return consumeDao.findConsume(consume);
	}
	public List<Consume> findConsume(String consume,Object[] objects){
		return consumeDao.findConsume(consume,objects);
	}
}
