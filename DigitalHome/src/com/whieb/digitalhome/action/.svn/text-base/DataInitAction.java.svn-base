package com.whieb.digitalhome.action;

import java.util.List;

import javax.annotation.Resource;

import org.duineframework.recommender.core.DuineException;
import org.duineframework.recommender.core.UserId;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.whieb.digitalhome.dao.UserDao;
import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.MyAttribute;
import com.whieb.digitalhome.model.MyInterest;
import com.whieb.digitalhome.model.User;
import com.whieb.digitalhome.service.ConnectionService;
import com.whieb.digitalhome.service.InterestService;
import com.whieb.digitalhome.service.ItemService;
import com.whieb.digitalhome.service.ParameterService;
import com.whieb.digitalhome.service.RatingService;
import com.whieb.digitalhome.service.RecommenderService;
import com.whieb.digitalhome.service.SimilarityService;
import com.whieb.digitalhome.service.interest.UserInterestReplay;

@Component("dataInitAction")
@Scope("prototype")
public class DataInitAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private ConnectionService cs;
	private SimilarityService ss;
	private UserInterestReplay userInterestReplay ;
	private RatingService ratingService;
	private RecommenderService recommenderService;
	private InterestService interestService;
	private ParameterService parameterService;
	private ItemService itemService;
	
	public ConnectionService getCs() {
		return cs;
	}

	@Resource(name = "connectionService")
	public void setCs(ConnectionService cs) {
		this.cs = cs;
	}
	
	
	
	public SimilarityService getSs() {
		return ss;
	}
	@Resource(name = "similarityEngine")
	public void setSs(SimilarityService ss) {
		this.ss = ss;
	}

	public UserInterestReplay getUserInterestReplay() {
		return userInterestReplay;
	}
	@Resource(name = "userinterestreplayer")
	public void setUserInterestReplay(UserInterestReplay userInterestReplay) {
		this.userInterestReplay = userInterestReplay;
	}
	
	
	
	public RatingService getRatingService() {
		return ratingService;
	}
	@Resource(name="ratingService")
	public void setRatingService(RatingService ratingService) {
		this.ratingService = ratingService;
	}

	
	
	public RecommenderService getRecommenderService() {
		return recommenderService;
	}
	@Resource(name="recommender.contentbased")
	public void setRecommenderService(RecommenderService recommenderService) {
		this.recommenderService = recommenderService;
	}

	
	
	public InterestService getInterestService() {
		return interestService;
	}
	@Resource(name="userinterestrecommend")
	public void setInterestService(InterestService interestService) {
		this.interestService = interestService;
	}

	
	public ParameterService getParameterService() {
		return parameterService;
	}
	@Resource(name="parameterService")
	public void setParameterService(ParameterService parameterService) {
		this.parameterService = parameterService;
	}

	public ItemService getItemService() {
		return itemService;
	}
	@Resource(name="itemService")
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public String execute(){
		return "success";
	}
	//更新关联规则数据
	public String run01(){
//		boolean flag = true;
		cs.run();
		return "success01";
	}
	//更新内容数据
	public String run02(){
		ss.mainCount();
		return "success02";
	}
	//更新兴趣模型数据
	public String run03() throws DuineException{
		List<UserId> users = ratingService.getDistinctUserId();
		for(UserId userId : users) {
			userInterestReplay.replay(userId+"");
			System.out.println("正在执行*******"+userId);
			MyAttribute attribute = interestService.findAttribute(userId).get(0);
			MyInterest interest = interestService.findInterest(parameterService.getTopN(), userId,attribute.getType()).get(0);
			List<Item> items = itemService.findInterestItem(parameterService.getTopN(),attribute.getType(),interest.getSubject());
			recommenderService.saveInterestRecommenderResult(userId, items);
		}
		
		return "success03";
	}
}
