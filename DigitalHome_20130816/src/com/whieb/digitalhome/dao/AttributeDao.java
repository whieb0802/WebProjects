package com.whieb.digitalhome.dao;

import java.util.List;

import com.whieb.digitalhome.model.MyAttribute;

public interface AttributeDao {
	
	public List<MyAttribute> findAttribute(String sql, Object[] o);
}
