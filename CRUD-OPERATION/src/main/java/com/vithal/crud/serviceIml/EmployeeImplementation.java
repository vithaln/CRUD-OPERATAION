package com.vithal.crud.serviceIml;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vithal.crud.Dto.EmployeeDto;
import com.vithal.crud.entities.Employee;
import com.vithal.crud.exceptions.EmployeeNotFound;
import com.vithal.crud.repository.EmployeeRepository;
import com.vithal.crud.service.EmployeService;

@Service
public class EmployeeImplementation implements EmployeService {

	//Inject the Employee repository.
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//inject the modelmapper to map the entity to DTO and vice varsa...
@Autowired
	private ModelMapper mapper;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeedto) {
		Employee employee = this.dtoToEmployee(employeedto);
		String empId = UUID.randomUUID().toString();
		employee.setEmpId(empId);
		Employee employees = employeeRepository.save(employee);
		EmployeeDto employeeToDto = this.employeeToDto(employees);
		return employeeToDto;
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
	
		List<Employee> AllEmployees = employeeRepository.findAll();
		List<EmployeeDto> empDtos = AllEmployees.stream().map(emp->this.employeeToDto(emp)).collect(Collectors.toList());
		return empDtos;
	}

	@Override
	public EmployeeDto getSingleEmployee(String empId) {
		Employee employee = employeeRepository.findById(empId).orElseThrow(()-> new EmployeeNotFound("Employee not found by using this Id to display: "+empId));
	EmployeeDto employeeToDto = this.employeeToDto(employee);
		return employeeToDto;
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeedto, String empId) {
		
	//	Employee employee = this.dtoToEmployee(employeedto);
		Employee employe = employeeRepository.findById(empId).orElseThrow(()-> new EmployeeNotFound("Employee not found by using this Id to update: "+empId));
		
	
		employe.setEmpFirstname(employeedto.getEmpFirstname());
		employe.setEmpLastname(employeedto.getEmpLastname());
		employe.setEmpEmail(employeedto.getEmpEmail());
		employe.setEmpPassword(employeedto.getEmpPassword());
		employe.setEmpMiddlename(employeedto.getEmpMiddlename());
		employe.setEmpMobilenumber(employeedto.getEmpMobilenumber());
		employe.setEmpPincode(employeedto.getEmpPincode());
		employe.setEmpCountry(employeedto.getEmpCountry());
		employe.setEmpDistrict(employeedto.getEmpDistrict());
		employe.setEmpTaluk(employeedto.getEmpTaluk());
		employe.setEmpAbout(employeedto.getEmpAbout());
		employe.setEmpState(employeedto.getEmpState());
		
		Employee updatedEmployee = employeeRepository.save(employe);
		EmployeeDto employeeToDto = this.employeeToDto(updatedEmployee);
		return employeeToDto;
	}

	@Override
	public void deleteEmployee(String empId) {
		employeeRepository.findById(empId).orElseThrow(()-> new EmployeeNotFound("Employee not found by using this Id to delete!: "+empId));
		employeeRepository.deleteById(empId);
	}
//convert Dto to Employee object
	public Employee dtoToEmployee(EmployeeDto employeeDto) {
		Employee employee = this.mapper.map(employeeDto, Employee.class);
		return employee;
	}
	
	//convert employee to dto
	public EmployeeDto employeeToDto(Employee employee) {
		EmployeeDto employeedto = this.mapper.map(employee, EmployeeDto.class);
		return employeedto;
	}
	
	
}
