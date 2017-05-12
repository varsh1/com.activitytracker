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
 * Servlet implementation class ManagerDashBoard
 */
public class ProjectReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger exceptionLogger = Logger.getLogger(ProjectReport.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectReport() {
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
			//EmployeeDetailsResponse employeedetails = (EmployeeDetailsResponse) request.getSession(false).getAttribute("employeeresponseobject");
			int projectId = Integer.parseInt(request.getParameter(RequestParameters.PROJECT));
			ArrayList<EmployeeTaskDetails> taskList;
			try {
				
				taskList = EmployeeTaskFetcherForProject.getTasksForProject(projectId);
				String projecttaskdetails = gson.toJson(taskList);
				response.getWriter().println(projecttaskdetails);
				
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
