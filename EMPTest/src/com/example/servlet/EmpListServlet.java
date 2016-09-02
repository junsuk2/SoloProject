package com.example.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dto.Employee;
import com.example.service.EmpServiceDaoImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/EmpListServlet")
public class EmpListServlet extends HttpServlet {
	static Logger logger = LoggerFactory.getLogger(EmpListServlet.class);
	private static final long serialVersionUID = 1L;
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employees = EmpServiceDaoImpl.getService().getAllEmployee();
		request.setAttribute("employees", employees);
		RequestDispatcher disp = request.getRequestDispatcher("./list.jsp");
		disp.forward(request, response);
		
		

	}

	

}
