package com.martimlima.springcourse.mvccrudmodule.addservicelayer.springdemo.dao;

import java.util.List;

import com.martimlima.springcourse.mvccrudmodule.addservicelayer.springdemo.entity.Customer;


public interface CustomerDAO {

	public List<Customer> getCustomers();
	
}
