package com.example.servelt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.dto.Region;
import com.example.exception.UserNotFoundException;
import com.example.service.RegionService;
import com.example.service.RegionServiceStub;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String regionId= request.getParameter("regionId");
		String regionName = request.getParameter("regionName");
		
		RegionService service = RegionServiceStub.getRegionService();
		Region region = new Region(Integer.parseInt(regionId),regionName);
		try {
			int result = service.updateRegion(region);
			if(result==1){
				HttpSession session = request.getSession();
				request.setAttribute("regionId", region.getRegionId());
				request.setAttribute("regionName", region.getRegionName());
				RequestDispatcher disp = request.getRequestDispatcher("./region/singleRegion.jsp");
				disp.forward(request, response);
			}
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
	}



}
