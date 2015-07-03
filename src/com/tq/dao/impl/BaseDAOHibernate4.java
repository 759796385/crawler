package com.tq.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.tq.dao.BaseDAO;

public class BaseDAOHibernate4<T> implements BaseDAO<T> {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public T get(Class<T> entityClazz, Serializable id) {
		return (T) getSessionFactory().getCurrentSession().get(entityClazz, id);
	}

	@Override
	public Serializable save(T entity) {
		return getSessionFactory().getCurrentSession().save(entity);
	}

	@Override
	public void update(T entity) {
		getSessionFactory().getCurrentSession().update(entity);

	}

	@Override
	public void delete(T entity) {
		getSessionFactory().getCurrentSession().delete(entity);
	}

	/*
	 * ����idɾ��ʵ��
	 * 
	 * @see com.tq.dao.BaseDAO#delete(java.lang.Class, java.io.Serializable)
	 */
	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		String hql = "delete" + entityClazz.getSimpleName()
				+ " en where en.id=?0";
		getSessionFactory().getCurrentSession().createQuery(hql)
				.setParameter("0", id).executeUpdate();
	}

	/*
	 * ��ȡ����ʵ��
	 * 
	 * @see com.tq.dao.BaseDAO#findAll(java.lang.Class)
	 */
	@Override
	public List<T> findAll(Class<T> entityClazz) {
		return find("from" + entityClazz.getSimpleName());
	}

	/*
	 * ��ȡʵ������
	 * 
	 * @see com.tq.dao.BaseDAO#findCount(java.lang.Class)
	 */
	@Override
	public long findCount(Class<T> entityClazz) {
		List<?> l = find("select count(*) from" + entityClazz.getSimpleName());
		return (l != null && l.size() == 1) ? (long) l.get(0) : 0;
	}

	/**
	 * ����hql��ѯ
	 * 
	 * @param hql
	 * @return
	 */
	protected List<T> find(String hql) {
		return (List<T>) getSessionFactory().getCurrentSession()
				.createQuery(hql).list();
	}

	/**
	 * ������ռλ����hql
	 * 
	 * @param hql
	 * @param prarams
	 * @return
	 */
	protected List<T> find(String hql, Object... prarams) {
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for (int i = 0; i < prarams.length; i++) {
			query.setParameter(i + "", prarams[i]);
		}
		return (List<T>) query.list();
	}

	/**
	 * hql��ҳ����
	 * 
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @param prarams
	 * @return
	 */
	protected List<T> findByPage(String hql, int pageNo, int pageSize,
			Object... prarams) {
		Query query = null;
		try {
			query = getSessionFactory().getCurrentSession().createQuery(hql);

			if (prarams != null) {
				for (int i = 0; i < prarams.length; i++) {
					query.setParameter(i + "", prarams[i]);
				}
			}
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.list();
	}
}
