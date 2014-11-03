package com.impetus.elibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.elibrary.dao.UserDao;
import com.impetus.elibrary.model.User;

//import org.app.util.HibernateUtil;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserDao userDao;

	@Override
	public boolean authenticate(String username, String password) {
		System.out.println("USER= " + userDao);
		User user = userDao.getUserByUsername(username);
		if (user != null && user.getUsername().equals(username)
				&& user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

}