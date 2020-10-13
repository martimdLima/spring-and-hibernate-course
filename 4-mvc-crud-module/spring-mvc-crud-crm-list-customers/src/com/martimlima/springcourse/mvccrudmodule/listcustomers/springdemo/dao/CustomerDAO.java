package com.martimlima.springcourse.mvccrudmodule.listcustomers.springdemo.dao;

import java.util.List;

import com.martimlima.springcourse.mvccrudmodule.listcustomers.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
}
