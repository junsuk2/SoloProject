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
import com.google.gson.Gson;

/**
 * Servlet implementation class EmpSearchServlet
 */
@WebServlet("/EmpSearchServlet")
public class EmpSearchServlet extends HttpServlet {
	static Logger logger = LoggerFactory.getLogger(EmpSearchServlet.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpServiceDao service = EmpServiceDaoImpl.getService();
		String search = request.getParameter("search");
		String menu = request.getParameter("menu");
		String salary= request.getParameter("salary");
		List<Employee> employees = null;
		
		if(menu.equals("이름")){
		employees = service.searchById(search);
		}else{
		employees = service.searchByDate(search);
		}
		
/*		String data = request.getParameter("data");
		logger.trace("employees : {}",employees);
		Gson gson = new Gson();
		Employee fromClient = gson.fromJson(data, Employee.class);
		logger.trace("email : {}, employeeId :{}",fromClient.getEmail(),fromClient.getEmployeeId());
		String gsonType=gson.toJson(fromClient);
		logger.trace("jsonType:{}",gsonType);*/
		
		request.setAttribute("employees", employees);
		RequestDispatcher disp = request.getRequestDispatcher("./list.jsp");
		disp.forward(request, response);
	}

}
