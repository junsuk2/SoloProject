package com.example.servlet;

import java.io.IOException;
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
 * Servlet implementation class EmpRetrieveServlet
 */
@WebServlet("/EmpRetrieveServlet")
public class EmpRetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpServiceDao service = EmpServiceDaoImpl.getService();
		
		String employeeId = request.getParameter("employeeId");
		
		Employee employees = service.getEmployeeById(Integer.parseInt(employeeId));
		
		request.setAttribute("employees", employees);
		
		
		RequestDispatcher disp = request.getRequestDispatcher("./retrieve.jsp");
		disp.forward(request, response);
		
	}

}
