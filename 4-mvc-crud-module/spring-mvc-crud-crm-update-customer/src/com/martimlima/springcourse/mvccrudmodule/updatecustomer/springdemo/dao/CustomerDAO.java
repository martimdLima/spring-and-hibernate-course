package com.martimlima.springcourse.mvccrudmodule.updatecustomer.springdemo.dao;

import java.util.List;

import com.martimlima.springcourse.mvccrudmodule.updatecustomer.springdemo.entity.Customer;


public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
	
}
