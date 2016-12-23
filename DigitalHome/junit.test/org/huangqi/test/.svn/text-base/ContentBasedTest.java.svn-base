package org.huangqi.test;

import java.util.List;

import org.duineframework.recommender.core.RatableItemId;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.whieb.digitalhome.dao.ItemDao;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.service.similarity.item.ItemSimilarityCounter;
import com.whieb.digitalhome.service.similarity.item.collaborative.CollaborativeItemSimilarityCounter;
import com.whieb.digitalhome.service.similarity.item.contentbased.TFIDFCounter;

/**
 * @author Vicky 2012-8-16
 */
public class ContentBasedTest {
	public static ClassPathXmlApplicationContext context = null;

	@BeforeClass
	public static void before() {
		context = new ClassPathXmlApplicationContext(new String[] {
				"beans_hq.xml", "beans_datasource.xml",
				"beans_user_interest.xml", "beans_yjf.xml" });
	}

	@AfterClass
	public static void after() {
		context.close();
		context = null;
	}

	@Test
	public void testContentBasedItemSimilairty() {
		ItemDao itemDao = (ItemDao) context.getBean("itemDao");
		List<Item> items = itemDao.findItem("from Item", null);
		TFIDFCounter tfidf = new TFIDFCounter(items);
		ItemSimilarityCounter sim_counter = (ItemSimilarityCounter) context
				.getBean("itemSimilarityCounter");
		for (int i = 0; i < 10; i++) {
			for (int j = i + 1; j < 10; j++) {
				System.out.print(items.get(i) + "\n" + items.get(j) + "\n");
				double sim = sim_counter.getContentSimilarity(items.get(i),
						items.get(j), tfidf);
				System.out.println(sim);
			}
		}
	}

	@Test
	public void test01() {
		CollaborativeItemSimilarityCounter counter = (CollaborativeItemSimilarityCounter) context
				.getBean("collaborativeItemSimilarityCounter");
		Item item01 = new Item(new RatableItemId("154"));
		Item item02 = new Item(new RatableItemId("2"));
		counter.getSimilarity(item01, item02);
	}
}
