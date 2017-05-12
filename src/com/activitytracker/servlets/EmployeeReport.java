package com.activitytracker.servlets;

import java.io.IOException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.activitytracker.constants.ErrorMessages;
import com.activitytracker.constants.RequestParameters;
import com.activitytracker.delegates.EmployeeTaskFetcherForProject;
import com.activitytracker.dto.EmployeeTaskDetails;
import com.google.gson.Gson;

/**
 * Servlet implementation class EmployeeReport
 */
public class EmployeeReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Logger exceptionLogger = Logger.getLogger(EmployeeReport.class.getName());
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		Gson gson = new Gson();
		int employeeId = Integer.parseInt(request.getParameter(RequestParameters.EMPLOYEEID));
		ArrayList<EmployeeTaskDetails> employeetaskList;
		try {
			
			employeetaskList = EmployeeTaskFetcherForProject.getTasksForEmployee(employeeId);
			String employeetaskdetails = gson.toJson(employeetaskList);
			response.getWriter().println(employeetaskdetails);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			exceptionLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
			exceptionLogger.log(Level.SEVERE, e.getMessage(), e);
			exceptionLogger.info(e.getStackTrace().toString());
			e.printStackTrace();
			
			response.getWriter().println(ErrorMessages.INTERNAL_ERROR);
		}
		
	}

}
