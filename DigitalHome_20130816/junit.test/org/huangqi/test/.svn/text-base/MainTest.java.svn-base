package org.huangqi.test;

import java.util.List;

import org.duineframework.recommender.core.UserId;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.whieb.digitalhome.main.MainJob;
import com.whieb.digitalhome.service.CollaborativeItemSimilarityService;
import com.whieb.digitalhome.service.CollaborativeUserSimilarityService;
import com.whieb.digitalhome.service.ContentBasedItemSimilarityService;
import com.whieb.digitalhome.service.DataTransfer;
import com.whieb.digitalhome.service.RecommenderService;
import com.whieb.digitalhome.vo.RecommenderExplainResult;

/**
 * 
 * @author Vicky 2012-8-11
 */
public class MainTest {

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

	/* 计算基于内容的Item相似度 */
	@Test
	public void testContentItemSimilarity() {
		ContentBasedItemSimilarityService service = (ContentBasedItemSimilarityService) context
				.getBean("contentBasedItemSimilarityService");
		service.mainCount();
	}

	/* 计算基于内容的Item相似度推荐结果 */
	@Test
	public void testContentBaesdRecommender() {
		RecommenderService recommender = (RecommenderService) context
				.getBean("recommender.contentbased");
		recommender.contentBasedRecommender();
	}

	/* 计算基于协同过滤的Item相似度 */
	@Test
	public void testCollaborativeItemSimiarity() {
		CollaborativeItemSimilarityService service = (CollaborativeItemSimilarityService) context
				.getBean("collaborativeItemSimilarityService");
		service.mainCount();
	}

	/* 计算基于协同过滤的Item相似度推荐结果 */
	@Test
	public void testCollaborativeItemBaesdRecommender() {
		RecommenderService recommender = (RecommenderService) context
				.getBean("recommender.contentbased");
		recommender.collaborativeItemBasedRecommender();
	}

	/* 计算基于协同过滤的User相似度 */
	@Test
	public void testCollaborativeUserSimilarity() {
		CollaborativeUserSimilarityService service = (CollaborativeUserSimilarityService) context
				.getBean("collaborativeUserSimilarityService");
		service.mainCount();
	}

	/* 计算基于协同过滤的User相似度推荐结果 */
	@Test
	public void testCollaborativeUserBasedRecommender() {
		RecommenderService recommender = (RecommenderService) context
				.getBean("recommender.contentbased");
		recommender.collaborativeUserBasedRecommender();
	}

	/* 显示User的推荐结果 */
	@Test
	public void testShowRecommenderResult() {
		RecommenderService recommender = (RecommenderService) context
				.getBean("recommender.contentbased");
		UserId uid = new UserId("1");
		System.out.println("User所有看过的电影...");
		List<RecommenderExplainResult> items01 = recommender
				.showContentBasedRecommenderResult(uid, 10);
		List<RecommenderExplainResult> items02 = recommender
				.showCollaborativeItemBasedRecommenderResult(uid, 10);
		List<RecommenderExplainResult> items03 = recommender
				.showCollaborativeUserBasedRecommenderResult(uid, 10);
		System.out.println("基于内容的Item相似度推荐结果...");
		if (items01 != null && items01.size() > 0) {
			for (RecommenderExplainResult i : items01) {
				System.out.println(i.getItem());
				System.out.println(i.getExplain());
			}
		}
		System.out.println("基于协同过滤的Item相似度推荐结果...");
		if (items02 != null && items02.size() > 0) {
			for (RecommenderExplainResult i : items02) {
				System.out.println(i.getItem());
				System.out.println(i.getExplain());
			}
		}
		System.out.println("基于协同过滤的User相似度推荐结果...");
		if (items03 != null && items03.size() > 0) {
			for (RecommenderExplainResult i : items03) {
				System.out.println(i.getItem());
				System.out.println(i.getExplain());
			}
		}
	}

	/**
	 * 测试核心工作类
	 */
	@Test
	public void testMainJob() {
		MainJob mainJob = (MainJob) context.getBean("mainJob");
		mainJob.start();
	}

	/**
	 * 测试数据转换
	 */
	@Test
	public void testDataTransfer() {
		DataTransfer transfer = (DataTransfer) context.getBean("dataTransfer");
		transfer.mainJob();
	}
}
