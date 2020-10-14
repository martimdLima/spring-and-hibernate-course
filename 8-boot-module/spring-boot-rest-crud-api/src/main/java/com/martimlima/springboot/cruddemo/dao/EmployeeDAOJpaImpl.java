package com.martimlima.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.martimlima.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	// define field for the entity manager
	private EntityManager entityManager;
	
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		// create a query
		Query query = entityManager.createQuery("from Employee", Employee.class); 
		
		// execute query and get result list
		List<Employee> employeeList = query.getResultList();
		
		// return the results
		return employeeList;
	}

	@Override
	public Employee findById(int id) {
		
		// get employee
		Employee employee = entityManager.find(Employee.class, id);
		
		// return employee
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		// save or update the employee 
		Employee dbEmployee = entityManager.merge(employee);
		
		// update with id from the db, in order to generate a new id for save/insert
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int id) {
		
		// delete object with primary key	
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
	}
}
