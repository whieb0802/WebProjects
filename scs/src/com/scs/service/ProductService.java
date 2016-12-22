package com.scs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.scs.dao.ProductDao;
import com.scs.model.Product;

@Component("productService")
public class ProductService{

	private ProductDao productDao;

	@Resource
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void getProduct(Product product) {
		productDao.getProduct(product);
	}

	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
	}
	
	public void deleteAll(List<Product> product) {
		productDao.deleteAll(product);
	}

	public void saveProduct(Product product) {
		productDao.saveProduct(product);

	}
	public Product getProduct(Class<Product> product,int id) {
		return (Product)productDao.getProduct(product,id);
	}
	
	public List<Product> findProduct(String product,Object o){
		return productDao.findProduct(product,o);
	}
	
	public List<Product> findProduct(String product){
		return productDao.findProduct(product);
	}
	
	public List<Product> findProduct(String product,Object[] objects){
		return productDao.findProduct(product,objects);
	}
}
