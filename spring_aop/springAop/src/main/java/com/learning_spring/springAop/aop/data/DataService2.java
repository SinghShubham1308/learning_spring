package com.learning_spring.springAop.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {
	public int[] retreiveData() {
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new int [] {111,222,333,444,555};
	}
}
