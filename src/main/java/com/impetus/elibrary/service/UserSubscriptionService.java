package com.impetus.elibrary.service;

import java.lang.reflect.Field;
import java.util.List;

import com.impetus.elibrary.model.UserSubscription;

public interface UserSubscriptionService {
	public int save(UserSubscription userSubscription);

	public List<UserSubscription> list(int startIndex, int pageSize, Field sortColumn, boolean asc);
	
	public List<UserSubscription> list(UserSubscription criteria);

	public UserSubscription getById(int id);

	public int delete(int id);

}