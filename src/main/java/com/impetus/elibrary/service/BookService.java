package com.impetus.elibrary.service;

import java.lang.reflect.Field;
import java.util.List;

import com.impetus.elibrary.model.Book;

public interface BookService {
	public int save(Book book);

	public List<Book> list(
			int startIndex, 
			int pageSize, 
			String filterColumnName, 
			String filterColumnValue,
			Field sortColumn,
			boolean asc);
	
	public List<Book> list(Book criteria);

	public Book getById(int id);

	public int delete(int id);
	
	public List<String> getAllAuthors();

}