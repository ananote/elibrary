package com.impetus.elibrary.service;

import java.lang.reflect.Field;
import java.util.List;

import com.impetus.elibrary.model.Book;
import com.impetus.elibrary.model.BookRequest;

public interface BookRequestService {
	public int save(BookRequest bookRequest);

	public List<BookRequest> list(
			int startIndex, 
			int pageSize, 
			String filterColumnName, 
			String filterColumnValue,
			Field sortColumn,
			boolean asc);
	
	public List<BookRequest> list(BookRequest criteria);

	public BookRequest getById(int id);

	public int delete(int id);

}