package com.martimlima.springdemo.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martimlima.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> studentList;
	
	// define @PostConstruct to load the student data only once
	@PostConstruct
	public void loadData() {
		
		studentList = new ArrayList<>();
		
		studentList.add(new Student("Dorth", "Voder"));
		studentList.add(new Student("Borth", "Doder"));
		studentList.add(new Student("Wario", "Aluigi"));
	}
	
	// define endpoint for "/students" - return the list of students
	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentList;
	}
	
	
	// define endpoint for "/students/{studentId}" - return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// check the studentId agains the list size
		if(studentId >= studentList.size() || studentId < 0) {
			throw new StudentNotFoundException("student id not found for student " + studentId);
		}
		
		Student student = studentList.get(studentId);
		
		return student;
	}
}
