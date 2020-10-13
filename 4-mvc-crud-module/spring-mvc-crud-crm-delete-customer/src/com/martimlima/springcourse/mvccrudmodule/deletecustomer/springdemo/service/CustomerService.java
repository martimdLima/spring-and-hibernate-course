package com.martimlima.springcourse.mvccrudmodule.deletecustomer.springdemo.service;

import java.util.List;

import com.martimlima.springcourse.mvccrudmodule.deletecustomer.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
