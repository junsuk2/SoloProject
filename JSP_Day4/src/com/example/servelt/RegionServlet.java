package com.example.servelt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.example.dto.Region;
import com.example.service.RegionServiceStub;
import com.example.util.myBatisUtil;

/**
 * Servlet implementation class RegionServlet
 */
@WebServlet("/region")
public class RegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Region> regions = RegionServiceStub.getRegionService().getAllRegion();
		request.setAttribute("regions", regions);
		
		RequestDispatcher disp = request.getRequestDispatcher("./region.jsp");
		disp.forward(request, response);
		
	}



}
