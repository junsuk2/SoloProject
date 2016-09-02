package com.example.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.example.dao.EmpDao;
import com.example.dao.EmpDaoImpl;
import com.example.dto.Employee;
import com.example.util.myBatisUtil;

public class EmpServiceDaoImpl implements EmpServiceDao {
	private EmpServiceDaoImpl() {
	}

	private static EmpServiceDaoImpl instance = new EmpServiceDaoImpl();

	public static EmpServiceDaoImpl getService() {
		return instance;
	}

	EmpDao dao = new EmpDaoImpl();

	@Override
	public List<Employee> getAllEmployee() {
		try (SqlSession session = myBatisUtil.getInstance().getSession()) {
			return dao.getAllEmployee(session);
		}
	}

	@Override
	public int insertEmployee(String email, String jobId) {
		int result = -1;
		try (SqlSession session = myBatisUtil.getInstance().getSession()) {
			Employee employee = new Employee(email, jobId);
			result = dao.insertEmployee(session, employee);
			if (result == 1) {
				session.commit();
			}
			return result;
		}
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		try (SqlSession session = myBatisUtil.getInstance().getSession()) {
			Employee employee = dao.getEmployeeById(session, employeeId);
			return employee;
		}
	}

	@Override
	public int updateEmployee(String jobId, int salary, int employeeId) {
		// TODO Auto-generated method stub
		int result = -1;
		try (SqlSession session = myBatisUtil.getInstance().getSession()) {
			Employee employee = new Employee(jobId, salary, employeeId);
			result = dao.updateEmployee(session, employee);
			if (result == 1) {
				session.commit();

			}
			return result;
		}
	}

	@Override
	public int deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		int result = -1;
		try (SqlSession session = myBatisUtil.getInstance().getSession()) {
			result = dao.deleteEmployee(session, employeeId);
			if (result == 1) {
				session.commit();
			}
			return result;
		}
	}

	@Override
	public List<Employee> searchByDate(String hireDate) {
		List<Employee> list = new ArrayList<>();
		try (SqlSession session = myBatisUtil.getInstance().getSession()) {
			list = dao.searchByDate(session, hireDate);
		}
		return list;
	}

	@Override
	public List<Employee> searchById(String email) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<>();
		try (SqlSession session = myBatisUtil.getInstance().getSession()) {
			list = dao.searchById(session, email);
		}
		return list;
	}

	@Override
	public List<Employee> getAllEmployeeByAsc() {
		// TODO Auto-generated method stub
		try (SqlSession session = myBatisUtil.getInstance().getSession()) {
			return dao.getAllEmployeeByAsc(session);
		}
	}

	@Override
	public List<Employee> getAllEmployeeByDesc() {
		// TODO Auto-generated method stub
		try (SqlSession session = myBatisUtil.getInstance().getSession()) {
			return dao.getAllEmployeeByDesc(session);
		}
	}

}
