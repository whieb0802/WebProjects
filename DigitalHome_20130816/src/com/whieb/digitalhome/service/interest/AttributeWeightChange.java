package com.whieb.digitalhome.service.interest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.duineframework.recommender.core.UserId;

import com.whieb.digitalhome.dao.InterestDao;
import com.whieb.digitalhome.dao.ItemDao;
import com.whieb.digitalhome.dao.impl.RatingDaoImpl;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.MyAttribute;

public class AttributeWeightChange {

	public static Map<Long, Item> items = new HashMap<Long, Item>();
	private ItemDao itemDao;
	private InterestDao interestDao;
	private RatingDaoImpl ratingDao;

	public void weightChange(String userId) {

		double a = 0.0, b = 0.0, c = 0.0, d = 0.0;

		String sql1 = "select count(*) from IRating ir,Item it where ir.userId.id = ? and "
				+ "ir.ratableItemId.id = it.id.id group by it.publisharea";
		List<Integer> areacount = ratingDao.findRatingByuserId(userId, sql1);

		String sql2 = "select count(*) from IRating ir where ir.userId.id = ?";
		int numareacount = ratingDao.findNumCount(userId, sql2);

		String sql3 = "select count(distinct i.publisharea) from Item i";
		
		int allareacount = ratingDao.findRatingAllCount(sql3);
		int areasize = areacount.size() ;
		
		for (int x = 0; x < allareacount - areasize; x++) {
			areacount.add(0);
		}
		/*System.out.println(areacount.size()+"--"+allareacount);*/
		for (int i = 0; i < allareacount; i++) {
			a = a + (areacount.get(i) / (double)numareacount - 1.0 / allareacount)
					* (areacount.get(i) / (double)numareacount - 1.0 / allareacount);
		}

		String sql4 = "select count(*) from IRating ir,Item it where ir.userId.id = ? and "
				+ "ir.ratableItemId.id = it.id.id group by it.type";
		List<Integer> typecount = ratingDao.findRatingByuserId(userId, sql4);

		String sql5 = "select count(*) from IRating ir where ir.userId.id = ?";
		int numtypecount = ratingDao.findNumCount(userId, sql5);

		String sql6 = "select count(distinct i.type) from Item i";
		int alltypecount = ratingDao.findRatingAllCount(sql6);
		
		int typesize = typecount.size() ;
		
		for (int x = 0; x < alltypecount - typesize; x++) {
			typecount.add(0);
		}
		for (int j = 0; j < alltypecount; j++) {
			b += (typecount.get(j) / (double)numtypecount - 1.0 / alltypecount)
					* (typecount.get(j) / (double)numtypecount - 1.0 / alltypecount);
		}

		String sql7 = "select count(*) from IRating ir,Item it where ir.userId.id = ? and "
				+ "ir.ratableItemId.id = it.id.id group by it.director";
		List<Integer> directorcount = ratingDao
				.findRatingByuserId(userId, sql7);

		String sql8 = "select count(*) from IRating ir where ir.userId.id = ?";
		int numdirectorcount = ratingDao.findNumCount(userId, sql8);

		String sql9 = "select count(distinct i.director) from Item i";
		int alldirectorcount = ratingDao.findRatingAllCount(sql9);
		
		int directorsize = directorcount.size() ;
		
		for (int x = 0; x < alldirectorcount - directorsize; x++) {
			directorcount.add(0);
		}
		
		for (int m = 0; m < alldirectorcount; m++) {
			c += ( directorcount.get(m) / (double)numdirectorcount - 1.0 / alldirectorcount)
					* ( directorcount.get(m) / (double)numdirectorcount - 1.0 / alldirectorcount);
		}

		String sql10 = "select count(*) from IRating ir,Item it where ir.userId.id = ? and "
				+ "ir.ratableItemId.id = it.id.id group by it.starring";
		List<Integer> actorcount = ratingDao.findRatingByuserId(userId, sql10);

		String sql11 = "select count(*) from IRating ir where ir.userId.id = ?";
		int numactorcount = ratingDao.findNumCount(userId, sql11);

		String sql12 = "select count(distinct i.starring) from Item i";
		int allactorcount = ratingDao.findRatingAllCount(sql12);

		int actorsize = actorcount.size() ;
		
		for (int x = 0; x < allactorcount - actorsize; x++) {
			actorcount.add(0);
		}
		for (int n = 0; n < allactorcount; n++) {
			d += ( actorcount.get(n) / (double)numactorcount - 1.0 / allactorcount)
					* ( actorcount.get(n) / (double)numactorcount - 1.0 / allactorcount);
		}

		double p1 = a / (a + b + c + d);
		double p2 = b / (a + b + c + d);
		double p3 = c / (a + b + c + d);
		double p4 = d / (a + b + c + d);

		MyAttribute attribute1 = new MyAttribute();
		MyAttribute attribute2 = new MyAttribute();
		MyAttribute attribute3 = new MyAttribute();
		MyAttribute attribute4 = new MyAttribute();
		String u = "" + userId;
		UserId ui = new UserId(u);
		
		attribute1.setUser(ui);
		attribute1.setAttribute("出品地");
		attribute1.setWeight(p1);
		attribute1.setType(0);
		interestDao.saveAttribute(attribute1);
		
		attribute2.setUser(ui);
		attribute2.setAttribute("类型");
		attribute2.setWeight(p2);
		attribute2.setType(1);
		interestDao.saveAttribute(attribute2);
		
		attribute3.setUser(ui);
		attribute3.setWeight(p3);
		attribute3.setAttribute("导演");
		attribute3.setType(2);
		interestDao.saveAttribute(attribute3);
		
		attribute4.setUser(ui);
		attribute4.setWeight(p4);
		attribute4.setAttribute("主演");
		attribute4.setType(3);
		interestDao.saveAttribute(attribute4);
		
	}

	/*
	 * public void enterFeedback(IRating r) throws DuineException { UserId
	 * userId = r.getUserId(); String userIdStr = userId.getId(); if (userIdStr
	 * == null || userIdStr.trim().length() == 0) { return; }
	 * 
	 * RatableItemId itemId = r.getRatableItemId(); String itemIdStr =
	 * itemId.getId(); if (itemIdStr == null || itemIdStr.trim().length() == 0)
	 * { return; } long i = Long.parseLong(itemIdStr);
	 * 
	 * Item item = null; if (items.containsKey(i)) { item = items.get(i); }
	 * 
	 * if (item == null) { item = itemDao.findItem(i); if (item == null) {
	 * return; } items.put(i, item); }
	 * 
	 * //查找出某用户对属性的所有兴趣 List<MyAttribute> attributes =
	 * interestDao.allAttributeList(userIdStr);
	 * 
	 * //查找出某用户此次评论之前的评论
	 * 
	 * IRating rating = (IRating) ratingDao.getPreRating(userId);
	 * 
	 * Item preItem = null; if(rating != null) { RatableItemId preItemId
	 * =rating.getRatableItemId(); String preItemIdStr = preItemId.getId(); if
	 * (preItemIdStr == null || preItemIdStr.trim().length() == 0) { return; }
	 * long j = Long.parseLong(preItemIdStr); //查找评论对应的item preItem =
	 * itemDao.findItem(j); }
	 * 
	 * 
	 * if(attributes == null || attributes.size() == 0 || rating == null) {
	 * MyAttribute attribute1 = new MyAttribute(); MyAttribute attribute2 = new
	 * MyAttribute(); MyAttribute attribute3 = new MyAttribute(); MyAttribute
	 * attribute4 = new MyAttribute(); attribute1.setUser(userId);
	 * attribute1.setAttribute("类型"); attribute1.setWeight(0.25);
	 * interestDao.saveAttribute(attribute1); attribute2.setUser(userId);
	 * attribute2.setAttribute("出品地"); attribute2.setWeight(0.25);
	 * interestDao.saveAttribute(attribute2); attribute3.setUser(userId);
	 * attribute3.setWeight(0.25); attribute3.setAttribute("导演");
	 * interestDao.saveAttribute(attribute3); attribute4.setUser(userId);
	 * attribute4.setWeight(0.25); attribute4.setAttribute("主演");
	 * interestDao.saveAttribute(attribute4); }
	 * 
	 * if(rating != null && attributes != null && attributes.size() != 0) {
	 * double c=0.2;
	 * 
	 * MyAttribute ma1 = attributes.get(0); double curWeight1 = ma1.getWeight();
	 * 
	 * MyAttribute ma2 = attributes.get(1); double curWeight2 = ma2.getWeight();
	 * 
	 * MyAttribute ma3 = attributes.get(2); double curWeight3 = ma3.getWeight();
	 * 
	 * MyAttribute ma4 = attributes.get(3); double curWeight4 = ma4.getWeight();
	 * if(preItem.getType().equals(item.getType())) { double newWeight =
	 * curWeight1 * (1.0 + c); ma1.setWeight(newWeight);
	 * interestDao.saveAttribute(ma1); } else { double newWeight = curWeight1 *
	 * (1.0 - c); ma1.setWeight(newWeight); interestDao.saveAttribute(ma1); }
	 * 
	 * if(preItem.getPublisharea().equals(item.getPublisharea())) { double
	 * newWeight = curWeight2 * (1.0 + c); ma2.setWeight(newWeight);
	 * interestDao.saveAttribute(ma2); } else { double newWeight = curWeight2 *
	 * (1.0 - c); ma2.setWeight(newWeight); interestDao.saveAttribute(ma2); }
	 * 
	 * if(preItem.getDirector().equals(item.getDirector())) { double newWeight =
	 * curWeight3 * (1.0 + c); ma3.setWeight(newWeight);
	 * interestDao.saveAttribute(ma3); } else { double newWeight = curWeight3 *
	 * (1.0 - c); ma3.setWeight(newWeight); interestDao.saveAttribute(ma3); }
	 * 
	 * String preActor = preItem.getStarring(); String nowActor =
	 * item.getStarring(); String[] pre = preActor.split(" "); String[] now =
	 * nowActor.split(" "); boolean similarity = false; for(int m=0; m<
	 * pre.length ; m++) { for(int n=0; n<now.length ; n++){
	 * if(pre[m].equals(now[n])) { similarity = true; continue; } } }
	 * if(similarity == true) { double newWeight = curWeight4 * (1.0 + c);
	 * ma4.setWeight(newWeight); interestDao.saveAttribute(ma4); } else { double
	 * newWeight = curWeight4 * (1.0 - c); ma4.setWeight(newWeight);
	 * interestDao.saveAttribute(ma4); }
	 * 
	 * List<MyAttribute> newAttributes =
	 * interestDao.allAttributeList(userIdStr); double allAttributeValue = 0.0;
	 * for(MyAttribute attribute : newAttributes) {
	 * System.out.println(attribute.getAttribute()+ attribute.getWeight());
	 * allAttributeValue += attribute.getWeight(); } for(MyAttribute
	 * finalAttribute : newAttributes) {
	 * finalAttribute.setWeight(finalAttribute.getWeight() / allAttributeValue);
	 * interestDao.saveAttribute(finalAttribute); }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	public static Map<Long, Item> getItems() {
		return items;
	}

	public static void setItems(Map<Long, Item> items) {
		AttributeWeightChange.items = items;
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

	public RatingDaoImpl getRatingDao() {
		return ratingDao;
	}

	public void setRatingDao(RatingDaoImpl ratingDao) {
		this.ratingDao = ratingDao;
	}

}
