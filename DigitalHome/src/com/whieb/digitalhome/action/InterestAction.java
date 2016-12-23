package com.whieb.digitalhome.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.MyAttribute;
import com.whieb.digitalhome.model.MyInterest;
import com.whieb.digitalhome.model.User;
import com.whieb.digitalhome.service.InterestService;
import com.whieb.digitalhome.service.ItemService;

@SuppressWarnings("serial")
@Component
public class InterestAction extends BaseAction {

	private InterestService interestService;
	private ItemService itemService;
	
	public String listAll() {
		User user = (User) session.get("user");	
		List<MyAttribute> attributes = interestService.findAttribute(user.getId());
		request.put("attributes", attributes);		
		Map<Integer,List> allinterest = new HashMap<Integer,List>();
		int i = 0;	
		for(MyAttribute ma : attributes) {
			List<MyInterest> interests = interestService.findInterest(Integer.parseInt(parameterService.getConfig().getValue("interest_num_limits")), user.getId(),ma.getType());
			allinterest.put(i,attributes);
			i++;
			allinterest.put(i, interests);
			i++;
			request.put("allinterest", allinterest);
		}
		return "userOwnInterest";	
	}
	
	public String interestRecommender() {
		User user = (User) session.get("user");
		MyAttribute attribute = interestService.findAttribute(user.getId()).get(0);
		MyInterest interest = interestService.findInterest(parameterService.getTopN(), user.getId(),attribute.getType()).get(0);
		List<Item> items = itemService.findInterestItem(parameterService.getTopN(),attribute.getType(),interest.getSubject());
		request.put("items", items);
		return "userInterestItem";
	}
	
	public InterestService getInterestService() {
		return interestService;
	}

	@Resource
	public void setInterestService(InterestService interestService) {
		this.interestService = interestService;
	}

	public ItemService getItemService() {
		return itemService;
	}
	@Resource
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	
}
