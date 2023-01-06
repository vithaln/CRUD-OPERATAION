package com.vithal.crud.exceptions;

//Custom Exception class, if employee not found then this class gets call.
public class EmployeeNotFound extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;
	

	public EmployeeNotFound() {
		super("USER NOT FOUND!!!");
	}
	
	public EmployeeNotFound(String message) {
		super(message);
	}
}
