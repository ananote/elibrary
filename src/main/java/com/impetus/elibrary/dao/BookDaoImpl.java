package com.impetus.elibrary.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.elibrary.model.Book;

@Service
public class BookDaoImpl  implements BookDao {

	@Autowired
	SessionFactory sessionFactory;

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

	public List<Book> list(Book criteria) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Book> bookList = session.createQuery("from Book").list();
		session.close();
		return bookList;
	}

	public Book getById(int id) {
		Session session = sessionFactory.openSession();
		Book book = (Book) session.load(Book.class, id);
		return book;
	}

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

}
