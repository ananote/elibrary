package com.impetus.elibrary.service;

import java.lang.reflect.Field;
import java.util.List;

import com.impetus.elibrary.model.UserEmail;

public interface UserEmailService {
	public int save(UserEmail userEmail);

	public List<UserEmail> list(int startIndex, int pageSize, Field sortColumn, boolean asc);
	
	public List<UserEmail> list(UserEmail criteria);

	public UserEmail getById(int id);

	public int delete(int id);

}