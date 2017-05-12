package com.activitytracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.activitytracker.constants.DatabaseFields;
import com.activitytracker.constants.DatabaseQueries;

import com.activitytracker.dto.TaskDetailsResponse;
import com.activitytracker.utilities.*;

public class TaskDetails {

	public static ArrayList<TaskDetailsResponse> getAllTasks(String term) {
		ResultSet rs = null;
		PreparedStatement preparedstatement = null;
		Connection con = DatabaseUtils.getConnection();

		ArrayList<TaskDetailsResponse> taskList = new ArrayList<TaskDetailsResponse>();
		try {
			preparedstatement = con.prepareStatement(DatabaseQueries.SELECT_TASK_DETAILS);
			preparedstatement.setString(1, term + "%");
			rs = preparedstatement.executeQuery();
			while (rs.next()) {
				TaskDetailsResponse task = new TaskDetailsResponse();
				int taskId = rs.getInt(DatabaseFields.TASK_ID);
				String taskName = rs.getString(DatabaseFields.TASK_NAME);
				task.setTaskId(taskId);
				task.setTaskName(taskName);
				taskList.add(task);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseUtils.closeResultSet(rs);
			DatabaseUtils.closePreparedStatement(preparedstatement);
			DatabaseUtils.closeConnection(con);
		}

		return taskList;
	}
}
