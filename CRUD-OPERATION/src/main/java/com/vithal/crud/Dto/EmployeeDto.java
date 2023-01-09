package com.vithal.crud.Dto;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {

	private String empId;
	
	@Column(nullable = false, length = 40)
	@NotBlank(message = "employee first name must be mandtatory!..")
	@Length(max = 10,min = 3, message =  "Employee First name must be start at least 3 character to 10.")
	private String empFirstname;
	
	@Column(nullable = false, length = 40)
	@NotBlank(message = "employee middle name must be mandtatory!..")
	@Length(max = 10,min = 3, message =  "Employee Middle name must be start at least 3 character to 10.")
	private String empMiddlename;
	
	@Column(nullable = false, length = 40)
	@NotBlank(message = "employee last name must be mandtatory!..")
	@Length(max = 10,min = 3, message =  "Employee Last name must be start at least 3 character to 10.")
	private String empLastname;
	

	@Column(nullable = false)
	@NotBlank(message = "employee Email must be mandtatory!..")
	@Email(message = "Please enter correct emailId!, this is Invalid email")
	private String empEmail;
	
	@Column(nullable = false, length = 40)
	@NotBlank(message = "employee Password must be mandtatory!..")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$",message = "password must contain 1 number (0-9)\r\n"
			+ "password must contain 1 uppercase letters\r\n"
			+ "password must contain 1 lowercase letters\r\n"
			+ "password must contain 1 non-alpha numeric number\r\n"
			+ "password is 8-16 characters with no space")
	private String empPassword;
	
	
	@Length(min = 10,max = 10,message = "Mobile number must be put Valid!")
	private String empMobilenumber;
	
	@Column(nullable = false, length = 40)
	@NotBlank(message = "employee country must be mandtatory!..")
	@Length(max = 10,min = 3, message =  "Employee country must be start at least 3 character to 10.")
	private String empCountry;
	
	@Column(nullable = false, length = 40)
	@NotBlank(message = "employee state must be mandtatory!..")
	@Length(max = 20,min = 3, message =  "Employee state must be start at least 3 character to 20.")
	private String empState;
	
	@Column(nullable = false, length = 40)
	@NotBlank(message = "employee district must be mandtatory!..")
	@Length(max = 20,min = 3, message =  "Employee district must be start at least 3 character to 20.")
	private String empDistrict;
	
	@Column(nullable = false, length = 40)
	@NotBlank(message = "employee taluk must be mandtatory!..")
	@Length(max = 20,min = 3, message =  "Employee taluk must be start at least 3 character to 20.")
	private String empTaluk;
	
	@Column(nullable = false, length = 40)
	@NotBlank(message = "employee pincode must be mandtatory!..")
	@Length(max = 10,min = 3, message =  "Employee pincode must be start at least 3 character to 10.")
	private String empPincode;
	
	@Column(nullable = false, length = 40)
	@NotBlank(message = "employee about must be mandtatory!..")
	@Length(max = 100,min = 3, message =  "Employee about must be start at least 3 character to 100.")
	private String empAbout;
}
