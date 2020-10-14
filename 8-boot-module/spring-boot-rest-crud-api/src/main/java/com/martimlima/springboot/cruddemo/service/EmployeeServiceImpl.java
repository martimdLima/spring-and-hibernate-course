package com.martimlima.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.martimlima.springboot.cruddemo.dao.EmployeeDAO;
import com.martimlima.springboot.cruddemo.entity.Employee;
import com.martimlima.springboot.cruddemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// private EmployeeDAO employeeDAO;
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	/*
	 * Standard Jpa Implementation
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	*/
	
	/*
	 * Hibernate Implementation
	 
	private EmployeeDAO employeeDAO; 
	 
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	 */
	
	
	@Override
	//@Transactional
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	//@Transactional
	public Employee findById(int id) {
		
		//return employeeRepository.findById(id);
		
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee = null;
		
		if(result.isPresent()) {
			employee = result.get();
			
		} else {
			throw new RuntimeException("Did not find employee id: " + id + " in the database");
		}
		
		return employee;
	}

	@Override
	//@Transactional
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	//@Transactional
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
}
