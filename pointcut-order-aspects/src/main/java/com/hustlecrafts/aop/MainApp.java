package com.hustlecrafts.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hustlecrafts.aop.dao.AccountDAO;
import com.hustlecrafts.aop.dao.MembershipDAO;
import com.hustlecrafts.aop.pojo.Student;

public class MainApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(AOPConfig.class);
		
		AccountDAO accountDAO = applicationContext.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO membershipDAO = applicationContext.getBean("membershipDAO", MembershipDAO.class);
		
		Student std = applicationContext.getBean("student", Student.class);
		
		accountDAO.addAccount(new Account());
		
		membershipDAO.addSillyMember();
		
		std.setFirstName("Prashant");
		
		std.setLastName("Balotra");
		
		std.getFirstName();
		
		std.addMarks(4);
		std.addMarks(4);
		
		std.getMarks();
		
		accountDAO.goToSleep();
		
		applicationContext.close();
	}
}
