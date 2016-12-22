package com.scs.action;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scs.dto.UserRegisterInfo;
import com.scs.service.UserService;

public class RegisterTest {

	@Test
	public void testExecute() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us = (UserService)ctx.getBean("userService");
		
		RegisterAction ra = new RegisterAction();
		UserRegisterInfo info = new UserRegisterInfo();
		info.setUsername("x");
		info.setPassword("x");
		info.setPassword2("x");
		ra.setInfo(info);
		String ret = ra.execute();
		assertEquals("success", ret);
	}
	
	@Test
	public void testExecute2() throws Exception {
	 System.out.println(("123").equals("123"));
	}

}
