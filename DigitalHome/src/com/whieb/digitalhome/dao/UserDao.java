package com.whieb.digitalhome.dao;

import java.util.List;


import com.whieb.digitalhome.model.User;

public interface UserDao {

	public void addUser(User user);

	public void deleteUser(User user);

	public void updateUser(User user);

	public User findUser(int id);
	
	public List<User> findAllUser();
	
	public List<User> findUser(String sql,Object[] obj);

}
