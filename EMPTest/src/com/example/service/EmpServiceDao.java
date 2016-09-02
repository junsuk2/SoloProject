package com.example.service;

import java.util.Date;
import java.util.List;

import com.example.dto.Employee;


public interface EmpServiceDao {

	List<Employee> getAllEmployee();
	
	int insertEmployee(String email, String jobId);
	
	Employee getEmployeeById(int employeeId);
	
	int updateEmployee(String jobId, int salary, int employeeId);
	
	int deleteEmployee(int employeeId);
	
	List<Employee> searchByDate(String hireDate);
	
	List<Employee> searchById(String email);
	
	List<Employee> getAllEmployeeByAsc();
	List<Employee> getAllEmployeeByDesc();
}
