package com.whieb.digitalhome.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.whieb.digitalhome.dao.UserDao;
import com.whieb.digitalhome.model.User;
import com.whieb.digitalhome.util.UtilDao;
import com.whieb.digitalhome.util.page.PageView;
import com.whieb.digitalhome.util.page.ResultType;


@Component("userService")
public class UserService {
	
	@Resource
	private UserDao userDao;
	@Resource
	private UtilDao utilDao;
	
//	保存用户
	public void addUser(User user){
		userDao.addUser(user);
	}
//	删除用户
	public void deleteUser(User user){
		userDao.deleteUser(user);
	}
//	更新用户
	public void updateUser(User user){
		userDao.updateUser(user);
	}
//	根据用户ID得到用户对象
	public User findUser(int id){
		return userDao.findUser(id);
	}
//	利用SQL语句查询得到用户
	public List<User> findUser(String sql,Object[] user){
		return userDao.findUser(sql, user);
	}
	/**
	 * 检查用户登录
	 * 1.判断用户名是否存在 不存在返回-1
	 * 2.判断用户密码是否正确，不正确返回0
	 *   登录成功  返回1
	 */
	public int checkLogin(String name,String password){
		List<User> users = userDao.findUser("from User u where u.name = ?", new Object[]{name});
		if (users == null ||users.size() ==0) {return -1;}
		else{
			List<User> users2 = userDao.findUser("from User u where u.name=? and u.password = ?", new Object[]{name,password});
			if(users2 == null ||users2.size() == 0) return 0;
			else return 1;
		}
	}
	
	/**
	 * 分页显示用户列表
	 */
	public PageView<User> listUser(int currentPage) {
		PageView<User> pageView = new PageView<User>(PageView.MaxResutlt, currentPage);
		ResultType<User> qr = utilDao.fenye(User.class,
					pageView.getFirstResult(), pageView.getMaxResult());
		pageView.setResultType(qr);
		return pageView;
	}
}
