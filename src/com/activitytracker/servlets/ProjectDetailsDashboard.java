package com.activitytracker.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.activitytracker.dto.*;
import com.activitytracker.constants.RequestParameters;
import com.activitytracker.delegates.*;

/**
 * Servlet implementation class ProjectDetailsDashboard
 */
public class ProjectDetailsDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectDetailsDashboard() {
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
		EmployeeDetailsResponse employeeresponseobj = (EmployeeDetailsResponse) request.getSession(false).getAttribute("employeeresponseobject");
		ArrayList<ProjectDetailsResponse> projectList = employeeresponseobj.getProjectList();
		int projectId = Integer.parseInt(request.getParameter(RequestParameters.PROJECT));
		ProjectDetailsResponse project = EmployeeDetailsFetcher.getProjectDetailsFromEmployeeObject(projectId, projectList);
		request.setAttribute(RequestParameters.PROJECT, project);
		RequestDispatcher rd = request.getRequestDispatcher("/pages/projectdashboardemployee.jsp");
		rd.forward(request, response);
		
	}

}
