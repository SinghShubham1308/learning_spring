package com.Learning.learn_spring_framework.Helloconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HelloConfiguration {

	record Person(String name, int age) {
	}

	record Person2(String name, int age, address getaddress) {
	}

	record address(String address, String city) {
	}

	@Bean(name = "Name")
	public String name() {
		return "shubham singh";
	}

	@Bean
	public int age() {
		return 23;
	}

	@Bean
	public Person getperson() {
		return new Person("Abhishek", 22);
	}

	@Bean(name = "personfromotherbean")
	public Person2 personfromotherBean(String name, int age, address getaddress2) {
		return new Person2(name, age, getaddress2);
	}

	@Bean(name = "personbymethods")
	@Primary
	public Person2 personbymethods() {
		return new Person2(name(), age(), getaddress(
				));
	}
	@Bean(name = "getaddress")
	public address getaddress() {
		var location = new address("4/143 sec-h jankipuram", "lucknow");
		return location;
	}
	
	@Bean(name = "getaddress2")
	public address getaddress2() {
		var location = new address("4/143 sec-h jankipuram", "lucknow");
		return location;
	}
}
