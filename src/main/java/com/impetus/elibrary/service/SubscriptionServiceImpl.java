package com.impetus.elibrary.service;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.impetus.elibrary.dao.SubscriptionDao;
import com.impetus.elibrary.model.Subscription;
import com.impetus.elibrary.utils.ModelUtils;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	SubscriptionDao subscriptionDao;

	@Override
	public int save(Subscription subscription) {
		return subscriptionDao.saveOrUpdate(subscription);
	}

	@Override
	public List<Subscription> list(int startIndex, int pageSize, Field sortColumn, boolean asc) {
		List<Subscription> subscriptionList = subscriptionDao.list();
		
		if(! StringUtils.isEmpty(sortColumn)){
			subscriptionList = ModelUtils.sortOn(subscriptionList, sortColumn, asc);
		}
		
		return subscriptionList;
	}

	@Override
	public List<Subscription> list(Subscription criteria) {
		return subscriptionDao.list(criteria);
	}

	@Override
	public Subscription getById(int id) {
		return subscriptionDao.getById(id);
	}

	@Override
	public int delete(int id) {
		return subscriptionDao.delete(id);
	}

}