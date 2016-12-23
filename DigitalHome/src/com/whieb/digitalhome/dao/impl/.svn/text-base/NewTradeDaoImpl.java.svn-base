package com.whieb.digitalhome.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.duineframework.recommender.core.UserId;

import com.whieb.digitalhome.dao.NewTradeDao;
import com.whieb.digitalhome.model.NewTrade;
import com.whieb.digitalhome.util.UtilDao;

/**
 * @author Vicky 2012-11-8
 */
public class NewTradeDaoImpl implements NewTradeDao {
	private UtilDao utilDao;

	public UtilDao getUtilDao() {
		return utilDao;
	}

	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	@Override
	// 得到平均点播次数
	public double getAverageCount() {
		double count = Double.parseDouble(utilDao.uniqueResult(
				"select avg(times*1.0) from NewTrade", null).toString());// 计算平均点播次数
		return count;
	}

	@Override
	// 得到所有的用户id
	public List<UserId> getAllUserIds() {
		List<Long> uids = utilDao.find("select distinct userId from NewTrade",
				null);
		if (null == uids || uids.size() == 0) {
			return new ArrayList<UserId>();
		}
		List<UserId> uid = new ArrayList<UserId>();
		for (Long l : uids) {
			UserId u = new UserId(String.valueOf(l));
			uid.add(u);
		}
		return uid;
	}

	@Override
	// 得到某用户的所有Trade记录
	public List<NewTrade> getUserTrades(UserId uid) {
		List<NewTrade> trades = new ArrayList<NewTrade>();
		trades = utilDao.find("from NewTrade where userId = ?",
				new Object[] { Long.parseLong(uid.getId()) });
		return trades;
	}

}
