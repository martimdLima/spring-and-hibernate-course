package com.martimlima.springboot.cruddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martimlima.springboot.cruddemo.entity.Employee;

// Jpa Spring Implementation doesn't need implementation
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
