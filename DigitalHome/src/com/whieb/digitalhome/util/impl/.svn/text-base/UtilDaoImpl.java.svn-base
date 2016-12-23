package com.whieb.digitalhome.util.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.whieb.digitalhome.util.UtilDao;
import com.whieb.digitalhome.util.page.ResultType;

@Component("utilDao")
@Transactional
public class UtilDaoImpl extends HibernateDaoSupport implements UtilDao {

	@Resource(name = "recommender.sessionFactory")
	public void setHibernateSessionFatory(SessionFactory SessionFactory) {
		this.setSessionFactory(SessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	@Override
	public <T> List<T> find(String sql, Object[] o) {
		return (List<T>) this.getHibernateTemplate().find(sql, o);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(id);
	}

	public void delete(Object o) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(o);
	}

	public void delete(Object[] os) {
		// TODO Auto-generated method stub
		for (Object o : os) {
			this.getHibernateTemplate().delete(o);
		}
	}

	// 主键为int类型
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public <T> T find(Class<T> entityClass, Integer oId) {
		// TODO Auto-generated method stub
		return (T) this.getSession().get(entityClass, oId);

	}

	// 主键为long类型
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public <T> T find(Class<T> entityClass, long oId) {
		// TODO Auto-generated method stub
		return (T) this.getSession().get(entityClass, oId);

	}

	public void save(Object o) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(o);
	}

	@Override
	public void saveOrUpdate(Object o) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(o);
	}

	public void update(Object o) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().merge(o);
	}

	// 实现过滤条件后的排序分页
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	// o.x1=?1 and o.x2=?2.....
	public <T> ResultType<T> fenye(Class<T> entityClass, int firstIndex,
			int maxResult, String wherespql, Object[] queryParams,
			LinkedHashMap<String, String> orderBy) {
		ResultType rt = new ResultType<T>();

		String entityName = getEntityClass(entityClass);
		String orderby = createOrderBy(orderBy);

		Query query = this.getSession().createQuery(
				"select o from " + entityName + " o "
						+ (wherespql == null ? "" : "where " + wherespql)
						+ orderby);
		if (firstIndex != -1 && maxResult != -1)
			query.setFirstResult(firstIndex).setMaxResults(maxResult);
		setQueryParam(query, queryParams);
		rt.setResultList(query.list());

		query = this.getSession().createQuery(
				"select o from " + entityName + " o "
						+ (wherespql == null ? "" : "where " + wherespql)
						+ orderby);
		setQueryParam(query, queryParams);
		rt.setTotalRecord(query.list().size());

		return rt;
	}

	// 实现按顺序 分页查询
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public <T> ResultType<T> fenye(Class<T> entityClass, int firstIndex,
			int maxResult, LinkedHashMap<String, String> orderBy) {

		return fenye(entityClass, firstIndex, maxResult, null, null, orderBy);
	}

	// 简单分页查询
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public <T> ResultType<T> fenye(Class<T> entityClass, int firstIndex,
			int maxResult) {
		return fenye(entityClass, firstIndex, maxResult, null, null, null);
	}

	// 实现过滤条件分页
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public <T> ResultType<T> fenye(Class<T> entityClass, int firstIndex,
			int maxResult, String wherespql, Object[] queryParams) {
		return fenye(entityClass, firstIndex, maxResult, wherespql,
				queryParams, null);
	}

	// 获取全部实体
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public <T> ResultType<T> fenye(Class<T> entityClass) {
		return fenye(entityClass, -1, -1, null, null, null);
	}

	protected void setQueryParam(Query query, Object[] queryParams) {
		if (queryParams != null && queryParams.length > 0) {
			for (int i = 0; i < queryParams.length; i++) {
				query.setParameter(i, queryParams[i]);
			}
		}
	}

	// 反射获取实体类
	private <T> String getEntityClass(Class<T> entityClass) {
		String entityName = "";
		entityName = entityClass.getSimpleName();
		// Entity entity = entityClass.getAnnotation(Entity.class);
		// if (entity != null & !"".equals(entity.name())) {
		// entityName = entity.name();
		// }
		return entityName;
	}

	// 拼凑orderby语句
	// order by o.key desc,o.key2 AES
	protected String createOrderBy(LinkedHashMap<String, String> orderBy) {
		StringBuffer orderby = new StringBuffer("");
		if (orderBy != null && orderBy.size() > 0) {
			orderby.append(" order by ");
			for (String key : orderBy.keySet()) {
				orderby.append("o.").append(key).append(" ")
						.append(orderBy.get(key)).append(",");
			}
			orderby.deleteCharAt(orderby.length() - 1);
		}
		return orderby.toString();
	}

	@Override
	public Long sum(String sql, Object[] queryParams) {
		Query query = this.getSession().createQuery(sql);
		setQueryParam(query, queryParams);
		Long l = (Long) query.uniqueResult();
		return l == null ? 0l : l;
	}

	@Override
	public Long[] sums(String sql1, Object[] queryParams1, String sql2,
			Object[] queryParams2) {
		Long[] a = { sum(sql1, queryParams1), sum(sql2, queryParams2) };
		return a;
	}

	/**
	 * 查找唯一结果
	 * 
	 * @author Vicky
	 */
	public Object uniqueResult(String hql, Object[] paras) {
		Object result = null;
		Query query = this.getSession().createQuery(hql);
		if (paras != null && paras.length > 0) {
			for (int i = 0; i < paras.length; i++) {
				query.setParameter(i, paras[i]);
			}
		}
		result = query.uniqueResult();
		return result;
	}

	/**
	 * 执行Sql语句，如delete all等
	 * 
	 * @author Vicky
	 */
	public void execute(String sql) {
		getHibernateTemplate().bulkUpdate(sql);
	}

	/**
	 * 查找topN结果集
	 * 
	 * @author Vicky
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> findMaxResult(String hql, Object[] paras, int limits) {
		List<T> result = new ArrayList<T>();
		Query query = this.getSession().createQuery(hql);
		if (paras != null && paras.length > 0) {
			for (int i = 0; i < paras.length; i++) {
				query.setParameter(i, paras[i]);
			}
		}
		result = query.setMaxResults(limits).list();
		return result;
	}

	/**
	 * 保存全部
	 * 
	 * @author Vicky
	 */
	public <T> void saveOrUpdateAll(Collection<T> objs) {
		getHibernateTemplate().saveOrUpdateAll(objs);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> List<T> findByList(String hql, String para, List objs) {
		return getSession().createQuery(hql).setParameterList(para, objs)
				.list();
	}
}