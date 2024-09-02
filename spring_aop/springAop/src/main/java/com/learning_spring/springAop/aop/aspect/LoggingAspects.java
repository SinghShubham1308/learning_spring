package com.learning_spring.springAop.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspects {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Before("com.learning_spring.springAop.aop.aspect.CommonPointcutConfig.allPackeageConfigUsingBean()")
	public void logMethodCallBefor(JoinPoint joinPoint) {
		logger.info("Befor aspects {} Executing method call before {}", joinPoint, joinPoint.getArgs());
	}

	@After("com.learning_spring.springAop.aop.aspect.CommonPointcutConfig.BusinessAndDataPackeageConfig())")
	public void logMethodCallAfterThrowing(JoinPoint joinPoint) {
		logger.info("after aspects {} Executing method call before {}", joinPoint, joinPoint.getArgs());
	}
	@AfterThrowing(pointcut = "com.learning_spring.springAop.aop.aspect.CommonPointcutConfig.BusinessAndDataPackeageConfig()", throwing = "exception")
	public void logMethodCallAfterReturning(JoinPoint joinPoint, Exception exception) {
		logger.info("after aspects returning {} exeception has occured {}", joinPoint, exception );
	}
	@AfterReturning(pointcut = "com.learning_spring.springAop.aop.aspect.CommonPointcutConfig.BusinessAndDataPackeageConfig()", returning = "Successfull")
	public void logMethodCallAfterReturning(JoinPoint joinPoint, Object Successfull) {
		logger.info("after aspects returning {} executed {}", joinPoint, Successfull);
	}
}
