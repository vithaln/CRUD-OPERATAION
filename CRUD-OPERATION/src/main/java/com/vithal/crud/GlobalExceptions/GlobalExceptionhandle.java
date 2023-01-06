package com.vithal.crud.GlobalExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vithal.crud.exceptions.EmployeeNotFound;
import com.vithal.crud.exceptions.payload.ErrorResponses;

@RestControllerAdvice
public class GlobalExceptionhandle {

	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<ErrorResponses> employeeNotFoundExceptionHandler(EmployeeNotFound ex){
		
		ErrorResponses errorResponses = ErrorResponses.builder()
		.message(ex.getMessage())
		.description("Sorry! You have entered Invalid Employee Id! please try again by correct Emplyoee Id..Thanks for the visiting!")
		.status(HttpStatus.NOT_FOUND)
		.success(false)
		.build();
		
		return ResponseEntity.ok(errorResponses);
	}
}
