package com.hustlecrafts.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class CombinedPointcutDeclarations {

	@Before("com.hustlecrafts.aop.aspect.PointcutDeclarations.forPojoPackageExcludingGetterAndSetter())")
	public void beforeAdviceUsingCombinedPointcuts() {
		System.out.println("\n =====>>> Executing @Before advice of Combined Pointcut declarations method");
	}
}
