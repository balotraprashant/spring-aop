package com.hustlecrafts.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hustlecrafts.aop.pojo.Student;

public class MainApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(AOPConfig.class);
		
		Student std = applicationContext.getBean("student", Student.class);
		
		std.setFirstName("Prashant");
		
		std.setLastName("Balotra");
		
		std.getFirstName();
		
		std.addMarks(4);
		std.addMarks(4);
		
		std.getMarks();
				
		applicationContext.close();
	}
}
