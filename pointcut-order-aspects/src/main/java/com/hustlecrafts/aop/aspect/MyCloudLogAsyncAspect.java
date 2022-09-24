package com.hustlecrafts.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
	
	@Before("com.hustlecrafts.aop.aspect.PointcutDeclarations.forPojoPackage()")
	public void performCloudLogs() {
		System.out.println("\\n =====>>> PERFORMING CLOUD LOGS");
	}
}
