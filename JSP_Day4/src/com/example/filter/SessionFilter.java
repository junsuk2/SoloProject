//package com.example.filter;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * Servlet Filter implementation class SessionFilter
// */
//@WebFilter("/region/*")
//public class SessionFilter implements Filter {
//
//    /**
//     * Default constructor. 
//     */
//    public SessionFilter() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		// TODO Auto-generated method stub
//		// place your code here
//		HttpSession session = ((HttpServletRequest)request).getSession();
//		Object region = session.getAttribute("region");
//		String path = "/index.jsp";
//		if(region==null){
//			RequestDispatcher disp = request.getRequestDispatcher(path);
//			disp.forward(request, response);
//		}else{
//			chain.doFilter(request, response);
//		}
//	}
//		// pass the request along the filter chain
//	
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//	}
//
//}
