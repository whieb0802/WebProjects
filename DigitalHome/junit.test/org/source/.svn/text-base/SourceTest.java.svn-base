package org.source;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.whieb.digitalhome.service.SourceItemService;
import com.whieb.digitalhome.util.SourceService;

public class SourceTest {
	public static ClassPathXmlApplicationContext context = null;

	@BeforeClass
	public static void before() {
		context = new ClassPathXmlApplicationContext(
				new String[] { "beans_hq.xml", "beans_datasource.xml",
						"beans_user_interest.xml", "beans_yjf.xml",
						"beans_source.xml" ,"beans_source_item.xml"});
	}

	@AfterClass
	public static void after() {
		context.close();
		context = null;
	}
//	加载消费信息，加载vod表，保存到数据库source_table
	@Test
	public void test01() {
		SourceService ss = (SourceService) context.getBean("sourceService");
		ss.loadData();
	}
	
	@Test
	public void test02() {
		SourceService ss = (SourceService) context.getBean("sourceService");
		ss.validate();
	}

	@Test
	public void test03() {
		SourceItemService sis =(SourceItemService) context.getBean("sourceItemService");
		sis.validate();
	}
}
