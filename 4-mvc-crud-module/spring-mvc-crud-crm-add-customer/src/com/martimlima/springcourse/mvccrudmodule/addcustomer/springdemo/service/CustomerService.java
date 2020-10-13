package com.martimlima.springcourse.mvccrudmodule.addcustomer.springdemo.service;

import java.util.List;

import com.martimlima.springcourse.mvccrudmodule.addcustomer.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
}
