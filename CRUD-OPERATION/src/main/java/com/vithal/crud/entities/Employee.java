package com.vithal.crud.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employess")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
	
	@Id
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
