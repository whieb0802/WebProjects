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

public class UserInterestActorHandle implements AttributeHandle {
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
		
		// 查找出某用户对属性值的所有兴趣
		List<MyInterest> interests = interestDao.allInterestList(userIdStr);
		
		//Item的主演属性值
		String actors = item.getStarring();
		String[] str = actors.split(" ");
		
		boolean have = false;
		
		for(int m=0; m<str.length; m++) {
			if (interests != null && interests.size() > 0) {
				for (MyInterest interest : interests) {
					if(interest.getSubjectType() == 3 ){				
						if (interest.getSubject().equals(str[m])) {
							int newcount = interest.getCounts() + 1 ;
							interest.setCounts(newcount);
							interestDao.saveInterest(interest);
							have = true;
						}
					}
				}
			}
			if (interests == null || interests.size() == 0 || have == false) {
				int newcount = 1; 
				MyInterest interest = new MyInterest();
				interest.setSubjectType(3);
				interest.setUser(userId);
				interest.setSubject(str[m]);
				interest.setCounts(newcount);
				interestDao.saveInterest(interest);
			}
		}
		
		List<MyInterest> actorinterests = interestDao.allInterestList(userIdStr, 3);
		
		int allCounts = 0;
		
		for(MyInterest mi : actorinterests) {
			allCounts += mi.getCounts();
		}
		
		for(MyInterest myinterest : actorinterests) {
			double newWeight =(double)myinterest.getCounts() / (double)allCounts ;
			myinterest.setWeight(newWeight);
			interestDao.saveInterest(myinterest);
		}

	}

	public static Map<Long, Item> getItems() {
		return items;
	}

	public static void setItems(Map<Long, Item> items) {
		UserInterestActorHandle.items = items;
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
