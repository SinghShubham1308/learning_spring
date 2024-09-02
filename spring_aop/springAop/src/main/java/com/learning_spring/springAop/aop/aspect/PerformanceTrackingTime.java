package com.learning_spring.springAop.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingTime {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Around("com.learning_spring.springAop.aop.aspect.CommonPointcutConfig.BusinessAndDataPackeageConfig()")
	public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		start timer
		long starttimeMillis = System.currentTimeMillis();
//		execute the method
		Object proceed = proceedingJoinPoint.proceed();
//		stop the timer
		long stoptimeMillis = System.currentTimeMillis();
		
		long executionTime = stoptimeMillis - starttimeMillis;
		logger.info("Around aspectAround -{} executed in {} ms",proceedingJoinPoint ,executionTime);
		return proceed;
	}
}
