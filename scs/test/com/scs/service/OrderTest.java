package com.scs.service;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scs.model.Currentime;
import com.scs.model.Order;
import com.scs.model.User;


public class OrderTest {
	
	@Test	
	public void AddOrderTest(){
		
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	OrderService orderService = (OrderService)ctx.getBean("orderService");
	CurrentimeService currentimeService = (CurrentimeService)ctx.getBean("currentimeService");
	
	Currentime currentime = currentimeService.getCurrentime(Currentime.class, 2);
	Order order = new Order();

	order.setCurrentime(currentime);
	order.setOfrom(2);
	order.setOto(2);
	
	order.setCountp1(9);
	order.setCountp2(9);
	order.setCountp3(9);
	
	order.setP1price(9);
	order.setP2price(9);
	order.setP3price(9);
	
	System.out.println(order.getCountp1());

	orderService.saveOrder(order);
	}
	
	
}
