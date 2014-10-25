package com.impetus.elibrary.dao;

import java.util.List;

import com.impetus.elibrary.model.Subscription;

public interface SubscriptionDao {

	public int saveOrUpdate(Subscription subscription);

	public List<Subscription> list();
	
	public List<Subscription> list(Subscription criteria);

	public Subscription getById(int id);

	public int delete(int id);

}