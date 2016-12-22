package com.whieb.digitalhome.service.interest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.duineframework.recommender.core.DuineException;
import org.duineframework.recommender.core.RatableItemId;
import org.duineframework.recommender.core.UserId;

import com.whieb.digitalhome.dao.InterestDao;
import com.whieb.digitalhome.dao.ItemDao;
import com.whieb.digitalhome.model.IRating;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.MyInterest;

public class UserInterestAreaHandle implements AttributeHandle {
	public static Map<Long, Item> items = new HashMap<Long, Item>();
	private ItemDao itemDao;
	private InterestDao interestDao;

	public void enterFeedback(IRating r) throws DuineException {

		UserId userId = r.getUserId();
		String userIdStr = userId.getId();
		if (userIdStr == null || userIdStr.trim().length() == 0) {
			return;
		}

		RatableItemId itemId = r.getRatableItemId();
		String itemIdStr = itemId.getId();
		if (itemIdStr == null || itemIdStr.trim().length() == 0) {
			return;
		}
		long i = Long.parseLong(itemIdStr);

		Item item = null;
		if (items.containsKey(i)) {
			item = items.get(i);
		}

		if (item == null) {
			item = itemDao.findItem(i);
			if (item == null) {
				return;
			}
			items.put(i, item);
		}

		// 曾经评论过的Item的数目
		int icount = itemDao.itemCount(r.getId(), userIdStr);
		// 查找出某用户的所有兴趣
		List<MyInterest> interests = interestDao.allInterestList(userIdStr);
		boolean have = false;

		if (interests != null && interests.size() > 0) {
			for (MyInterest interest : interests) {
				double curentWeight = interest.getWeight();
				// List<String> subjects = item.getSubjects();
				if(interest.getSubjectType() == 0){
					if (interest.getSubject().equals(item.getPublisharea())) {
						double newWeight = (curentWeight * icount + 1)
								/ (icount + 1);
						interest.setWeight(newWeight);
						interestDao.saveInterest(interest);
						have = true;
					} else {
						double newWeight = (curentWeight * icount) / (icount + 1);
						interest.setWeight(newWeight);
						interestDao.saveInterest(interest);
					}
				}
			}
		}
		if (interests == null || interests.size() == 0 || have == false) {
			double newWeight = (double)1.0 / (icount + 1);
			MyInterest interest = new MyInterest();
			interest.setSubjectType(0);
			interest.setUser(userId);
			interest.setWeight(newWeight);
			interest.setSubject(item.getPublisharea());
			interestDao.saveInterest(interest);
		}

	}

	public static Map<Long, Item> getItems() {
		return items;
	}

	public static void setItems(Map<Long, Item> items) {
		UserInterestAreaHandle.items = items;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public InterestDao getInterestDao() {
		return interestDao;
	}

	public void setInterestDao(InterestDao interestDao) {
		this.interestDao = interestDao;
	}

}
