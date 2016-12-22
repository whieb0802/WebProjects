package com.whieb.digitalhome.service.interest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.duineframework.recommender.core.DuineException;
import org.duineframework.recommender.core.IRatableItem;
import org.duineframework.recommender.profile.rating.Rating;

import com.whieb.digitalhome.dao.InterestDao;
import com.whieb.digitalhome.dao.ItemDao;
import com.whieb.digitalhome.dao.UserDao;
import com.whieb.digitalhome.dao.impl.RatingDaoImpl;
import com.whieb.digitalhome.model.IRating;
import com.whieb.digitalhome.model.User;

public class UserInterestReplay {
	public static Map<Long, IRatableItem> items = new HashMap<Long, IRatableItem>();

	RatingDaoImpl ratingDao;
	UserDao userDao;
	ItemDao itemDao;
	InterestDao interestDao;
	/*AttributeHandle attriHandle;*/
	UserInterestAreaHandle attriAreaHandle;
	UserInterestTypeHandle attriTypeHandle;
	UserInterestDirectorHandle attriDirectorHandle;
	UserInterestActorHandle attriActorHandle;
	AttributeWeightChange attributeWeight;
	List<User> users = new ArrayList<User>();
	List<User> usersT = new ArrayList<User>();

	public final void replay(String userId) throws DuineException {
		/*//查找所有的user，存入到List集合中
		users = userDao.findAllUser();
		
		
		for (User user : users) {
			System.out.println(user);
			Collection<Rating> ratings = ratingDao.getRatings("1");
			if (ratings.size() == 0) {
				continue;
			}
			for (Rating r : ratings) {
				handleItemFeedback((IRating) r);
				
			}
		}	*/
//		interestDao.clear();
		attributeWeight.weightChange(userId);
		Collection<Rating> ratings = ratingDao.getRatings(userId);
		if (ratings.size() == 0) {
			System.out.println("null");
		}
		for (Rating r : ratings) {
			handleItemFeedback((IRating) r);
			
		}
		
		
	}

	

	private void handleItemFeedback(IRating r) throws DuineException{
		attriAreaHandle.enterFeedback(r);
		attriTypeHandle.enterFeedback(r);
		attriDirectorHandle.enterFeedback(r);
		attriActorHandle.enterFeedback(r);
		/*attributeWeight.enterFeedback(r);*/
	}



	public RatingDaoImpl getRatingDao() {
		return ratingDao;
	}

	public void setRatingDao(RatingDaoImpl ratingDao) {
		this.ratingDao = ratingDao;
	}



	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
/*
	public AttributeHandle getAttriHandle() {
		return attriHandle;
	}

	public void setAttriHandle(AttributeHandle attriHandle) {
		this.attriHandle = attriHandle;
	}*/

	public List<User> getUsers() {
		return users;
	}

	public UserInterestAreaHandle getAttriAreaHandle() {
		return attriAreaHandle;
	}



	public void setAttriAreaHandle(UserInterestAreaHandle attriAreaHandle) {
		this.attriAreaHandle = attriAreaHandle;
	}



	public UserInterestTypeHandle getAttriTypeHandle() {
		return attriTypeHandle;
	}



	public void setAttriTypeHandle(UserInterestTypeHandle attriTypeHandle) {
		this.attriTypeHandle = attriTypeHandle;
	}



	public UserInterestDirectorHandle getAttriDirectorHandle() {
		return attriDirectorHandle;
	}



	public void setAttriDirectorHandle(
			UserInterestDirectorHandle attriDirectorHandle) {
		this.attriDirectorHandle = attriDirectorHandle;
	}



	public UserInterestActorHandle getAttriActorHandle() {
		return attriActorHandle;
	}



	public void setAttriActorHandle(UserInterestActorHandle attriActorHandle) {
		this.attriActorHandle = attriActorHandle;
	}



	public AttributeWeightChange getAttributeWeight() {
		return attributeWeight;
	}



	public void setAttributeWeight(AttributeWeightChange attributeWeight) {
		this.attributeWeight = attributeWeight;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}



	public InterestDao getInterestDao() {
		return interestDao;
	}



	public void setInterestDao(InterestDao interestDao) {
		this.interestDao = interestDao;
	}

}
