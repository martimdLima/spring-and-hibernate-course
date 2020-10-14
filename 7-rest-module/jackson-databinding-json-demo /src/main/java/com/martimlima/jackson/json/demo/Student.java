package com.martimlima.jackson.json.demo;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown=true)
public class Student {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private boolean active;
	
	private Address address;
	
	private String[] languages;

	
	public Student() {
	}
	
	
	public Student(String firstName, String lastName, boolean active, Address address, String[] languages) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
		this.address = address;
		this.languages = languages;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
		public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", active=" + active
				+ ", address=" + address + ", languages=" + Arrays.toString(languages) + "]";
	}
}