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

	@Override
	public int save(Book book) {
		return bookDao.saveOrUpdate(book);
	}

	@Override
	public List<Book> list(int startIndex, int pageSize, String filterColumnName, 
			String filterColumnValue, Field sortColumn, boolean asc) {
		
		List<Book> bookList = bookDao.list(filterColumnName, filterColumnValue);
		
		if(! StringUtils.isEmpty(sortColumn)){
			bookList = ModelUtils.sortOn(bookList, sortColumn, asc);
		}
		
		return bookList;
	}

	@Override
	public List<Book> list(Book criteria) {
		return bookDao.list(criteria);
	}

	@Override
	public Book getById(int id) {
		return bookDao.getById(id);
	}

	@Override
	public int delete(int id) {
		return bookDao.delete(id);
	}
	
	@Override
	public List<String> getAllAuthors()
	{
	List<String> authorList = bookDao.getAllAuthors();
		/*
		if(! StringUtils.isEmpty(sortColumn)){
			bookList = ModelUtils.sortOn(bookList, sortColumn, asc);*/
	return authorList;
	}

}