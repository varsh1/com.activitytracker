package com.activitytracker.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.activitytracker.constants.RequestParameters;
import com.activitytracker.delegates.TaskDetailsFetcher;
import com.activitytracker.dto.TaskDetailsResponse;
import com.google.gson.Gson;

/**
 * Servlet implementation class TaskDetails
 */
public class TaskDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskDetails() {
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
		String term = request.getParameter(RequestParameters.TERM);
		ArrayList<TaskDetailsResponse> taskList = TaskDetailsFetcher.getTaskDetails(term);
		String taskDetails = gson.toJson(taskList);
		response.getWriter().println(taskDetails);
	}

}
