package com.hustlecrafts.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	//this is where we add all of our related advices for logging
	
	//let's start with @Before advice
	
//	@Before("execution(public void addAccount())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n =====>>> Executing @Before advice on addAccount()");
//	}
	
	//pointcut for a specific class by using fully qualified class name
//	@Before("execution(public void com.hustlecrafts.aop.dao.AccountDAO.addAccount())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n =====>>> Executing @Before advice on addAccount()");
//	}
	
	//pointcut for a any method starting with add using wildcard character(*)
//	@Before("execution(public void add*())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n =====>>> Executing @Before advice on addAccount()");
//	}
	
	//pointcut using wildcards
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n =====>>> Executing @Before advice on addAccount()");
	}
	
	@Before("execution(* add*(com.hustlecrafts.aop.Account))")
	public void beforeAddAdvice() {
		System.out.println("\n =====>>> Executing @Before advice on addAccount(Account)");
	}
}
