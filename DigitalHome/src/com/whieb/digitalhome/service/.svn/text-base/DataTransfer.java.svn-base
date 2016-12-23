package com.whieb.digitalhome.service;

import java.util.ArrayList;
import java.util.List;

import org.duineframework.recommender.core.RatableItemId;
import org.duineframework.recommender.core.UserId;
import org.duineframework.recommender.profile.rating.Rating;

import com.whieb.digitalhome.dao.NewTradeDao;
import com.whieb.digitalhome.dao.RatingDao;
import com.whieb.digitalhome.model.IRating;
import com.whieb.digitalhome.model.NewTrade;

/**
 * @author Vicky 2012-11-8 数据转换器：从统计后的New_Trade表中计算Rating表信息
 */
public class DataTransfer {
	private NewTradeDao tradeDao;
	private RatingDao ratingDao;

	public NewTradeDao getTradeDao() {
		return tradeDao;
	}

	public void setTradeDao(NewTradeDao tradeDao) {
		this.tradeDao = tradeDao;
	}

	public RatingDao getRatingDao() {
		return ratingDao;
	}

	public void setRatingDao(RatingDao ratingDao) {
		this.ratingDao = ratingDao;
	}

	public void mainJob() {
		System.out.println("job is running ...");
		// 从NewTrade表中导出数据，计算评分，插入Rating表中
		// 导出所有user
		List<UserId> uids = tradeDao.getAllUserIds();
		if (null == uids || uids.size() == 0) {
			return;
		}
		ratingDao.clearAll();// 清空Rating
		// 取出平均点播次数
		double average = tradeDao.getAverageCount();
		System.out.println("average = " + average);
		// 计算每个User的评分
		List<Rating> ratings = new ArrayList<Rating>();
		for (UserId u : uids) {
			List<NewTrade> trades = tradeDao.getUserTrades(u);// 取出每个用户的交易记录
			if (null == trades || trades.size() == 0) {
				continue;
			}
			for (NewTrade t : trades) {
				System.out.println(t.getTimes());
				double rating = Math.min(1, t.getTimes() / average) * 4 + 1;// 计算评分
				RatableItemId itemId = new RatableItemId(String.valueOf(t
						.getItemId()));
				IRating r = new IRating(u, itemId, rating, 1.00);
				ratings.add(r);
			}
			// 将Rating插入Rating表中
			ratingDao.addAll(ratings);
			ratings.clear();// 清空
		}
		System.out.println("job is done ...");
	}
}
