package com.Learning.learn_spring_framework.Helloconfig;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Learning.learn_spring_framework.Helloconfig.HelloConfiguration.Person;
import com.Learning.learn_spring_framework.Helloconfig.HelloConfiguration.Person2;

public class App02Basicgame {

	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(HelloConfiguration.class)) {
			System.out.println(context.getBean("Name"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("getperson"));
			System.out.println(context.getBean(Person.class));
			System.out.println(context.getBean(Person2.class));
			System.out.println(context.getBean("personbymethods"));
			System.out.println(context.getBean("personfromotherbean"));
			System.out.println(context.getBean("getaddress"));

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
