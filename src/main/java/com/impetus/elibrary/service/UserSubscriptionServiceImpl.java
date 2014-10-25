package com.impetus.elibrary.service;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.impetus.elibrary.dao.UserSubscriptionDao;
import com.impetus.elibrary.model.UserSubscription;
import com.impetus.elibrary.utils.ModelUtils;

@Service
public class UserSubscriptionServiceImpl implements UserSubscriptionService {

	@Autowired
	UserSubscriptionDao userSubscriptionDao;

	public int save(UserSubscription userSubscription) {
		return userSubscriptionDao.saveOrUpdate(userSubscription);
	}

	public List<UserSubscription> list(int startIndex, int pageSize, Field sortColumn, boolean asc) {
		List<UserSubscription> userSubscriptionList = userSubscriptionDao.list();
		
		if(! StringUtils.isEmpty(sortColumn)){
			userSubscriptionList = ModelUtils.sortOn(userSubscriptionList, sortColumn, asc);
		}
		
		return userSubscriptionList;
	}

	public List<UserSubscription> list(UserSubscription criteria) {
		return userSubscriptionDao.list(criteria);
	}

	public UserSubscription getById(int id) {
		return userSubscriptionDao.getById(id);
	}

	public int delete(int id) {
		return userSubscriptionDao.delete(id);
	}

}