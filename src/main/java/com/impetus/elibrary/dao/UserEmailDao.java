package com.impetus.elibrary.dao;

import java.util.List;

import com.impetus.elibrary.model.UserEmail;

public interface UserEmailDao {

	public int saveOrUpdate(UserEmail userEmail);

	public List<UserEmail> list();
	
	public List<UserEmail> list(UserEmail criteria);

	public UserEmail getById(int id);

	public int delete(int id);

}