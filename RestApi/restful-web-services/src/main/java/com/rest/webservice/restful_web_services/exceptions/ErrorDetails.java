package com.rest.webservice.restful_web_services.exceptions;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime timeStamp;
	private String message;
	private String Details;
	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return Details;
	}
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ErrorDetails [timeStamp=" + timeStamp + ", message=" + message + ", Details=" + Details + "]";
	}
	public ErrorDetails(LocalDateTime timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		Details = details;
	}
}
