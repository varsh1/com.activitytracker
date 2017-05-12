package com.activitytracker.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.activitytracker.constants.RequestParameters;
import com.activitytracker.delegates.EmployeeDetailsFetcher;
import com.activitytracker.delegates.LoginValidator;
import com.activitytracker.dto.EmployeeDetailsResponse;
import com.activitytracker.dto.UserLogin;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger exceptionLogger = Logger.getLogger(Login.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			UserLogin login = new UserLogin();
			String userName = request.getParameter(RequestParameters.USERNAME);
			String password = request.getParameter(RequestParameters.PASSWORD);
			login.setUserName(userName);
			login.setPassword(password);

			EmployeeDetailsResponse employeedetailsobj = LoginValidator.validateLogin(login);
			if (employeedetailsobj == null) {

				request.setAttribute(RequestParameters.ERROR, LoginValidator.userDoesNotExists());
				RequestDispatcher rd = request.getRequestDispatcher("/pages/login.jsp");
				rd.forward(request, response);

			} else {
				HttpSession session = request.getSession();
				employeedetailsobj = EmployeeDetailsFetcher.populateEmployeeResponseObject(employeedetailsobj);

				session.setAttribute(RequestParameters.EMPLOYEERESPONSE, employeedetailsobj);
				String username = employeedetailsobj.getEmployeeName();
				session.setAttribute(RequestParameters.USERNAME, username);
				if (!employeedetailsobj.getRoleName().contains(RequestParameters.MANAGER)) {

					response.sendRedirect(request.getContextPath() + "/pages/employeedashboard.jsp");

				} else {

					response.sendRedirect(request.getContextPath() + "/pages/managerdashboard.jsp");
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			exceptionLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
			exceptionLogger.log(Level.SEVERE, e.getMessage(), e);
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);

		}
	}

}
