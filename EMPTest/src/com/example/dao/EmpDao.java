package com.example.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.dto.Employee;

public interface EmpDao {

	List<Employee> getAllEmployee(SqlSession session);
	
	int insertEmployee(SqlSession session, Employee employee);
	
	Employee getEmployeeById(SqlSession session, int employeeId);
	
	int updateEmployee(SqlSession session,Employee employee);
	
	int deleteEmployee(SqlSession session, int employeeId);
	
	List<Employee> searchByDate(SqlSession session, String hireDate);
	
	List<Employee> searchById(SqlSession session, String email);
	
	List<Employee> getAllEmployeeByAsc(SqlSession session);
	
	List<Employee> getAllEmployeeByDesc(SqlSession session);
}
