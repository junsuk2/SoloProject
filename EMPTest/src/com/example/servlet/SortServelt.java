package com.example.servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dto.Employee;
import com.example.service.EmpServiceDao;
import com.example.service.EmpServiceDaoImpl;

/**
 * Servlet implementation class SortServelt
 */
@WebServlet("/SortServelt")
public class SortServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmpServiceDao service = EmpServiceDaoImpl.getService();
		String sort = request.getParameter("range");
		List<Employee> employees = null;

		if (sort.equals("down")) {
			employees = service.getAllEmployeeByAsc();
		} else {
			employees = service.getAllEmployeeByDesc();
		}

		request.setAttribute("employees", employees);
		RequestDispatcher disp = request.getRequestDispatcher("./list.jsp");
		disp.forward(request, response);

		/*
		 * List<Employee> employees =
		 * EmpServiceDaoImpl.getService().getAllEmployee(); String sort =
		 * request.getParameter("range"); request.setAttribute("employees",
		 * employees);
		 * 
		 * if (sort.equals("up")) { Comparator<Employee> comparator = new
		 * Comparator<Employee>() { public int compare(Employee p1, Employee p2)
		 * { return
		 * String.valueOf(p2.getSalary()).compareTo(String.valueOf(p1.getSalary(
		 * ))); } };
		 * 
		 * Collections.sort(employees, comparator); } else {
		 * Comparator<Employee> comparator = new Comparator<Employee>() { public
		 * int compare(Employee p1, Employee p2) { return
		 * String.valueOf(p1.getSalary()).compareTo(String.valueOf(p2.getSalary(
		 * ))); } }; Collections.sort(employees, comparator); }
		 */

	/*	RequestDispatcher disp = request.getRequestDispatcher("./list.jsp");
		disp.forward(request, response);*/

	}

}
