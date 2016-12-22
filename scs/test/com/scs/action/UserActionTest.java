package com.scs.action;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scs.model.Currentime;
import com.scs.model.User;
import com.scs.service.CurrentimeService;
import com.scs.service.DemandService;
import com.scs.service.UserService;


public class UserActionTest {
	
	
	private int userid;
	CurrentimeService currentimeService;
	
	
	
	@Test
	public void dqjs(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)ctx.getBean("userService");
		CurrentimeService ct = (CurrentimeService)ctx.getBean("currentimeService");
		
		User user = userService.getUser(User.class, 15);
		user.setIscomplete(1);
		System.out.println(user.getIscomplete());
		
		userService.updateUser(user);
		List<User> list2 = userService.findUser("from User");
		int a=1;
		for(User u:list2){
			if(u.getIscomplete()==0)
				{a=0;
			   break;}
		} 
		   
		if(a==1)
			{
			List<Currentime> list1 = ct.findCurrentime("from Currentime");
			Currentime currentime = new Currentime();
			currentime.setCurrentime(list1.get(list1.size()-1).getCurrentime()+1);
			ct.saveCurrentime(currentime);
	     	}

	}
	
	
	@Test
	public void dqjs2(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)ctx.getBean("userService");
		CurrentimeService ct = (CurrentimeService)ctx.getBean("currentimeService");
	User user = userService.getUser(User.class, 15);
	
	user.setIscomplete(1);
	System.out.print(user.getIscomplete());
	userService.updateUser(user);
	System.out.print(user.getIscomplete());
	Currentime currentime = new Currentime();
	List<Currentime> list1 = ct.findCurrentime("from Currentime");
	List<User> list2 = userService.findUser("from User");
	int a=1;
	for(User u:list2){
		if(u.getIscomplete()==0){
			a=0;
			break;
		}
	}
	if(a==1){
		currentime.setCurrentime(list1.get(list1.size()-1).getCurrentime()+1);
		currentimeService.saveCurrentime(currentime);
	}
}

	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
}
