package com.whieb.digitalhome.dao;

import java.util.Collection;
import java.util.List;

import com.whieb.digitalhome.model.Source;

public interface SourceDao {
	
	public void saveOrUpdateAll(Collection<Source> sou);

	public void clear();
	
	public List<Source> listAllSource();
	
}
