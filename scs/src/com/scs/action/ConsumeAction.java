package com.scs.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scs.model.Consume;
import com.scs.model.Currentime;
import com.scs.model.Demand;
import com.scs.model.Message;
import com.scs.model.Product;
import com.scs.model.User;
import com.scs.service.ConsumeService;
import com.scs.service.CurrentimeService;
import com.scs.service.DemandService;
import com.scs.service.ProductService;
import com.scs.service.UserService;

public class ConsumeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String currentime;

	private DemandService ds;
	private CurrentimeService ct;
	private UserService us;
	private ProductService ps;
	private ConsumeService cs;

	Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
    Map<String,Object> session =	ActionContext.getContext().getSession();
	
	public ConsumeAction() {

	}

	public String demandSet() {
		return "demandSet";
	}

	public String receive() {
		
		Currentime currentime1 = ct.getCurrentime(Currentime.class,  Integer.parseInt(currentime));
		User user = (User) session.get("user");

		List<Consume> consumes = cs.findConsume(
				"from Consume c where c.user = ? and c.currentime = ?",
				new Object[] { user, currentime1 });
		if (consumes.size() != 0) {
			request.put("message", Message.msg23);
			return "exists";
		} else {
			List<Demand> demands = ds.findDemand("from Demand d where d.currentime = ? ",Integer.parseInt(currentime));
			Demand demand = demands.get(0);
			int min1 = demand.getP1mindemand();
			int max1 = demand.getP1maxdemand();
			int min2 = demand.getP2mindemand();
			int max2 = demand.getP2maxdemand();
			int min3 = demand.getP3mindemand();
			int max3 = demand.getP3maxdemand();
			int random1 = min1 + (int) (Math.random() * (max1 - min1));
			int random2 = min2 + (int) (Math.random() * (max2 - min2));
			int random3 = min3 + (int) (Math.random() * (max3 - min3));

			Consume consume = new Consume(currentime1, user, random1, random2,random3);
			cs.saveConsume(consume);
			request.put("consume", consume);
			return "success";
		}
	}

	public String receiveConfirm() {
		request.put("message", Message.msg24);
		return "confirm";
	}

	// index--> outcome.jsp
	public String outcome() {
		Currentime currentime1 = ct.getCurrentime(Currentime.class,  Integer.parseInt(currentime));
		User user = (User) session.get("user");

		Product product1 = ps.getProduct(Product.class, 3);
		Product product2 = ps.getProduct(Product.class, 6);
		Product product3 = ps.getProduct(Product.class, 9);

		int p1price = product1.getOutprice();
		int p2price = product2.getOutprice();
		int p3price = product3.getOutprice();

		List<Consume> consumes = cs.findConsume(
				"from Consume c where c.user= ? and c.currentime = ?",
				new Object[] { user, currentime1 });
		Consume consume = consumes.get(0);
		request.put("consume", consume);
		request.put("p1price", p1price);
		request.put("p2price", p2price);
		request.put("p3price", p3price);
		return "outcome";
	}

	public String getCurrentime() {
		return currentime;
	}

	public void setCurrentime(String currentime) {
		this.currentime = currentime;
	}

	
	public DemandService getDs() {
		return ds;
	}
    @Resource(name="demandService")
	public void setDs(DemandService ds) {
		this.ds = ds;
	}

	public CurrentimeService getCt() {
		return ct;
	}
    @Resource(name="currentimeService")
	public void setCt(CurrentimeService ct) {
		this.ct = ct;
	}

	public UserService getUs() {
		return us;
	}
    @Resource(name="userService")
	public void setUs(UserService us) {
		this.us = us;
	}

	public ProductService getPs() {
		return ps;
	}
    @Resource(name="productService")
	public void setPs(ProductService ps) {
		this.ps = ps;
	}

	public ConsumeService getCs() {
		return cs;
	}
    @Resource(name="consumeService")
	public void setCs(ConsumeService cs) {
		this.cs = cs;
	}

}
