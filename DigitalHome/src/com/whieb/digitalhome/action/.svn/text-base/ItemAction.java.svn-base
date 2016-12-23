package com.whieb.digitalhome.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.whieb.digitalhome.model.Item;
import com.whieb.digitalhome.model.User;
import com.whieb.digitalhome.util.page.PageView;



@Component("itemAction")
@Scope("prototype")
public class ItemAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private Integer page;

	
	/**
	 * 用户登录
	 * 1.判断用户名是否存在 不存在返回0
	 * 2.判断用户状态是否有值 无值返回1
	 * 3.判断用户密码是否正确 不正确返回2
	 * 登录成功  如果是生产商返回3    代理商返回4   零售商返回5
	 */
	public String getNewItems(){
		return null;
	}
	
	/**
	 *  查找所有Item
	 */
	public String listAll(){
		if (page == null) {page = 1;}
		PageView<Item> pageView = itemService.listItem(page);
		request.put("pageView", pageView);
		return "list";
	}

	/**
	 * 推荐一：最新资源推荐
	 * zkz
	 * @return
	 */
	public String recommendNew(){
		if (page == null) {
			page=1;
		}
		List<Item> items = itemService.findNewItems(parameterService.getTopN());
		request.put("items", items);
//		分页显示
//		LinkedHashMap<String, String> order = new LinkedHashMap<String, String>();
//		order.put("issuedate", "DESC");
//		ResultType<Item> resultType = utilDao.fenye(Item.class, page, parameter.getParamTopN(), order);
//		PageView<Item> pageView = new PageView<Item>(PageView.MaxResutlt, page);
//		pageView.setResultType(resultType);
//		request.put("pageView", pageView);
		return "recommend_new";
	}
	/**
	 * 显示历史消费信息
	 * zkz
	 * @return
	 */
	public String showHistory(){
		User user = (User) session.get("user");
		if (page == null) {
			page=1;
		}
		PageView<Item> pageView = itemService.findHistory(user.getKey(), page);
		request.put("pageView", pageView);
		return "showHistory";
	}
	
	/**
	 * 显示历史评分信息
	 * zkz
	 * @return
	 */
	public String showRating(){
		User user = (User) session.get("user");
		if (page == null) {
			page=1;
		}
		PageView<Item> pageView = itemService.findHistory(user.getKey(), page);
		request.put("pageView", pageView);
		return "showHistory";
	}
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
	

}
