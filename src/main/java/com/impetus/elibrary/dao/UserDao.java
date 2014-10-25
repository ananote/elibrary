package com.impetus.elibrary.dao;

import java.util.List;

import com.impetus.elibrary.model.User;

public interface UserDao {

	public int saveOrUpdate(User user);

	public List<User> list();
	
	public List<User> list(User criteria);

	public User getById(int id);

	public int delete(int id);

}