package com.example.servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dto.Region;
import com.example.exception.DuplicationException;
import com.example.service.RegionService;
import com.example.service.RegionServiceStub;

public class AddRegionAction implements Action {
	static Logger logger = LoggerFactory.getLogger(AddRegionAction.class);

	@Override
	public void doService(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String regionId = request.getParameter("regionId");
		String regionName = request.getParameter("regionName");

		// 2. Region 객체 생성
		Region region = new Region(Integer.parseInt(regionId), regionName);

		// 3. region을 이용해서 service 호출
		RegionService service = RegionServiceStub.getRegionService();

		try {
			int result = service.addRegion(region);
			// 4. result가 1--> 성공 --> session처리
			if (result == 1) {
				HttpSession session = request.getSession();
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}
		} catch (DuplicationException e) {
			logger.error("Region 추가 오류", e);
			throw new ServletException(e);
		}
	}
}
