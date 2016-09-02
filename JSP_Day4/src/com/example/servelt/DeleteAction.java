package com.example.servelt;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.exception.UserNotFoundException;
import com.example.service.RegionService;
import com.example.service.RegionServiceStub;


public class DeleteAction implements Action  {
	
       

	public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String regionId = request.getParameter("regionId");
		
		RegionService service = RegionServiceStub.getRegionService();
		
		try {
			service.deleteRegion(Integer.parseInt(regionId));
			RequestDispatcher disp = request.getRequestDispatcher("./region/singleRegion.jsp");
			disp.forward(request, response);
		} catch (NumberFormatException | UserNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		
	
	}


}
