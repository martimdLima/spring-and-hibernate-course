package com.martimlima.springcourse.mvccrudmodule.addservicelayer.springdemo.service;

import java.util.List;

import com.martimlima.springcourse.mvccrudmodule.addservicelayer.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
}
