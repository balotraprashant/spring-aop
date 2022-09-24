package com.hustlecrafts.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
	
	@Before("com.hustlecrafts.aop.aspect.PointcutDeclarations.forPojoPackage()")
	public void printJoinPointSignature(JoinPoint joinPoint) {
		System.out.println("Signature : " + joinPoint.getSignature());
		
		Object[] args = joinPoint.getArgs();
		
		for(Object arg: args) {
			System.out.println(arg);
			
			if(arg instanceof String) {
				String name = (String)arg;
				System.out.println("Name : " + name);
			}
		}
	}
}
