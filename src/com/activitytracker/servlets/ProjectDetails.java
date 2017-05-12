package com.activitytracker.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.activitytracker.constants.RequestParameters;
import com.activitytracker.delegates.ProjectDetailsFetcher;

import com.activitytracker.dto.ProjectDetailsResponse;
import java.util.logging.*;

/**
 * Servlet implementation class ProjectDetails
 */
public class ProjectDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger exceptionLogger = Logger.getLogger(ProjectDetails.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectDetails() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub

		int projectId = Integer.parseInt(request.getParameter(RequestParameters.PROJECT));
		ProjectDetailsResponse project = new ProjectDetailsResponse();
		project.setProjectId(projectId);
		
		try {
			project = ProjectDetailsFetcher.populateProjectDetails(project);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			exceptionLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
			exceptionLogger.log(Level.SEVERE, e.getMessage(), e);
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		
		request.setAttribute(RequestParameters.PROJECT, project);
		RequestDispatcher rd = request.getRequestDispatcher("/pages/projectdetailspage.jsp");
		rd.forward(request, response);

	}

}
