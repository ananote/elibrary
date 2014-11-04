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
import org.springframework.util.StringUtils;

import com.impetus.elibrary.model.Book;

@Service
public class BookDaoImpl  implements BookDao {

	@Autowired
	SessionFactory sessionFactory;
    
	@Override
	@Transactional
	public int saveOrUpdate(Book book) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(book);
		tx.commit();
		Serializable id = session.getIdentifier(book);
		session.close();
		return (Integer) id;
	}

	@Override
	public List<Book> list() {
		
		
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Book> bookList = session.createQuery("from Book").list();
		session.close();
		return bookList;
	}
	
	@Override
	public List<Book> list(String filterColumnName, 
			String filterColumnValue) {
		
		Session session = sessionFactory.openSession();
		StringBuffer sbQuery = new StringBuffer();
		sbQuery.append("from Book");
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
		List<Book> bookList = session.createQuery(sbQuery.toString()).list();
		session.close();
		return bookList;
	}

	@Override
	public List<Book> list(Book criteria) {
		Session session = sessionFactory.openSession();
		
		String queryStr="from Book where 1=1 ";
		if (StringUtils.hasText(criteria.getCategory())){
			queryStr=queryStr+" and lcase(category)=lcase('"+criteria.getCategory()+"') ";
		}
		if (StringUtils.hasText(criteria.getAuthor())){
			queryStr=queryStr+" and lcase(author) like lcase('%"+criteria.getAuthor()+"%') ";
		}
		if (StringUtils.hasText(criteria.getName())){
			queryStr=queryStr+" and lcase(name)like lcase('%"+criteria.getName()+"%') ";
		}
		
		Query query = session.createQuery(queryStr);
		@SuppressWarnings("unchecked")
		List<Book> bookList = query.list();
		session.close();
		return bookList;
	}

	@Override
	public Book getById(int id) {
		Session session = sessionFactory.openSession();
		Book book = (Book) session.load(Book.class, id);
		session.close();
		return book;
	}

	@Override
	public int delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Book book = (Book) session.load(Book.class, id);
		session.delete(book);
		tx.commit();
		Serializable ids = session.getIdentifier(book);
		session.close();
		return (Integer) ids;
	}
	
	@Override
	public List<String> getAllAuthors(){
		Session session = sessionFactory.openSession();
		String queryStr="select distinct author from Book where (author is not null and author!='') order by author";
		Query query = session.createQuery(queryStr);
		@SuppressWarnings("unchecked")
		List<String> authorList = query.list();
		session.close();
		return authorList;
	}

}
