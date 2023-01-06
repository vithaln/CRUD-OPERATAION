package com.vithal.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOperationApplication.class, args);
	}
/**
 * @author Vithal
 * 
 * 
 * convert entity to dto and vice versa
1:add modelmapper dependancy
2:create Bean of the modelmapper
3:inject in service layer
4:create dto class whose attributes must same as entity no need entity and table annotations.
5:in service layer we shoud accept Dto and return Dto calssess.
6:in service class we need create two methods 1:convert dtoToEntity , vice versa and by using modelmapper we jsut map it.
in implemntions methods just we can convert dto to entity then convert entity to dto then return dto class.
7:controller class should accept Dtos and return dtos.


 */
}
