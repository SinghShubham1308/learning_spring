package com.learning_spring.springAop.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
	@Pointcut("execution(* com.learning_spring.springAop.aop.*.*.*(..))")
	public void BusinessAndDataPackeageConfig() {
	}

	@Pointcut("execution(* com.learning_spring.springAop.aop.business.*.*(..))")
	public void BusinessPackeageConfig() {
	}

	@Pointcut("execution(* com.learning_spring.springAop.aop.data.*.*(..))")
	public void DataPackeageConfig() {
	}
	@Pointcut("bean(*Service*)")
	public void allPackeageConfigUsingBean() {
	}
	@Pointcut("@annotation(com.learning_spring.springAop.aop.annotations.TrackTime)")
	public void tracktimeAnnotations() {
	}
}
