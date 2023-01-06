package com.vithal.crud.serviceIml;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vithal.crud.entities.Employee;
import com.vithal.crud.exceptions.EmployeeNotFound;
import com.vithal.crud.repository.EmployeeRepository;
import com.vithal.crud.service.EmployeService;

@Service
public class EmployeeImplementation implements EmployeService {

	//Inject the Employee repository.
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	
	@Override
	public Employee createEmployee(Employee employee) {
		
		String empId = UUID.randomUUID().toString();
		employee.setEmpId(empId);
		Employee employees = employeeRepository.save(employee);
		return employees;
	}

	@Override
	public List<Employee> getAllEmployees() {
	
		List<Employee> AllEmployees = employeeRepository.findAll();
		return AllEmployees;
	}

	@Override
	public Employee getSingleEmployee(String empId) {
		Employee employee = employeeRepository.findById(empId).orElseThrow(()-> new EmployeeNotFound("Employee not found by using this Id to display: "+empId));
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee, String empId) {
		Employee employe = employeeRepository.findById(empId).orElseThrow(()-> new EmployeeNotFound("Employee not found by using this Id to update: "+empId));
		
	
		employe.setEmpFirstname(employee.getEmpFirstname());
		employe.setEmpLastname(employee.getEmpLastname());
		employe.setEmpEmail(employee.getEmpEmail());
		employe.setEmpPassword(employee.getEmpPassword());
		employe.setEmpMiddlename(employee.getEmpMiddlename());
		employe.setEmpMobilenumber(employee.getEmpMobilenumber());
		employe.setEmpPincode(employee.getEmpPincode());
		employe.setEmpCountry(employee.getEmpCountry());
		employe.setEmpDistrict(employee.getEmpDistrict());
		employe.setEmpTaluk(employee.getEmpTaluk());
		employe.setEmpAbout(employee.getEmpAbout());
		employe.setEmpState(employee.getEmpState());
		
		Employee updatedEmployee = employeeRepository.save(employe);
		return updatedEmployee;
	}

	@Override
	public void deleteEmployee(String empId) {
		employeeRepository.findById(empId).orElseThrow(()-> new EmployeeNotFound("Employee not found by using this Id to delete!: "+empId));
		employeeRepository.deleteById(empId);
	}

	
	
}
