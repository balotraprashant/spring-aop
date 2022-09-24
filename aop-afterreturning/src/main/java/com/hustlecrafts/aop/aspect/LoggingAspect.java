package com.hustlecrafts.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.hustlecrafts.aop.pojo.Account;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
	
	@Before("com.hustlecrafts.aop.aspect.PointcutDeclarations.forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n =====>>> Executing @Before advice on method");
	}
	
	@Before("com.hustlecrafts.aop.aspect.PointcutDeclarations.forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n =====>>> PERFORMING API ANALYTICS");
	}
	
	@AfterReturning(
			pointcut = "execution(* com.hustlecrafts.aop.dao.AccountDAO.findAccounts(..))",
			returning = "result"
			)
	public void afterReturningFindAccountsAdvice(
			JoinPoint joinpoint, List<Account> result){
		//print out which method we are advising on
		String method = joinpoint.getSignature().toShortString();
		System.out.println("\n ===>> Executing After returning on method : " + method);
		
		//post process the data
		for(Account account: result) {
			account.setName(account.getName().toUpperCase());
		}
		
		//printout the results of the method call
		System.out.println("\n ===>> Result is " + result);
	}
	
}
