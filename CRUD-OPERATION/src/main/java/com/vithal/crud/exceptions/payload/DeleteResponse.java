package com.vithal.crud.exceptions.payload;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteResponse {
	
	private String message;
	private HttpStatus  statuscode;
	private boolean success;
	

}
