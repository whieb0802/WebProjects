package com.whieb.digitalhome.service.interest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserInterest {
	public static void main(String[] args) throws Exception {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {
				"beans_datasource.xml", "beans_user_interest.xml"});
		UserInterestReplay replayer = (UserInterestReplay) ctx.getBean("userinterestreplayer");
		replayer.replay("1");
	}
}
