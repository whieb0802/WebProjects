package org.chengzhihuan.test;

import java.util.List;

import org.duineframework.recommender.core.DuineException;
import org.duineframework.recommender.core.UserId;
import org.duineframework.recommender.dao.springhibernate.SpringHibernateInterestModelDAO;
import org.duineframework.recommender.profile.interest.Interest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.whieb.digitalhome.dao.InterestDao;
import com.whieb.digitalhome.service.RatingService;
import com.whieb.digitalhome.service.interest.UserInterestReplay;

public class DaoTest {

	@BeforeClass
	public static void beforeClass() throws Exception {
		System.out.println("before....");
	}

	@AfterClass
	public static void after() {
		System.out.println("after....");
	}

	@Test
	public void test01() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "beans_datasource.xml",
						"beans_user_interest.xml" });
		SpringHibernateInterestModelDAO dao = (SpringHibernateInterestModelDAO) ctx
				.getBean("interestModelDAO");
		String modelId = "com.whieb.digitalhome.interest.user.userInterestModel";
		UserId user = new UserId("1");
		List<Interest> interests = (List<Interest>) dao.getInterests(modelId,
				user);
		System.out.println(interests.get(0));
	}

	/*@Test
	public void test02() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "beans_datasource.xml",
						"beans_user_interest.xml" });
		InterestService is = (InterestService) ctx
				.getBean("userinterestrecommend");
		UserId u = new UserId("1");
		User user = new User(u);
		int i = 3;
		int j = 2;
		is.replay(i, j, 5, user.getId());
	}

	@Test
	public void test03() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "beans_datasource.xml",
						"beans_user_interest.xml" });
		InterestService is = (InterestService) ctx
				.getBean("userinterestrecommend");
		UserId u = new UserId("1");
		User user = new User(u);
		List<Item> items = is.replay(3, 2, 5, user.getId());
		for (Item i : items) {
			System.out.println(i.getTitle());
		}
		System.out.println(2);
	}*/
	@Test
	public void test05() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "beans_datasource.xml",
						"beans_user_interest.xml","beans*.xml" });
		UserInterestReplay ureplay = (UserInterestReplay)ctx.getBean("userinterestreplayer");
		InterestDao interestDao = (InterestDao) ctx.getBean("interestDao");
		RatingService ratingService = (RatingService) ctx.getBean("ratingService");
		
		try {
			interestDao.clear();
			List<UserId> users = ratingService.getDistinctUserId();
			for(UserId userId : users) {
				ureplay.replay(userId+"");
				System.out.println("正在执行*******"+userId);
			}
		} catch (DuineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
