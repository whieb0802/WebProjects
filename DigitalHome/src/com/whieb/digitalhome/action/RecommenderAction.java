package com.whieb.digitalhome.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.duineframework.recommender.core.RatableItemId;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.User;
import com.whieb.digitalhome.service.RecommenderService;
import com.whieb.digitalhome.vo.RecommenderExplainResult;

/**
 * @author Vicky 2012-8-11
 */
@Component("recommenderAction")
@Scope("prototype")
public class RecommenderAction extends BaseAction {

	private static final long serialVersionUID = 7947418953779433112L;
	private RecommenderService recommenderService;
	private Long itemId;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public RecommenderService getRecommenderService() {
		return recommenderService;
	}

	@Resource(name = "recommender.contentbased")
	public void setRecommenderService(RecommenderService recommenderService) {
		this.recommenderService = recommenderService;
	}

	/**
	 * 推荐二：热门资源推荐 zkz
	 * 
	 * @author Vicky 2012-8-11
	 */
	public String showHotItems() {
		List<Item> items = itemService.findHotItems(parameterService.getTopN());
		List<Integer> counts = itemService.findHotItemCount(parameterService.getTopN());
		request.put("items", items);
		request.put("counts", counts);
		return "showHotItems";
	}

	/**
	 * 推荐三：显示基于内容的推荐结果
	 */
	public String showContentBasedRecommenderItem() {
		User user = (User) session.get("user");
		List<RecommenderExplainResult> results = recommenderService
				.showContentBasedRecommenderResult(user.getId(),
						parameterService.getTopN());
		request.put("result", results);
		return "showContentBasedRecommenderItem";
	}

	public String showContentBasedRecommender() {
		List<Item> items = recommenderService.contentBasedRecommenderByItem(
				new RatableItemId(String.valueOf(itemId)), 10);
		if (null == items) {
			items = new ArrayList<Item>();
		}
		request.put("result", items);
		return "showContentBasedRecommender";
	}

	/**
	 * 推荐四：显示协同过滤基于item推荐结果
	 */
	public String showCollaborativeItemBasedRecommender() {
		User user = (User) session.get("user");
		List<RecommenderExplainResult> results = recommenderService
				.showCollaborativeItemBasedRecommenderResult(user.getId(),
						parameterService.getTopN());
		request.put("result", results);
		return "showCollaborativeItemBasedRecommender";
	}

	/**
	 * 推荐五：显示协同过滤基于user推荐结果
	 */
	public String showCollabaorativeUserBasedRecommender() {
		User user = (User) session.get("user");
		List<RecommenderExplainResult> results = recommenderService
				.showCollaborativeUserBasedRecommenderResult(user.getId(),
						parameterService.getTopN());
		request.put("result", results);
		return "showCollaborativeUserBasedRecommender";
	}
}
