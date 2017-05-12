package com.activitytracker.delegates;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.activitytracker.dao.EmployeeTaskDetailsForProject;
import com.activitytracker.dto.EmployeeTaskDetails;

public class AddTaskForEmployee {
	private static Logger exceptionLogger = Logger.getLogger(AddTaskForEmployee.class.getName());
	public static void addTasksForEmployee(EmployeeTaskDetails employeetasks) throws Exception {
		try {
			EmployeeTaskDetailsForProject.addTasksForEmployee(employeetasks);
		}
		catch(Exception e) {
			exceptionLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
			exceptionLogger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		}
	}
}
