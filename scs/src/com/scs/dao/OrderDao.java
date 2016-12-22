package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.scs.model.Currentime;
import com.scs.model.Order;

@Component("orderDao")
public class OrderDao extends BaseDao {
	
	public void getOrder(Order order) {
		getHibernateTemplate().findByExample(order);
       	
	}
	public void updateOrder(Order order) {
		getHibernateTemplate().update(order);
		
	}
	public void deleteOrder(Order order) {
		getHibernateTemplate().delete(order);
		
	}
	public void deleteAll(List<Order> order) {
		getHibernateTemplate().deleteAll(order);
		
	}
	public void saveOrder(Order order) {
		getHibernateTemplate().save(order);
	}
	public List<Order> findOrder(String order) {
		return getHibernateTemplate().find(order);
	}
	public Order getOrder(Class<Order> order,int id) {
		return (Order)getHibernateTemplate().get(order, id);
	}
	
	public List<Order> findOrder(String order,Object o) {
		return getHibernateTemplate().find(order, o);
	}
	public List<Order> findOrder(String order,Object[] objects) {
		return getHibernateTemplate().find(order,objects);
	}
	
	public boolean ifexists(int ofrom , int oto,Currentime currentime){
		List list = getHibernateTemplate().find("from Order o where o.ofrom = ? and o.oto = ?  and o.currentime = ?", new Object[]{ofrom,oto,currentime});
		if(list.size() != 0)
		   return true;
		else
		return false;
	}
	
}
