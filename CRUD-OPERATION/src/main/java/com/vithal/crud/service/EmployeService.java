package com.vithal.crud.service;

import java.util.List;

import com.vithal.crud.entities.Employee;

public interface EmployeService {

	//create employees
	Employee createEmployee(Employee employee);
	
	//get AllEmployees
	List<Employee> getAllEmployees();
	
	//get single employee
	Employee getSingleEmployee(String empId);
	
	//update employee by Id
	Employee updateEmployee(Employee employee, String empId);
	
	//delete employees
	void deleteEmployee(String empId);
	
	
}
