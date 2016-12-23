package service;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.service.ItemService;
import com.whieb.digitalhome.util.UtilDao;
import com.whieb.digitalhome.util.page.PageView;
import com.whieb.digitalhome.util.page.ResultType;

public class ItemServiceTest {

	private static ItemService is;
	private static UtilDao utilDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext(
					"beans*.xml");
			is = (ItemService) cxt.getBean("itemService");
			utilDao = (UtilDao) cxt.getBean("utilDao");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFindItem() {
		Item item = is.findItem(1);
		System.out.println(item.getInfo());
	}

	// 测试得到热门资源
	@Test
	public void testHotItems() {
		List<Long> keys = utilDao
				.findMaxResult(
						"select itemId from Trade t group by t.itemId order by count(*) desc",
						null, 10);
		List<Integer> values = utilDao
				.findMaxResult(
						"select count(*) from Trade t group by t.itemId order by count(*) desc",
						null, 10);
		for (int i = 0; i < keys.size(); i++) {
			System.out.print(keys.get(i));
			System.out.print("==========");
			System.out.println(values.get(i));
		}
	}

	// 测试得到用户历史消费Item
	@Test
	public void testFindHistory() {
		PageView<Item> pageView = is.findHistory((long) 1, 2);
		List<Item> items = pageView.getRecords();
		for (Item i : items) {
			System.out.println(i.getKey());
		}
	}

	@Test
	public void testListItems() {
		@SuppressWarnings("unused")
		String sqlString = "from Item i order by i.issuedate asc";
		// List<Item> items = is.findItem(, null);
		// List<Item> items = utilDao.findMaxResult(sqlString, null, 5);
		LinkedHashMap<String, String> order = new LinkedHashMap<String, String>();
		order.put("key", "ASC");
		ResultType<Item> resultType = utilDao.fenye(Item.class, 0, 20, order);
		PageView<Item> pageView = new PageView<Item>(PageView.MaxResutlt, 1);
		pageView.setResultType(resultType);
		List<Item> items = pageView.getRecords();
		for (Item i : items) {
			System.out.println(i.getKey());
		}
	}

}
