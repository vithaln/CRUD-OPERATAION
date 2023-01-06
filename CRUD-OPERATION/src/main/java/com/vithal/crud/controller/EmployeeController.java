package com.vithal.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vithal.crud.Dto.EmployeeDto;
import com.vithal.crud.entities.Employee;
import com.vithal.crud.exceptions.payload.DeleteResponse;
import com.vithal.crud.service.EmployeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

	// inject the EmployeeService to call the service layer.
	@Autowired
	private EmployeService employeService;

//Create the Employee by using this API.
	@RequestMapping(value = "/", method = RequestMethod.POST)
//@PostMapping("/")
	public ResponseEntity<EmployeeDto> saveEmployees(@RequestBody EmployeeDto employeedto) {
		log.info("Create method is called these are the Data: {} ", employeedto);
		EmployeeDto createEmployee = employeService.createEmployee(employeedto);
		log.info("Saved the Data in DATABASE : {} ", createEmployee);
		return new ResponseEntity<EmployeeDto>(createEmployee, HttpStatus.CREATED);

	}

//get All employees through this API.
	@RequestMapping(value = "/", method = RequestMethod.GET)
//@GetMapping("/")
	public ResponseEntity<List<EmployeeDto>> fetchAllEmployees() {
		log.info("Fetching Employee method got callled! ");
		List<EmployeeDto> allEmployees = employeService.getAllEmployees();
		log.info("Fetched Data from DATABASE these are : {} ", allEmployees);
		return new ResponseEntity<List<EmployeeDto>>(allEmployees, HttpStatus.OK);

	}

//Fetch single Employee by using employee Id.
	@RequestMapping(value = "/{empId}", method = RequestMethod.GET)
//@GetMapping("/{empId}")
	public ResponseEntity<EmployeeDto> fetchSingleEmployee(@PathVariable String empId) {
		log.info("Fetch Single employee method called by using this Id: {} ", empId);
		EmployeeDto singleEmployee = employeService.getSingleEmployee(empId);
		log.info("this is the single employee details: {} ", singleEmployee);
		return new ResponseEntity<EmployeeDto>(singleEmployee, HttpStatus.OK);
	}

//update employee by using employee Id
	@RequestMapping(value = "/{empId}", method = RequestMethod.PUT)
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeedto, @PathVariable String empId) {
		log.info("update employee method called by using this Id: {} ", empId);
		EmployeeDto updateEmployee = employeService.updateEmployee(employeedto, empId);
		log.info("these are the updated employee details: {} ", updateEmployee);
		return new ResponseEntity<EmployeeDto>(updateEmployee, HttpStatus.OK);
	}

//delete employee by using employee Id.
	@RequestMapping(value = "/{empId}", method = RequestMethod.DELETE)
//@DeleteMapping("/{empId}")
	public ResponseEntity<DeleteResponse> deleteEmployee(@PathVariable String empId) {
		log.info("Delete employee method called by using this Id: {} ", empId);
		employeService.deleteEmployee(empId);
		log.info("Employee has been deleted by this Id: {} ", empId);
		DeleteResponse deleteResponse = DeleteResponse.builder().message("Employee has been deleted successfully!! ")
				.success(true).statuscode(HttpStatus.OK).build();
		return new ResponseEntity<DeleteResponse>(deleteResponse, HttpStatus.OK);
	}
}
