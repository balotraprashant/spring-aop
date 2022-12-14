package com.hustlecrafts.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
		System.out.println("\\n =====>>> PERFORMING API ANALYTICS");
	}
}
