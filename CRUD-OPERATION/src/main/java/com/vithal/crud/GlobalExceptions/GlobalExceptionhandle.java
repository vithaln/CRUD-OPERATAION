package com.vithal.crud.GlobalExceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<List> processUnmergeException(final MethodArgumentNotValidException ex) {

       List list = ex.getBindingResult().getAllErrors().stream()
               .map(fieldError -> fieldError.getDefaultMessage())
               .collect(Collectors.toList());

        return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
    }
}
