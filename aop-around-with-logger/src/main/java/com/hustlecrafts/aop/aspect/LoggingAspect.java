package com.hustlecrafts.aop.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.hustlecrafts.aop.pojo.Account;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Before("com.hustlecrafts.aop.aspect.PointcutDeclarations.forDaoPackage()")
	public void beforeAddAccountAdvice() {
		logger.info("\n =====>>> Executing @Before advice on method");
	}

	@Before("com.hustlecrafts.aop.aspect.PointcutDeclarations.forDaoPackage()")
	public void performApiAnalytics() {
		logger.info("\n =====>>> PERFORMING API ANALYTICS");
	}

	@AfterReturning(pointcut = "execution(* com.hustlecrafts.aop.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinpoint, List<Account> result) {
		// print out which method we are advising on
		String method = joinpoint.getSignature().toShortString();
		logger.info("\n ===>> Executing After returning on method : " + method);

		// post process the data
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}

		// printout the results of the method call
		logger.info("\n ===>> Result is " + result);
	}

	@AfterThrowing(
			pointcut = "execution(* com.hustlecrafts.aop.dao.AccountDAO.findAccounts(..))", 
			throwing = "exception")
	public void afterThrowingFindAccountAdvice(JoinPoint joinpoint, Throwable exception) {
		String method = joinpoint.getSignature().toShortString();
		logger.info("\n ===>> Executing After throwing on method : " + method);

		logger.info("\n ===>> Exception is : " + exception);
	}
	
	@After("execution(* com.hustlecrafts.aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint joinpoint) {
		String method = joinpoint.getSignature().toShortString();
		logger.info("\n ===>> Executing After finally on method : " + method);
		
	}
	
	@Around("execution(* com.hustlecrafts.aop.service.TrafficFortuneService.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint joinPoint) throws Throwable {
		//print out the method we advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n ===>> Executing Around on method : " + method);
		
		//get begin time stamp
		long begin = System.currentTimeMillis();
		
		//now, let's execute the method
		Object result = joinPoint.proceed();
		
		//get end time stamp
		long end = System.currentTimeMillis();
		
		//compute duration and display it
		logger.info("\n===>>> Durataion : " + (end-begin));
		
		return result;
	}

}
