package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dto.Person;
import com.google.gson.Gson;

/**
 * Servlet implementation class GsonServlet
 */
@WebServlet("/gson")
public class GsonServlet extends HttpServlet {
	static Logger logger = LoggerFactory.getLogger(GsonServlet.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	String data = request.getParameter("data");
	logger.trace("param : {}", data);
	Gson gson = new Gson();
	Person fromClient = gson.fromJson(data, Person.class);
	logger.trace("name : {}, age: {}", fromClient.getName(),fromClient.getAge());
	fromClient.setAge(200);
	String jsonType = gson.toJson(fromClient);
	logger.trace("jsonType:{}",jsonType);
	response.getWriter().print(jsonType);
	}
	
}
