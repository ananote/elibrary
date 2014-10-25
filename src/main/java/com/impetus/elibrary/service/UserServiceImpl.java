package com.impetus.elibrary.service;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.impetus.elibrary.dao.UserDao;
import com.impetus.elibrary.model.User;
import com.impetus.elibrary.utils.ModelUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public int save(User user) {
		return userDao.saveOrUpdate(user);
	}

	public List<User> list(int startIndex, int pageSize, Field sortColumn, boolean asc) {
		List<User> userList = userDao.list();
		
		if(! StringUtils.isEmpty(sortColumn)){
			userList = ModelUtils.sortOn(userList, sortColumn, asc);
		}
		
		return userList;
	}

	public List<User> list(User criteria) {
		return userDao.list(criteria);
	}

	public User getById(int id) {
		return userDao.getById(id);
	}

	public int delete(int id) {
		return userDao.delete(id);
	}

}