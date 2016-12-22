package com.scs.service;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scs.model.User;


public class UserTest {
	
	@Test	
	public void SaveUserTest(){
		
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	UserService us = (UserService)ctx.getBean("userService");
	User user = new User();
	user.setUsername("12");
	user.setRealname("Öì¿×Õæ");
	user.setPassword("123");
	us.saveUser(user);
	}
	
	
	@Test
	public void FindByNameTest(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us = (UserService)ctx.getBean("userService");
		List<User> list = us.findUser("from User u where u.username = ?","12");
		for(User u : list){
		System.out.println(u.getRealname());
	  }
	}
	@Test
	public void FindAllTest(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us = (UserService)ctx.getBean("userService");
		List<User> list = (List<User>)us.findUser("from User");
		for(User user:list){
			System.out.println(user.getRealname());
		}
	}
	
	@Test	
	public void UpdateUserTest(){
		
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	UserService us = (UserService)ctx.getBean("userService");
	User user = us.getUser(User.class, 17);
	user.setUsername("12");
	user.setRealname("diafuh");
	us.updateUser(user);
	}
}
