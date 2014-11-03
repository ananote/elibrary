package com.impetus.elibrary.service;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.impetus.elibrary.dao.BookRequestDao;
import com.impetus.elibrary.model.BookRequest;
import com.impetus.elibrary.utils.ModelUtils;

@Service
public class BookRequestServiceImpl implements BookRequestService {

	@Autowired
	BookRequestDao bookRequestDao;

	@Override
	public int save(BookRequest bookRequest) {
		return bookRequestDao.saveOrUpdate(bookRequest);
	}

	@Override
	public List<BookRequest> list(int startIndex, int pageSize, String filterColumnName, 
			String filterColumnValue, Field sortColumn, boolean asc) {
		List<BookRequest> bookRequestList = bookRequestDao.list(filterColumnName, filterColumnValue);
		
		if(! StringUtils.isEmpty(sortColumn)){
			bookRequestList = ModelUtils.sortOn(bookRequestList, sortColumn, asc);
		}
		
		return bookRequestList;
	}

	@Override
	public List<BookRequest> list(BookRequest criteria) {
		return bookRequestDao.list(criteria);
	}

	@Override
	public BookRequest getById(int id) {
		return bookRequestDao.getById(id);
	}

	@Override
	public int delete(int id) {
		return bookRequestDao.delete(id);
	}

}