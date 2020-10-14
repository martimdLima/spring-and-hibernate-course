package com.martimlima.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to Java POJO: data/sample-lite.json
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			Address studentAddress = student.getAddress();
			String[] studentLanguages = student.getLanguages();
			
			// print the first and last name
			System.out.println("Student name: " + student.getFirstName() + " " + student.getLastName());
			
			System.out.println("Student Address: " + studentAddress.getStreet() + ", " 
												   + studentAddress.getZip() + ", " 
												   + studentAddress.getCity() + ", " 
												   + studentAddress.getState()+ ", " 
												   + studentAddress.getCountry() );
			
			System.out.print("Student Languages: ");
			for(String language: studentLanguages) {
				System.out.print(language + ", ");
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
