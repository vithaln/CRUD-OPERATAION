package com.vithal.crud.exceptions.payload;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponses {
	
	private String message;
	private String description;
	private HttpStatus status;
	private boolean success;

}
