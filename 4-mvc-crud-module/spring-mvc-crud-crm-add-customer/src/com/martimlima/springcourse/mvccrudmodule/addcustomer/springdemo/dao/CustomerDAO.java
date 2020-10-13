package com.martimlima.springcourse.mvccrudmodule.addcustomer.springdemo.dao;

import java.util.List;

import com.martimlima.springcourse.mvccrudmodule.addcustomer.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
}
