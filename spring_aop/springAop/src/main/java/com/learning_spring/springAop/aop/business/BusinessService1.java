package com.learning_spring.springAop.aop.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.learning_spring.springAop.aop.data.DataService1;

@Service
public class BusinessService1 {
	private DataService1 dataservice1;

	public BusinessService1(DataService1 dataservice1) {
		super();
		this.dataservice1 = dataservice1;
	}

	public int calculateMax() {
		int data[] = dataservice1.retreiveData();
//		throw new RuntimeException("Something went wrong!"); 
		return Arrays.stream(data).max().orElse(0);
	}
}
