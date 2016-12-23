package com.whieb.digitalhome.util;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import com.whieb.digitalhome.util.page.ResultType;

public interface UtilDao {

	public void save(Object o);

	public void update(Object o);

	public void saveOrUpdate(Object o);

	public void delete(Integer id);

	public void delete(Object o);

	public void delete(Object[] os);

	public <T> T find(Class<T> o, Integer oId);

	public <T> T find(Class<T> o, long oId);

	public <T> List<T> find(String sql, Object[] o);

	// maxResult为每页显示多少行记录，first为从数据库的哪行开始读取数据
	// LinkedHashMap为有序的且可以存放多条记录 key为属性值 value为desc或AES
	public <T> ResultType<T> fenye(Class<T> entityClass, int firstIndex,
			int maxResult, String wherespql, Object[] queryParams,
			LinkedHashMap<String, String> orderBy);

	public <T> ResultType<T> fenye(Class<T> entityClass, int firstIndex,
			int maxResult, LinkedHashMap<String, String> orderBy);

	public <T> ResultType<T> fenye(Class<T> entityClass, int firstIndex,
			int maxResult);

	public <T> ResultType<T> fenye(Class<T> entityClass, int firstIndex,
			int maxResult, String wherespql, Object[] queryParams);

	public <T> ResultType<T> fenye(Class<T> entityClass);

	public Long sum(String sql, Object[] queryParams);

	public Long[] sums(String sql1, Object[] queryParams1, String sql2,
			Object[] queryParams2);

	/**
	 * @@author Vicky
	 */
	public Object uniqueResult(String hql, Object[] paras);// 查找唯一结果

	/**
	 * @@author Vicky
	 */
	public void execute(String sql);// 执行Sql语句，如delete all等

	/**
	 * 
	 * @author Vicky 2012-8-11
	 */
	public <T> List<T> findMaxResult(String hql, Object[] paras, int limits);// 查找topN结果集

	/**
	 * 
	 * @author Vicky 2012-8-11
	 */
	public <T> void saveOrUpdateAll(Collection<T> objs);// 保存全部

	@SuppressWarnings("rawtypes")
	public <T> List<T> findByList(String hql, String para, List objs);
}
