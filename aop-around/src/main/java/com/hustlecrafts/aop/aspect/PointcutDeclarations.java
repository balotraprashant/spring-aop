package com.hustlecrafts.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutDeclarations {

	@Pointcut("execution(* com.hustlecrafts.aop.pojo.*.*(..))")
	public void forPojoPackage() {
	}

	@Pointcut("execution(* com.hustlecrafts.aop.pojo.*.get*(..))")
	public void getter() {
	}

	@Pointcut("execution(* com.hustlecrafts.aop.pojo.*.set*(..))")
	public void setter() {
	}

	@Pointcut("execution(* com.hustlecrafts.aop.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("forPojoPackage() && !(getter() || setter())")
	public void forPojoPackageExcludingGetterAndSetter() {
	}
}
