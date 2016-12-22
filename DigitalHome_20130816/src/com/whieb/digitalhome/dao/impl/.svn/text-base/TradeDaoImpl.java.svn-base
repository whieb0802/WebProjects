package com.whieb.digitalhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.whieb.digitalhome.dao.TradeDao;
import com.whieb.digitalhome.model.Trade;
import com.whieb.digitalhome.util.UtilDao;

/*
 * @author  yujifang
 */

@Component("tradeDao")
public class TradeDaoImpl implements TradeDao {
	private UtilDao utilDao;



	public UtilDao getUtilDao() {
		return utilDao;
	}

	@Resource(name = "utilDao")
	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	public List<Trade> findTradeByuserId(long userId) {
		String sql = "from Trade t where t.userId = ?";
		return utilDao.find(sql, new Object[]{userId});
	}

}
