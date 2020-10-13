package com.martimlima.springcourse.mvccrudmodule.addgetpostmappings.springdemo.dao;

import java.util.List;

import com.martimlima.springcourse.mvccrudmodule.addgetpostmappings.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
}
