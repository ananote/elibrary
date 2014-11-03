package com.impetus.elibrary.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.elibrary.model.Subscription;

@Service
public class SubscriptionDaoImpl  implements SubscriptionDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public int saveOrUpdate(Subscription subscription) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(subscription);
		tx.commit();
		Serializable id = session.getIdentifier(subscription);
		session.close();
		return (Integer) id;
	}

	@Override
	public List<Subscription> list() {
		
		
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Subscription> subscriptionList = session.createQuery("from Subscription").list();
		session.close();
		return subscriptionList;
	}

	@Override
	public List<Subscription> list(Subscription criteria) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Subscription> subscriptionList = session.createQuery("from Subscription").list();
		session.close();
		return subscriptionList;
	}

	@Override
	public Subscription getById(int id) {
		Session session = sessionFactory.openSession();
		Subscription subscription = (Subscription) session.load(Subscription.class, id);
		return subscription;
	}

	@Override
	public int delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Subscription subscription = (Subscription) session.load(Subscription.class, id);
		session.delete(subscription);
		tx.commit();
		Serializable ids = session.getIdentifier(subscription);
		session.close();
		return (Integer) ids;
	}

}
