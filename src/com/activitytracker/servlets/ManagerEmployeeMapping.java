package com.activitytracker.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.activitytracker.dto.BasicEmployeeDetails;
import com.activitytracker.dto.EmployeeDetailsResponse;
import com.activitytracker.dto.ProjectDetailsResponse;
import com.google.gson.Gson;
import com.activitytracker.constants.RequestParameters;
import com.activitytracker.delegates.*;

/**
 * Servlet implementation class ManagerEmployeeMapping
 */
public class ManagerEmployeeMapping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerEmployeeMapping() {
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
		EmployeeDetailsResponse employeedetails = (EmployeeDetailsResponse) request.getSession(false).getAttribute(RequestParameters.EMPLOYEERESPONSE);
		int employeeId = employeedetails.getEmployeeId();
		ArrayList<ProjectDetailsResponse> projectList = employeedetails.getProjectList();
		HashSet<Integer> projectIdSet = new HashSet<Integer>();
		
		for(ProjectDetailsResponse project: projectList) {
			
			int projectId = project.getProjectId();
			projectIdSet.add(projectId);
		}
		
		HashSet<BasicEmployeeDetails>employeeSet = ManagerEmployeeMapper.getEmployeesUnderManager(employeeId, projectIdSet);
		String employee = gson.toJson(employeeSet);
		response.getWriter().print(employee);
	}

}
