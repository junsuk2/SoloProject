package com.example.servlet;

import java.io.IOException;
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
import com.example.service.EmpServiceDao;
import com.example.service.EmpServiceDaoImpl;

/**
 * Servlet implementation class EmpUpdateServlet
 */
@WebServlet("/EmpUpdateServlet")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = LoggerFactory.getLogger(EmpUpdateServlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpServiceDao service = EmpServiceDaoImpl.getService();
		String jobId = request.getParameter("job");
		String salary = request.getParameter("salary");
		String employeeId = request.getParameter("employeeId");
		logger.trace(employeeId);
		int result = service.updateEmployee(jobId,Integer.parseInt(salary), Integer.parseInt(employeeId));

		if (result == 1) {
			List<Employee> employees = EmpServiceDaoImpl.getService().getAllEmployee();
			request.setAttribute("employees", employees);
			RequestDispatcher disp = request.getRequestDispatcher("./list.jsp");
			disp.forward(request, response);
		}
	}

}
