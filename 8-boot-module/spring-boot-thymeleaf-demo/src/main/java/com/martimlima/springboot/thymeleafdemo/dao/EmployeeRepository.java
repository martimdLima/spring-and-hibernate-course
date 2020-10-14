package com.martimlima.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martimlima.springboot.thymeleafdemo.entity.Employee;

// Jpa Spring Implementation doesn't need implementation
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
	
	// search by name
	public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);

}
