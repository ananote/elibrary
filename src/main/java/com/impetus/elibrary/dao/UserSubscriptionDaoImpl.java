package com.impetus.elibrary.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.elibrary.model.UserSubscription;

@Service
public class UserSubscriptionDaoImpl  implements UserSubscriptionDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public int saveOrUpdate(UserSubscription userSubscription) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(userSubscription);
		tx.commit();
		Serializable id = session.getIdentifier(userSubscription);
		session.close();
		return (Integer) id;
	}

	@Override
	public List<UserSubscription> list() {
		
		
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<UserSubscription> userSubscriptionList = session.createQuery("from UserSubscription").list();
		session.close();
		return userSubscriptionList;
	}

	@Override
	public List<UserSubscription> list(UserSubscription criteria) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UserSubscription");
		if(criteria.getUser() != null){
		    //query.setParameter("user_id", criteria.getUser().getUserId());
		}
		@SuppressWarnings("unchecked")
		List<UserSubscription> userSubscriptionList = query.list();
		session.close();
		return userSubscriptionList;
	}

	@Override
	public UserSubscription getById(int id) {
		Session session = sessionFactory.openSession();
		UserSubscription userSubscription = (UserSubscription) session.load(UserSubscription.class, id);
		return userSubscription;
	}

	@Override
	public int delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		UserSubscription userSubscription = (UserSubscription) session.load(UserSubscription.class, id);
		session.delete(userSubscription);
		tx.commit();
		Serializable ids = session.getIdentifier(userSubscription);
		session.close();
		return (Integer) ids;
	}

}
