package com.hustlecrafts.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hustlecrafts.aop.dao.AccountDAO;
import com.hustlecrafts.aop.pojo.Account;

public class MainApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(AOPConfig.class);
		
		AccountDAO accountDAO = applicationContext.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = accountDAO.findAccounts();
		
		System.out.println("After returning  : ");
		System.out.println("---");
		
		System.out.println(accounts);
		System.out.println();
				
		applicationContext.close();
	}
}
