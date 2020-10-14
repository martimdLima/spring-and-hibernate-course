package com.martimlima.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.martimlima.springboot.thymeleafdemo.entity.Employee;
import com.martimlima.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		// get the employees from the database
		List<Employee> employeeList = employeeService.findAll();
		
		// add to the spring model
		model.addAttribute("employeeList", employeeList);
		model.addAttribute("currentDate", new java.util.Date());
		
		return "employees/list-employees";
	}
	
	@GetMapping("/list/{employeeId}")
	public String getEmployee(@PathVariable int employeeId, Model model) {
		
		// get the employee from the database
		Employee employee = employeeService.findById(employeeId);
		
		if(employee == null) {
			throw new RuntimeException("Employee id: " + employeeId + " was not found in the dabatase");
		}
		
		model.addAttribute("employee", employee);
		model.addAttribute("currentDate", new java.util.Date());
		
		return "employees/list-employee";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		// create model attribute to bind form data
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		model.addAttribute("currentDate", new java.util.Date());
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		// save the employee
		employeeService.save(employee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateEmployee(@RequestParam("employeeId") int id, Model model) {
			
		Employee employee = employeeService.findById(id);
		
		model.addAttribute("employee", employee);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		
		employeeService.deleteById(id);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam("employeeName") String name,
						 Model model) {
		
		// delete the employee
		List<Employee> employees = employeeService.searchBy(name);
		
		// add to the spring model
		model.addAttribute("employees", employees);
		
		// send to /employees/list
		return "/employees/list-employees";	
	}
}
