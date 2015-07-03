package com.tq.util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;// 会话工厂
	static {
		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		// 创建会话工厂对象
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

	public static void add(Object entity) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void update(Object entity) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void delete(Object entity) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.delete(entity);
			transaction.commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static Object get(Class clazz, Serializable entity_id) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Object obj = session.get(clazz, entity_id);
			return obj;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
