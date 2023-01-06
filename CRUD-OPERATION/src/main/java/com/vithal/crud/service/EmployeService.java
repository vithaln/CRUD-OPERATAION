package com.vithal.crud.service;

import java.util.List;

import com.vithal.crud.Dto.EmployeeDto;
import com.vithal.crud.entities.Employee;

public interface EmployeService {

	//create employees
	EmployeeDto createEmployee(EmployeeDto employeedto);
	
	//get AllEmployees
	List<EmployeeDto> getAllEmployees();
	
	//get single employee
	EmployeeDto getSingleEmployee(String empId);
	
	//update employee by Id
	EmployeeDto updateEmployee(EmployeeDto employeedto, String empId);
	
	//delete employees
	void deleteEmployee(String empId);
	
	
}
