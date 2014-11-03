package com.impetus.elibrary.dao;

import java.util.List;

import com.impetus.elibrary.model.Book;
import com.impetus.elibrary.model.BookRequest;

public interface BookRequestDao {

	public int saveOrUpdate(BookRequest bookRequest);

	public List<BookRequest> list();
	
	public List<BookRequest> list(BookRequest criteria);
	
	public List<BookRequest> list(String filterColumnName, String filterColumnValue);

	public BookRequest getById(int id);

	public int delete(int id);

}