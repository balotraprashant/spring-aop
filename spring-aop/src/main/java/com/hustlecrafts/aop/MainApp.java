package com.hustlecrafts.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hustlecrafts.aop.dao.AccountDAO;
import com.hustlecrafts.aop.dao.MembershipDAO;

public class MainApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(AOPConfig.class);
		
		AccountDAO accountDAO = applicationContext.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO membershipDAO = applicationContext.getBean("membershipDAO", MembershipDAO.class);
		
		accountDAO.addAccount(new Account());
		
		membershipDAO.addSillyMember();
		
		applicationContext.close();
	}
}
