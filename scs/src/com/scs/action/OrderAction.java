package com.scs.action;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.scs.model.Bill;
import com.scs.model.Currentime;
import com.scs.model.Message;
import com.scs.model.Order;
import com.scs.model.Relation;
import com.scs.model.User;
import com.scs.service.BillService;
import com.scs.service.CurrentimeService;
import com.scs.service.OrderService;
import com.scs.service.RoleService;

public class OrderAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private Order order;
	private int current;
	Map<String, Object> request;
	
	private OrderService orderService;
	

	private CurrentimeService currentimeService;
	private RoleService roleService;
	private BillService billService;
	
	public OrderAction(){
		
	}
	

	public String newOrder(){
		 Currentime currenTime = currentimeService.getCurrentime(Currentime.class, current);
		
		 if(current == 0||order.getCountp1()==null||order.getCountp2()==null||order.getCountp3()==null||order.getOfrom()==null||
				order.getOto()==null||order.getP1price()==null||order.getP2price()==null||
				order.getP3price()==null){
			ActionContext.getContext().put("message",Message.msg12);
			return "error";
			}
		 
		else if(orderService.ifexists(order.getOfrom(), order.getOto(), currenTime)){
			ActionContext.getContext().put("message",Message.msg15);
			return "exists";
		    }
		else{
			order.setCurrentime(currenTime);
			order.setOfrom(order.getOfrom());
			order.setOto(order.getOto());
			order.setCountp1(order.getCountp1());
			order.setCountp2(order.getCountp2());
			order.setCountp3(order.getCountp3());
			order.setP1price(order.getP1price());
			order.setP2price(order.getP2price());
			order.setP3price(order.getP3price());
			order.setIscomplete(0);
			
			orderService.saveOrder(order);
			ActionContext.getContext().put("message",Message.msg11);
			
		    return "neworder";
		}
	} 
	

	
	//订单量有欠货量+发货量 即可求出来 order量
	public String selectOrder(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		Relation relation = (Relation)ActionContext.getContext().getSession().get("relation");
			//取得发货时间，找到到货bills
			List<Bill> bills = billService.findBill("from Bill b where b.bfrom = ? and b.bto = ? ", new Object[]{relation.getUpstream(),user.getUserid()});
			List<Order> orders = orderService.findOrder("from Order o where o.ofrom = ? and o.oto = ? ", new Object[]{user.getUserid(),relation.getUpstream()});
			request = (Map<String, Object>) ActionContext.getContext().get("request");
			request.put("bills", bills);
			request.put("orders", orders);
			return "select";
		}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}


	
	public OrderService getOrderService() {
		return orderService;
	}
    @Resource
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
    
	public CurrentimeService getCurrentimeService() {
		return currentimeService;
	}
    @Resource
	public void setCurrentimeService(CurrentimeService currentimeService) {
		this.currentimeService = currentimeService;
	}
    
	public RoleService getRoleService() {
		return roleService;
	}
    @Resource
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
    
	public BillService getBillService() {
		return billService;
	}
    @Resource
	public void setBillService(BillService billService) {
		this.billService = billService;
	}


}
