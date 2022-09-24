package com.hustlecrafts.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hustlecrafts.aop.service.TrafficFortuneService;

public class MainApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPConfig.class);

		TrafficFortuneService fortuneService = applicationContext.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("Calling getFortune()");
		String data = fortuneService.getFortune();

		System.out.println("My Fortune is: " + data);
		
		System.out.println("Finished..!");
		
		applicationContext.close();
	}
}
