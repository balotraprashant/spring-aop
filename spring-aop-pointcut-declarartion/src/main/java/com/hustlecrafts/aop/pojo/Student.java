package com.hustlecrafts.aop.pojo;

import org.springframework.stereotype.Component;

@Component
public class Student {

	private String firstName;
	
	private String lastName;
	
	private int marks;
	
	public void addMarks(int marks) {
		this.marks += marks;
		System.out.println("MARKS AFTER ADDING : " + this.marks);
	}

	public String getFirstName() {
		System.out.println(getClass() + " in getFirstName()");
		return firstName;
	}

	public void setFirstName(String firstName) {
		System.out.println(getClass() + " in setFirstName()");
		this.firstName = firstName;
	}

	public String getLastName() {
		System.out.println(getClass() + " in getLastName()");
		return lastName;
	}

	public void setLastName(String lastName) {
		System.out.println(getClass() + " in setLastName()");
		this.lastName = lastName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
}
