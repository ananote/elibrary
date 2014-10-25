package com.impetus.elibrary.service;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.impetus.elibrary.dao.BookDao;
import com.impetus.elibrary.model.Book;
import com.impetus.elibrary.utils.ModelUtils;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;

	public int save(Book book) {
		return bookDao.saveOrUpdate(book);
	}

	public List<Book> list(int startIndex, int pageSize, Field sortColumn, boolean asc) {
		List<Book> bookList = bookDao.list();
		
		if(! StringUtils.isEmpty(sortColumn)){
			bookList = ModelUtils.sortOn(bookList, sortColumn, asc);
		}
		
		return bookList;
	}

	public List<Book> list(Book criteria) {
		return bookDao.list(criteria);
	}

	public Book getById(int id) {
		return bookDao.getById(id);
	}

	public int delete(int id) {
		return bookDao.delete(id);
	}

}