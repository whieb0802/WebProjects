package com.whieb.digitalhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.whieb.digitalhome.dao.ConnectionDao;
import com.whieb.digitalhome.model.Connection;
import com.whieb.digitalhome.util.UtilDao;

/*
 * @author   yujifang
 */
@Component("connectionDao")
public class ConnectionDaoImpl implements ConnectionDao {
	private UtilDao utilDao;
	
	public UtilDao getUtilDao() {
		return utilDao;
	}
    @Resource
	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	@Override
	public void saveOrUpdata(Connection c) {
		utilDao.saveOrUpdate(c);
	}

	@Override
	public List<Connection> getConnectionByResourceId(long resourceId) {
		return utilDao.find("from Connection con where con.resourceId = ?", new Object[]{resourceId});
	}

	@Override
	public List<Connection> getAllConnection() {
		return utilDao.find("from Connection con", null);
	}
	@Override
	public void deleteConnection(List<Connection> con) {
		for(Connection c:con)
		     utilDao.delete(c);
	}

}
