package com.whieb.digitalhome.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import com.whieb.digitalhome.dao.UserDao;
import com.whieb.digitalhome.model.User;
import com.whieb.digitalhome.util.UtilDao;

@Component("userDao")
public class UserDaoImpl implements UserDao {

	private UtilDao utilDao;

	public UtilDao getUtilDao() {
		return utilDao;
	}

	@Resource
	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}

	@Override
	public void addUser(User user) {
		utilDao.save(user);

	}

	@Override
	public void deleteUser(User user) {
		utilDao.delete(user);

	}

	@Override
	public void updateUser(User user) {
		utilDao.update(user);

	}

	@Override
	public User findUser(int id) {
		return utilDao.find(User.class, id);
	}

	public List<User> findUser(String sql, Object[] obj) {
		return utilDao.find(sql, obj);
	}

	@Override
	public List<User> findAllUser() {
		String sql = "from User u order by key asc";
		return utilDao.find(sql, null);
	}

}
