package com.scs.action;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scs.model.Currentime;
import com.scs.model.Demand;
import com.scs.model.Product;
import com.scs.model.User;
import com.scs.model.Message;
import com.scs.service.CurrentimeService;
import com.scs.service.DemandService;
import com.scs.service.ProductService;
import com.scs.service.UserService;

public class DemandTest {

	@Test
	public void testExecute() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DemandService demandService = (DemandService)ctx.getBean("demandService");
		CurrentimeService ct = (CurrentimeService)ctx.getBean("currentimeService");
		ProductService ps = (ProductService)ctx.getBean("productService");
		Currentime currentime = ct.getCurrentime(Currentime.class, 2);
		Product product = ps.getProduct(Product.class,1);
		List<Demand> demands = demandService.findDemand("from Demand d where d.currentime = ? and d.product = ?",new Object[]{currentime,product});
		Demand demand = demands.get(0);
		int min = demand.getP1mindemand();
		int max = demand.getP1maxdemand();
		int random =  max+ (int)Math.random()*(max-min); 
		System.out.println(random);
        System.out.println(Message.msg7);	
	}
	
	@Test
	public void testExecute2() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DemandService demandService = (DemandService)ctx.getBean("demandService");
		
		Demand demand = demandService.getDemand(Demand.class,1);
		int min = demand.getP1mindemand();
		int max = demand.getP1maxdemand();
		int random =  min+ (int)(Math.random()*(max-min)); 
		System.out.println(random);
	
	}
	
	@Test
	public void testExecute3() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)ctx.getBean("userService");
		
		User user= userService.getUser(User.class,15);
		
		System.out.println(user.getRealname());
	 System.out.println(("123").equals("123"));
	}

}
