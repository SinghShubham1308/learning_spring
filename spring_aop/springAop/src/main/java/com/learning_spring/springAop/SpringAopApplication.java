package com.learning_spring.springAop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.learning_spring.springAop.aop.business.BusinessService1;
import com.learning_spring.springAop.aop.business.BusinessService2;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAopApplication implements CommandLineRunner {
	private BusinessService1 businessService1;
	private BusinessService2 businessService2;
	private Logger logger = LoggerFactory.getLogger(getClass());

	public SpringAopApplication(BusinessService1 businessService1, BusinessService2 businessService2) {
		super();
		this.businessService1 = businessService1;
		this.businessService2 = businessService2;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("running the method from business service {}", businessService1.calculateMax());
		logger.info("running the method from business service2 {}", businessService2.calculateMin());
	}

}
