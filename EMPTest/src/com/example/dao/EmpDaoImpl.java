package com.example.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.dto.Employee;

public class EmpDaoImpl implements EmpDao {
	String EMPLOYEE_NS = "com.example.employeeMapper.";
	
	@Override
	public List<Employee> getAllEmployee(SqlSession session) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<>();
		String stmt = EMPLOYEE_NS+"selectAll";
		list = session.selectList(stmt);
		return list;
	}

	@Override
	public int insertEmployee(SqlSession session, Employee employee) {
		// TODO Auto-generated method stub	
		String stmt = EMPLOYEE_NS+"insertEmployee";
		return session.insert(stmt,employee);

	}

	@Override
	public Employee getEmployeeById(SqlSession session, int employeeId) {
		// TODO Auto-generated method stub
		String stmt = EMPLOYEE_NS+"selectById";
		return session.selectOne(stmt,employeeId);
	
	}

	@Override
	public int updateEmployee(SqlSession session, Employee employee) {
		// TODO Auto-generated method stub
		String stmt = EMPLOYEE_NS+"updateEmployee";
		return session.update(stmt,employee);
	}

	@Override
	public int deleteEmployee(SqlSession session, int employeeId) {
		String stmt = EMPLOYEE_NS+"deleteEmployee";
		return session.delete(stmt,employeeId);
	}

	@Override
	public List<Employee> searchByDate(SqlSession session, String hireDate) {
		// TODO Auto-generated method stub
		String stmt = EMPLOYEE_NS+"sortByDate";
		return session.selectList(stmt,hireDate);
	}

	@Override
	public List<Employee> searchById(SqlSession session, String email) {
		// TODO Auto-generated method stub
		String stmt = EMPLOYEE_NS+"sortById";
		return session.selectList(stmt,email);
	}

	@Override
	public List<Employee> getAllEmployeeByAsc(SqlSession session) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<>();
		String stmt = EMPLOYEE_NS+"selectAllbyAsc";
		list = session.selectList(stmt);
		return list;
	}

	@Override
	public List<Employee> getAllEmployeeByDesc(SqlSession session) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<>();
		String stmt = EMPLOYEE_NS+"selectAllbyDesc";
		list = session.selectList(stmt);
		return list;
	}


}
