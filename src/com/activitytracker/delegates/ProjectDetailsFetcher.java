package com.activitytracker.delegates;


import java.util.logging.Level;
import java.util.logging.Logger;

import com.activitytracker.dao.ProjectDetails;
import com.activitytracker.dto.*;


public class ProjectDetailsFetcher {
	private final static Logger log = Logger.getLogger(ProjectDetailsFetcher.class.getName());
	private final static Logger exceptionLogger = Logger.getLogger(ProjectDetailsFetcher.class.getName());

	public static ProjectDetailsResponse populateProjectDetails(ProjectDetailsResponse projectdetails)throws Exception {
		try {
			projectdetails = ProjectDetails.getProjectDetails(projectdetails.getProjectId());
			String managerName = getManagerName(projectdetails.getManagerId());
			projectdetails.setManagerName(managerName);
			log.info(managerName);
			
		} catch (Exception e) {
			exceptionLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
			exceptionLogger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		}

		return projectdetails;
	}

	public static String getManagerName(int mangerEmployeeId) throws Exception {
		String managerName = null;
		try {
			managerName = ProjectDetails.getManagerName(mangerEmployeeId);
		}
		catch(Exception e) {
			exceptionLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
			exceptionLogger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		}
		return managerName;

	}
}
