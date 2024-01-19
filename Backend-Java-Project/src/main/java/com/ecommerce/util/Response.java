package com.ecommerce.util;

//import com.ecommerce.model.Order;

public class Response {
	
	private int statusCode;
	private String message;
	String role;
	
	
	public String getRole() {
		return role;
	}
	public String getMessage() {
		return message;
	}
	private boolean operation;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean getOperation() {
		return operation;
	}
	public void setOperation(boolean operation) {
		this.operation = operation;
	}
	public void setRole(String role) {
		this.role = role;
		
		
	}
	
	
	}


