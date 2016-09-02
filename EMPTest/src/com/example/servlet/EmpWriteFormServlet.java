package com.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.dto.Employee;
import com.example.service.EmpServiceDao;
import com.example.service.EmpServiceDaoImpl;

/**
 * Servlet implementation class EmpWriteFormServlet
 */
@WebServlet("/EmpWriteFormServlet")
public class EmpWriteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpServiceDao service = EmpServiceDaoImpl.getService();
		String email = request.getParameter("employeeName");
		String jobId = request.getParameter("job");
		
		HttpSession session = request.getSession();
		int result = service.insertEmployee(email, jobId);
		if(result ==1){
			List<Employee> employees = EmpServiceDaoImpl.getService().getAllEmployee();
			request.setAttribute("employees", employees);
			RequestDispatcher disp = request.getRequestDispatcher("./list.jsp");
			disp.forward(request, response);
		}
		
		
		
	}

}
