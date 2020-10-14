package com.martimlima.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martimlima.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.martimlima.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// private EmployeeDAO employeeDAO;
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
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
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
	
	@Override
	public List<Employee> searchBy(String name) {
		
		List<Employee> results = null;
		
		if (name != null && (name.trim().length() > 0)) {
			results = employeeRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(name, name);
		} else {
			results = findAll();
		}
		
		return results;
	}
}
