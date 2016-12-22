package org.yujifang.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.whieb.digitalhome.model.Connection;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.service.ConnectionService;

public class ConnectionTest {
	
  @Test
  public void connectionService(){
	  ApplicationContext  ctx = new ClassPathXmlApplicationContext("beans*.xml");
	  ConnectionService cs = (ConnectionService)ctx.getBean("connectionService");
	  System.out.println("!!!");
	  cs.run();
	  System.out.println("!!!");
  }
  
  @Test
  public void testPromote(){

	  ApplicationContext  ctx = new ClassPathXmlApplicationContext("beans*.xml");
	  ConnectionService cs = (ConnectionService)ctx.getBean("connectionService");
	  long userId = 1;
	  long itemId = 3;
	  List<Connection> con = cs.getConnection(userId, itemId);
	  List<Item> item = cs.getConnectionData(con);
	  System.out.println("总共推荐个数为："+item.size());
	  for(Item i:item){
		  System.out.println(i.getId().getId()+"   "+i.getTitle());
	  }
  }
  
  @Test
  public void fenye(){
	  ApplicationContext  ctx = new ClassPathXmlApplicationContext(new String[]{"beans_hq.xml", "beans_datasource.xml", "beans.xml" ,"beans_yjf.xml"});
	  ConnectionService cs = (ConnectionService)ctx.getBean("connectionService");
	  List<Item> item = cs.getItemDao().findItem(Item.class, 0, 10);
	  for(Item i:item)
		  System.out.println(i.getKey());
  }
  @Test
  public void createConnection(){
	  ApplicationContext  ctx = new ClassPathXmlApplicationContext("beans*.xml");
	  ConnectionService cs = (ConnectionService)ctx.getBean("connectionService");
	  cs.run();
  }
}
