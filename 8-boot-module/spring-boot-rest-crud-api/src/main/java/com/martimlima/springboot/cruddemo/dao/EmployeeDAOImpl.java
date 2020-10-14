package com.martimlima.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.martimlima.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	// define field for the entity manager
	private EntityManager entityManager;
	
	// Set up the constructor injection
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		
		// execute the query and get result list
		List<Employee> employeeList = query.getResultList();
		
		// return the results
		return employeeList;
	}

	@Override
	public Employee findById(int id) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Employee employeemployee =
				currentSession.get(Employee.class, id);
		
		// return the employee
		return employeemployee;
	}


	@Override
	public void save(Employee employee) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(employee);
	}


	@Override
	public void deleteById(int id) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
	}

}