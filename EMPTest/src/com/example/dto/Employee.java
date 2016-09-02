package com.example.dto;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee{
	private int employeeId;
	private String email;
	private Date hireDate;
	private String jobId;
	private String jobTitle;
	private int salary;

	public Employee(String email, String jobId) {
		this.email = email;
		this.jobId = jobId;
	}

	public Employee(String jobId, int salary, int employeeId) {
		this.jobId = jobId;
		this.salary = salary;
		this.employeeId = employeeId;
	}


}
