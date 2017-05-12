package com.activitytracker.delegates;

import java.util.ArrayList;

import com.activitytracker.dao.TaskDetails;
import com.activitytracker.dto.TaskDetailsResponse;

public class TaskDetailsFetcher {

	public static ArrayList<TaskDetailsResponse> getTaskDetails(String term) {
		
		ArrayList<TaskDetailsResponse> taskList = TaskDetails.getAllTasks(term);
		return taskList;
	}
}
