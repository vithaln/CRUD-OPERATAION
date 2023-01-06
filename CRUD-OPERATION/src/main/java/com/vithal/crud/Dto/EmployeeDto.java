package com.vithal.crud.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {

	private String empId;
	private String empFirstname;
	private String empMiddlename;
	private String empLastname;
	private String empEmail;
	private String empPassword;
	private long empMobilenumber;
	private String empCountry;
	private String empState;
	private String empDistrict;
	private String empTaluk;
	private String empPincode;
	private String empAbout;
}
