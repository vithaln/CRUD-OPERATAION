package com.vithal.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vithal.crud.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
	
	Employee findByempEmail(String email);
	
	Employee findByempMobilenumber(String mobile);


}
