package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MultipartConfig(location = "c:\\Temp", maxFileSize = 900000)

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	static Logger logger = LoggerFactory.getLogger(UploadServlet.class);
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// charset 설정
		request.setCharacterEncoding("utf-8");

		// 일반적인 파라미터 조회
		String desc1 = request.getParameter("desc1");
		String desc2 = request.getParameter("desc2");
		logger.trace("desc1: {}, desc2: {}", desc1, desc2);
		// multipart 파라미터 조회
		Part part = request.getPart("file1");
		String fileName = handlePart(part);
		handlePart(request.getPart("file2"));
		
		response.setContentType("text/html;charset=utf-8");
		String img = "<img src='/JSP_Day5/upload/"+fileName+"'>";
		response.getWriter().append(img);
	}

	private String handlePart(Part part) throws IOException {
		String fileName=null;
		if (part != null) {
			fileName = part.getSubmittedFileName();
			if (fileName.trim().length() > 0) {
				String name = part.getName();
				long size = part.getSize();
				String contentType = part.getContentType();
				logger.trace("name : {} , fileName : {} , size : {} , contentType : {}", name, fileName, size,
						contentType);
				part.write(fileName);
			}
		}
		return fileName;
	}
}
