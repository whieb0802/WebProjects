package service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.whieb.digitalhome.model.User;
import com.whieb.digitalhome.service.UserService;


public class UserServiceTest {
	
	private static UserService us;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext("beans*.xml");
			us = (UserService)cxt.getBean("userService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAdd(){
		for (int i = 1; i <= 100; i++) {
			User user = new User();
			user.setKey((long)i);
			user.setName("test"+i);
			user.setPassword("test"+i);
			us.addUser(user);
		}
	}
	

}
