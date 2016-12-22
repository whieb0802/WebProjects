package com.scs.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.scs.model.User;

@Component("userDao")
public class UserDao extends BaseDao{
	
	public void saveUser(User user) {
		getHibernateTemplate().save(user);
	}
	
	public void deleteUser(User user) {
		getHibernateTemplate().delete(user);
	}
	
	public void deleteAll(List<User> user) {
		getHibernateTemplate().deleteAll(user);
	}
	
	public void updateUser(User user) {
		getHibernateTemplate().update(user);
	}
	
	public User getUser(Class<User> user,int id) {
		return (User) getSession().load(user ,id);
	}
	
	public List<User> findUser(String user) {
		return getHibernateTemplate().find(user);
	}
	
	public List<User> findUser(String user,Object o) {
		return getHibernateTemplate().find(user, o);
	}

	public Boolean existsByUsername(String username){
		List<User> list = getHibernateTemplate().find("from User u where u.username = ?", username);
		if(list.size() == 0 || list == null)
			return false;
		else 
			return true;
	}
//	public User findUserByUsername(String username){
//		return getHibernateTemplate().get(username, 1);
//	}
}