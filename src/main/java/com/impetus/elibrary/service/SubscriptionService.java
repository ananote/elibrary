package com.impetus.elibrary.service;

import java.lang.reflect.Field;
import java.util.List;

import com.impetus.elibrary.model.Subscription;

public interface SubscriptionService {
	public int save(Subscription subscription);

	public List<Subscription> list(int startIndex, int pageSize, Field sortColumn, boolean asc);
	
	public List<Subscription> list(Subscription criteria);

	public Subscription getById(int id);

	public int delete(int id);

}