package com.impetus.elibrary.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.impetus.elibrary.model.Book;
import com.impetus.elibrary.model.User;

@Service
public class UserDaoImpl  implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public int saveOrUpdate(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		Serializable id = session.getIdentifier(user);
		session.close();
		return (Integer) id;
	}

	@Override
	public List<User> list() {
		
		
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<User> userList = session.createQuery("from User").list();
		session.close();
		return userList;
	}

	@Override
	public List<User> list(User criteria) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<User> userList = session.createQuery("from User").list();
		session.close();
		return userList;
	}
 
	@Override
	public List<User> list(String filterColumnName, 
			String filterColumnValue) {
		
		Session session = sessionFactory.openSession();
		StringBuffer sbQuery = new StringBuffer();
		sbQuery.append("from User");
		if("*".equals(filterColumnValue)
				|| StringUtils.isEmpty(filterColumnName)
				|| StringUtils.isEmpty(filterColumnValue)){
		} else {
			sbQuery.append(" where ");
			sbQuery.append(filterColumnName);
			sbQuery.append(" like '%");
			sbQuery.append(filterColumnValue.trim());
			sbQuery.append("%'");
		}
		@SuppressWarnings("unchecked")
		List<User> userList = session.createQuery(sbQuery.toString()).list();
		session.close();
		return userList;
	}
	
	@Override
	public User getById(int id) {
		Session session = sessionFactory.openSession();
		User user = (User) session.load(User.class, id);
		return user;
	}

	@Override
	public int delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = (User) session.load(User.class, id);
		session.delete(user);
		tx.commit();
		Serializable ids = session.getIdentifier(user);
		session.close();
		return (Integer) ids;
	}
	
	@Override
	public User getUserByUsername(String username) {
		Session session = sessionFactory.openSession();
		 Transaction tx = null;
		 User user = null;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from User where username='"+username+"'");
			 user = (User)query.uniqueResult();
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }
		 return user;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getListOfUsers() {
		List<User> list = new ArrayList<User>();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			list = session.createQuery("from User").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

}
