package com.impetus.elibrary.service;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.impetus.elibrary.dao.UserEmailDao;
import com.impetus.elibrary.model.UserEmail;
import com.impetus.elibrary.utils.ModelUtils;

@Service
public class UserEmailServiceImpl implements UserEmailService {

	@Autowired
	UserEmailDao userEmailDao;

	@Override
	public int save(UserEmail userEmail) {
		return userEmailDao.saveOrUpdate(userEmail);
	}

	@Override
	public List<UserEmail> list(int startIndex, int pageSize, Field sortColumn, boolean asc) {
		List<UserEmail> userEmailList = userEmailDao.list();
		
		if(! StringUtils.isEmpty(sortColumn)){
			userEmailList = ModelUtils.sortOn(userEmailList, sortColumn, asc);
		}
		
		return userEmailList;
	}

	@Override
	public List<UserEmail> list(UserEmail criteria) {
		return userEmailDao.list(criteria);
	}

	@Override
	public UserEmail getById(int id) {
		return userEmailDao.getById(id);
	}

	@Override
	public int delete(int id) {
		return userEmailDao.delete(id);
	}

}