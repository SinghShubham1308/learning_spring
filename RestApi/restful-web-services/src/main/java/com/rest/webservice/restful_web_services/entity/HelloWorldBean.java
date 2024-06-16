package com.rest.webservice.restful_web_services.entity;

public class HelloWorldBean {

	private String messageString;

	public HelloWorldBean(String messageString) {
		super();
		this.messageString = messageString;
	}

	public String getMessageString() {
		return messageString;
	}

	public void setMessageString(String messageString) {
		this.messageString = messageString;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [messageString=" + messageString + "]";
	}
}
