package com.impetus.elibrary.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.elibrary.model.UserEmail;

@Service
public class UserEmailDaoImpl  implements UserEmailDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public int saveOrUpdate(UserEmail userEmail) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(userEmail);
		tx.commit();
		Serializable id = session.getIdentifier(userEmail);
		session.close();
		return (Integer) id;
	}

	@Override
	public List<UserEmail> list() {
		
		
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<UserEmail> userEmailList = session.createQuery("from UserEmail").list();
		session.close();
		return userEmailList;
	}

	@Override
	public List<UserEmail> list(UserEmail criteria) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<UserEmail> userEmailList = session.createQuery("from UserEmail").list();
		session.close();
		return userEmailList;
	}

	@Override
	public UserEmail getById(int id) {
		Session session = sessionFactory.openSession();
		UserEmail userEmail = (UserEmail) session.load(UserEmail.class, id);
		return userEmail;
	}

	@Override
	public int delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		UserEmail userEmail = (UserEmail) session.load(UserEmail.class, id);
		session.delete(userEmail);
		tx.commit();
		Serializable ids = session.getIdentifier(userEmail);
		session.close();
		return (Integer) ids;
	}

}
