package com.example.servelt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dto.Region;
import com.example.exception.UserNotFoundException;
import com.example.service.RegionService;
import com.example.service.RegionServiceStub;

/**
 * Servlet implementation class getRegionServlet
 */
@WebServlet("/get")
public class getRegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String regionId = request.getParameter("regionId");
		RegionService service = RegionServiceStub.getRegionService();
		
		try {
			Region region = service.getRegion(Integer.parseInt(regionId));
			request.setAttribute("regionId", region.getRegionId());
			request.setAttribute("regionName", region.getRegionName());
			RequestDispatcher disp = request.getRequestDispatcher("./region/singleRegion.jsp");
			disp.forward(request, response);
		} catch (NumberFormatException | UserNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
	}

}
