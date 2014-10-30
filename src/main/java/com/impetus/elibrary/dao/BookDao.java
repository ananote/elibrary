package com.impetus.elibrary.dao;

import java.util.List;

import com.impetus.elibrary.model.Book;

public interface BookDao {

	public int saveOrUpdate(Book book);

	public List<Book> list();
	
	public List<Book> list(Book criteria);
	
	public List<Book> list(String filterColumnName, String filterColumnValue);

	public Book getById(int id);

	public int delete(int id);
	
	public List<String> getAllAuthors();

}