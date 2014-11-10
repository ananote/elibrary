package com.impetus.elibrary.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.impetus.elibrary.model.BookRequest;

@Service
public class BookRequestDaoImpl  implements BookRequestDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public int saveOrUpdate(BookRequest bookRequest) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(bookRequest);
		tx.commit();
		Serializable id = session.getIdentifier(bookRequest);
		session.close();
		return (Integer) id;
	}

	@Override
	public List<BookRequest> list() {
		
		
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<BookRequest> bookRequestList = session.createQuery("from BookRequest where status not in ('Shelfed','UnShelfed') order by admin_response desc ,update_timestamp asc").list();
		session.close();
		return bookRequestList;
	}
	
	@Override
	public List<BookRequest> list(String filterColumnName, 
			String filterColumnValue) {
		
		Session session = sessionFactory.openSession();
		StringBuffer sbQuery = new StringBuffer();
		sbQuery.append("from BookRequest where status not in ('Shelfed','UnShelfed') ");
		if("*".equals(filterColumnValue)
				|| StringUtils.isEmpty(filterColumnName)
				|| StringUtils.isEmpty(filterColumnValue)){
		} else {
			sbQuery.append(" and ");
			sbQuery.append(filterColumnName);
			sbQuery.append(" like '%");
			sbQuery.append(filterColumnValue.trim());
			sbQuery.append("%'");
		}
		@SuppressWarnings("unchecked")
		List<BookRequest> bookRequestList = session.createQuery(sbQuery.toString()).list();
		
		session.close();
		return bookRequestList;
	}

	@Override
	public List<BookRequest> list(BookRequest criteria) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<BookRequest> bookRequestList = session.createQuery("from BookRequest where status !='UnShelfed'").list();
		session.close();
		return bookRequestList;
	}

	@Override
	public BookRequest getById(int id) {
		Session session = sessionFactory.openSession();
		BookRequest bookRequest = (BookRequest) session.load(BookRequest.class, id);
		return bookRequest;
	}

	@Override
	public int delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		BookRequest bookRequest = (BookRequest) session.load(BookRequest.class, id);
		session.delete(bookRequest);
		tx.commit();
		Serializable ids = session.getIdentifier(bookRequest);
		session.close();
		return (Integer) ids;
	}

}
