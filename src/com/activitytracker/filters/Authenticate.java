package com.activitytracker.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.activitytracker.dto.EmployeeDetailsResponse;
import java.util.logging.*;

/**
 * Servlet Filter implementation class Authenticate
 */
public class Authenticate implements Filter {
	private static Logger log = Logger.getLogger(Authenticate.class.getName());

	/**
	 * Default constructor.
	 */
	public Authenticate() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI().substring(req.getContextPath().length());
		log.info(req.getContextPath());
		log.info(path);
		if( path.indexOf("/images") > 0){
	        chain.doFilter(request, response);
		}
		 if( path.indexOf("/js") > 0){
		        chain.doFilter(request, response);
		    }
		if (!path.toLowerCase().contains("login") && !path.equals("/")) {
			HttpSession session = req.getSession(false);
			EmployeeDetailsResponse employeedetails = (EmployeeDetailsResponse) session.getAttribute("employeeresponseobject");
			if (employeedetails == null) {
				RequestDispatcher rd = req.getRequestDispatcher("/pages/login.jsp");
				rd.forward(req, response);

			} else {

				chain.doFilter(request, response);
			}
		}
		// pass the request along the filter chain
		else {

			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
