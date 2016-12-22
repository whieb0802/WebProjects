package com.scs.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.scs.model.Product;
import com.scs.model.Role;

@Component("productDao")
public class ProductDao extends BaseDao {
	
	public void getProduct(Product product) {
		getHibernateTemplate().findByExample(product);
       	
	}
	public void updateProduct(Product product) {
		getHibernateTemplate().update(product);
		
	}
	public void deleteProduct(Product product) {
		getHibernateTemplate().delete(product);
		
	}
	
	public void deleteAll(List<Product> product) {
		getHibernateTemplate().deleteAll(product);
		
	}
	public void saveProduct(Product product) {
		getHibernateTemplate().save(product);
	}

	public Product getProduct(Class<Product> product,int id) {
		return (Product)getHibernateTemplate().get(product, id);
	}
	
	public List<Product> findProduct(String product,Object o) {
		return getHibernateTemplate().find(product, o);
	}
	
	public List<Product> findProduct(String product) {
		return getHibernateTemplate().find(product);
	}
	
	public List<Product> findProduct(String product,Object[] objects) {
		return getHibernateTemplate().find(product,objects);
	}
}
