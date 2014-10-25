package com.impetus.elibrary.dao;

import java.util.List;

import com.impetus.elibrary.model.UserSubscription;

public interface UserSubscriptionDao {

	public int saveOrUpdate(UserSubscription userSubscription);

	public List<UserSubscription> list();
	
	public List<UserSubscription> list(UserSubscription criteria);

	public UserSubscription getById(int id);

	public int delete(int id);

}