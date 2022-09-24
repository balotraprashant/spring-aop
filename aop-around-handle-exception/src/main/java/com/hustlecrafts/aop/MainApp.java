package com.hustlecrafts.aop;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hustlecrafts.aop.service.TrafficFortuneService;

public class MainApp {
	
	private static Logger logger = Logger.getLogger(MainApp.class.getName());

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPConfig.class);

		TrafficFortuneService fortuneService = applicationContext.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		logger.info("Calling getFortune()");
		
		boolean tripWire = true;
		
		String data = fortuneService.getFortune(tripWire);

		logger.info("My Fortune is: " + data);
		
		logger.info("Finished..!");
		
		applicationContext.close();
	}
}
