package service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.duineframework.recommender.profile.rating.Rating;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ognl.accessor.ObjectAccessor;
import com.whieb.digitalhome.model.IRating;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.Trade;
import com.whieb.digitalhome.model.User;
import com.whieb.digitalhome.service.ItemService;
import com.whieb.digitalhome.service.RatingService;
import com.whieb.digitalhome.service.UserService;
import com.whieb.digitalhome.util.UtilDao;

public class CreateDataset {

	private static UserService us;
	private static ItemService is;
	private static RatingService rs;
	private static UtilDao utilDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext(
					"beans*.xml");
			us = (UserService) cxt.getBean("userService");
			is = (ItemService) cxt.getBean("itemService");
			rs = (RatingService) cxt.getBean("ratingService");
			utilDao = (UtilDao) cxt.getBean("utilDao");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void CreateUsers() {
		for (int i = 1; i <= 100; i++) {
			User user = new User();
			user.setKey((long) i);
			user.setName("test" + i);
			user.setPassword("test" + i);
			us.addUser(user);
			System.out.println("生成用户" + user.getKey() + "成功！");
		}
	}

	@Test
	public void CreateTrade() {
		List<Item> items1 = is.findItem("from Item", null);
		List<User> users = us.findUser("from User", null);
		for (int i = 0; i < 100; i++) {
			User user = users.get(i);
			Collections.shuffle(items1);
			for (int j = 0; j < 15; j++) {
				Trade trade = new Trade(user.getUserId(), items1.get(j)
						.getKey(), new Date(), 5.0);
				utilDao.save(trade);
			}
			Collections.shuffle(items1);
			for (int j = 0; j < 20; j++) {
				Trade trade = new Trade(user.getUserId(), items1.get(j)
						.getKey(), new Date(), 5.0);
				utilDao.save(trade);
			}
			System.out.println("生成User" + user.getKey() + "的消费数据成功！");
		}
	}

	@Test
	public void CreateTradeForConnection() {
		List<Item> items1 = findItems("科幻灾难");
		List<Item> items2 = findItems("科幻灾难");
		List<User> users = us.findUser("from User", null);
		for (int i = 0; i < 100; i++) {
			User user = users.get(i);
			Collections.shuffle(items1);
			Collections.shuffle(items2);
			for (int j = 0; j < 15; j++) {
				Trade trade = new Trade(user.getUserId(), items1.get(j)
						.getKey(), new Date(), 5.0);
				utilDao.save(trade);
			}
			for (int j = 0; j < 20; j++) {
				Trade trade = new Trade(user.getUserId(), items2.get(j)
						.getKey(), new Date(), 5.0);
				utilDao.save(trade);
			}
			System.out.println("生成User" + user.getKey() + "的消费数据成功！");
		}
	}

	@Test
	public void CreateRatings() {
		List<User> users = us.findUser("from User", null);
		List<Item> items1 = is.findItem("from Item", null);
		int[] arr = { 3, 4, 5 };
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			Collections.shuffle(items1);
			for (int j = 0; j < 10; j++) {
				int rating0 = Math.abs((int) (Math.random() * 10) - 5);// 随机取0-5
				int index = (int) (Math.random() * arr.length);
				int rating1 = arr[index];
				IRating rating = new IRating(user.getId(), items1.get(j).getId(), (double)rating1,
						1,new Date());
				rs.saveRating(rating);
			}
		}

	}

	@Test
	public void addRating() {
		User user = us.findUser(1);
		Item item = is.findItem(1);
//		rs.addRating(user, item, 0.55, 1);
		System.out.println(rs.getRating(user, item).getValue());
	}

	public List<Item> findItems(String type) {
		// String type1 = "科幻灾难";
		// String type2 = "警匪动作";
		// String type3 = "喜剧幽默";
		// String type4 = "动漫电影";
		// String type5 = "恐怖悬疑";
		// String type6 = "经典纪实";
		// String type7 = "战争史诗";
		// String type8 = "文艺情感";
		return is.findItem("from Item i where i.type=?", new Object[] { type });
	}

}
