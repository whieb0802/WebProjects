package com.scs.service;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scs.model.Currentime;
import com.scs.model.Order;
import com.scs.model.User;


public class CurrentimeTest {
	
	@Test	
	public void AddOrderTest(){
		
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	CurrentimeService currentimeService = (CurrentimeService)ctx.getBean("currentimeService");
	Currentime currentime = currentimeService.getCurrentime(Currentime.class, 1);
	
	Currentime cu = new Currentime();
	currentimeService.saveCurrentime(currentime);
    System.out.println(currentime.getCurrentime());
	}
	
	
	@Test	
	public void AddOrderTest2(){
		
	float a = 3.5f;
	int b = (int)a;
	System.out.println(b);
	
	}
	
	
}
