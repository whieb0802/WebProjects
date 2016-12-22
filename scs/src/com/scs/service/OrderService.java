package com.scs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.scs.dao.OrderDao;
import com.scs.model.Currentime;
import com.scs.model.Order;

@Component("orderService")
public class OrderService{
	private OrderDao orderDao;
	
	@Resource
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void getOrder(Order order) {
		orderDao.getOrder(order);
	}

	public void updateOrder(Order order) {
		orderDao.updateOrder(order);
	}

	public void deleteOrder(Order order) {
		orderDao.deleteOrder(order);
	}
	public void deleteAll(List<Order> order) {
		orderDao.deleteAll(order);
	}

	public void saveOrder(Order order) {
		orderDao.saveOrder(order);

	}
	public Order getOrder(Class<Order> order,int id) {
		return (Order)orderDao.getOrder(order,id);
	}
	
	public List<Order> findOrder(String order,Object o){
		return orderDao.findOrder(order,o);
	}
	
	public List<Order> findOrder(String order){
		return orderDao.findOrder(order);
	}
	public List<Order> findOrder(String order,Object[] objects){
		return orderDao.findOrder(order,objects);
	}
	public boolean ifexists(int ofrom , int oto,Currentime currentime){
		return orderDao.ifexists(ofrom, oto, currentime);
	}
}
