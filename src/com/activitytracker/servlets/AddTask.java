package com.activitytracker.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.activitytracker.constants.RequestParameters;
import com.activitytracker.delegates.AddTaskForEmployee;
import com.activitytracker.dto.EmployeeDetailsResponse;
import com.activitytracker.dto.EmployeeTaskDetails;

/**
 * Servlet implementation class AddTask
 */
public class AddTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger exceptionLogger = Logger.getLogger(AddTask.class.getName());
	private static Logger consoleLogger = Logger.getLogger(AddTask.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			EmployeeDetailsResponse employeedetails = (EmployeeDetailsResponse) request.getSession(false).getAttribute(RequestParameters.EMPLOYEERESPONSE);
			int employeeId = employeedetails.getEmployeeId();
			Date loggedDateFormatted = null;
			String projectId = request.getParameter(RequestParameters.PROJECT);
			String taskId = request.getParameter(RequestParameters.TASKID);
			String taskName = request.getParameter(RequestParameters.TASKNAME);
			String status = request.getParameter(RequestParameters.STATUS);
			String comments = request.getParameter(RequestParameters.COMMENTS);
			String estimatedTime = request.getParameter(RequestParameters.ESTIMATEDTIME);
			String hourslogged = request.getParameter(RequestParameters.HOURSLOGGED);
			String loggedDate = request.getParameter(RequestParameters.DATELOGGED);
			consoleLogger.info("Addtask date logged"+loggedDate.toString());
			SimpleDateFormat formatter = new SimpleDateFormat(RequestParameters.DATEFORMAT);
			try {
				loggedDateFormatted = formatter.parse(loggedDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			EmployeeTaskDetails employeetasks = new EmployeeTaskDetails();
			employeetasks.setProjectId(Integer.parseInt(projectId));
			employeetasks.setTaskId(Integer.parseInt(taskId));
			employeetasks.setTaskName(taskName);
			employeetasks.setStatus(status);
			employeetasks.setComments(comments);
			employeetasks.setEstimatedTime(Integer.parseInt(estimatedTime));
			employeetasks.setHoursLogged(Integer.parseInt(hourslogged));
			employeetasks.setLoggedDate(loggedDateFormatted);
			consoleLogger.info("Addtask"+loggedDateFormatted.toString());
			employeetasks.setAssignee(employeeId);

			AddTaskForEmployee.addTasksForEmployee(employeetasks);
			
			response.getWriter().println(RequestParameters.SUCCESS);

		} catch (Exception e) {
			
			exceptionLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
			exceptionLogger.log(Level.SEVERE, e.getMessage(), e);
			exceptionLogger.info(e.getStackTrace().toString());
			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.getWriter().println(errorMessage);
		}
	}

}
