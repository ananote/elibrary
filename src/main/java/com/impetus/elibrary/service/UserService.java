package com.impetus.elibrary.service;

import java.lang.reflect.Field;
import java.util.List;

import com.impetus.elibrary.model.User;

public interface UserService {
	public int save(User user);

	public List<User> list(int startIndex, int pageSize, Field sortColumn, boolean asc);
	
	public List<User> list(User criteria);

	public User getById(int id);

	public int delete(int id);

}