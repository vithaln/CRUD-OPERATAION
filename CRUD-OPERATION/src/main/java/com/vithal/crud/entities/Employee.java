package com.vithal.crud.entities;

import jakarta.persistence.Column;
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
	@Column(nullable = false)
	private String empFirstname;
	@Column(nullable = false)
	private String empMiddlename;
	@Column(nullable = false)
	private String empLastname;
	@Column(unique = true)
	private String empEmail;
	@Column(nullable = false)
	private String empPassword;
	@Column(unique = true)
	private String empMobilenumber;
	@Column(nullable = false)
	private String empCountry;
	@Column(nullable = false)
	private String empState;
	@Column(nullable = false)
	private String empDistrict;
	@Column(nullable = false)
	private String empTaluk;
	@Column(nullable = false)
	private String empPincode;
	@Column(nullable = false)
	private String empAbout;

}
