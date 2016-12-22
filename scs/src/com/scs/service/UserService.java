package com.scs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.scs.dao.UserDao;
import com.scs.model.User;

@Component("userService")

public class UserService{

	private UserDao userDao;
	
    @Resource(name="userDao")
	public void setUserDao(UserDao UserDao) {
		this.userDao = UserDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void saveUser(User user) {
		userDao.saveUser(user);

	}
	
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}
	
	public void deleteAll(List<User> user) {
		userDao.deleteAll(user);
	}
	
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	public User getUser(Class<User> user,int id) {
		return (User)userDao.getUser(user,id);
	}
	
	public List<User> findUser(String user,Object o){
		return userDao.findUser(user,o);
	}
	
	public List<User> findUser(String user){
		return userDao.findUser(user);
	}

}
