package com.example.servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dto.Region;
import com.example.exception.UserNotFoundException;
import com.example.service.RegionService;
import com.example.service.RegionServiceStub;

/**
 * Servlet implementation class GetRegionServlet
 */
@WebServlet("/getRegion")
public class LoginServlet extends HttpServlet {
	static Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.parameter에서 regionId, regionName 확보
		String regionId = request.getParameter("regionId");
		String regionName = request.getParameter("regionName");
		//2.regionId를 이용해서 service를 호출
		RegionService service = RegionServiceStub.getRegionService();
		try {
			Region region = service.getRegion(Integer.parseInt(regionId));
			if(region.getRegionName().equals(regionName)){
				//3.region이 있다면 세션에 담고 --> index.jsp로 이동
				HttpSession session = request.getSession();
				session.setAttribute("region", region);
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}else{
				throw new UserNotFoundException(Integer.parseInt(regionId));
			}			
		} catch (NumberFormatException | UserNotFoundException e) {
			//4. 예외 발생 시 처리 --> servletException으로 전달
			logger.error("Region 조회 오류",e);
			throw new ServletException(e);
		}

		 
	}

}
