package com.learning_spring.springAop.aop.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.learning_spring.springAop.aop.data.DataService2;

@Service
public class BusinessService2 {
	private DataService2 dataservice2;

	public BusinessService2(DataService2 dataservice2) {
		super();
		this.dataservice2 = dataservice2;
	}

	public int calculateMin() {
		int data[] = dataservice2.retreiveData();
//		throw new RuntimeException("Something went wrong!"); 
		return Arrays.stream(data).min().orElse(0);
	}
}
