package com.hustlecrafts.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CombinedPointcutDeclarations {
	
	@Pointcut("execution(* com.hustlecrafts.aop.pojo.*.*(..))")
	private void forPojoPackage() {}
	
	@Pointcut("execution(* com.hustlecrafts.aop.pojo.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* com.hustlecrafts.aop.pojo.*.set*(..))")
	private void setter() {}

	@Before("forPojoPackage() && !(getter() || setter())")
	public void beforeAdviceUsingCombinedPointcuts() {
		System.out.println("\n =====>>> Executing @Before advice of Combined Pointcut declarations method");
	}
}
