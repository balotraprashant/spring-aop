package com.hustlecrafts.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hustlecrafts.aop.dao.AccountDAO;
import com.hustlecrafts.aop.pojo.Account;

public class MainApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPConfig.class);

		AccountDAO accountDAO = applicationContext.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = null;

		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception exc) {
			System.out.println("Caught Exception : " + exc);
		}

		System.out.println("After throwing  : ");
		System.out.println("---");

		System.out.println(accounts);
		System.out.println();

		applicationContext.close();
	}
}
