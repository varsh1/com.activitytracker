package com.activitytracker.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseUtils {

	private static final String driverClass = "com.mysql.jdbc.Driver";
	// private static final String classnotfoundExceptionString =// "Could not find the class";
	private static final String dbURL = "jdbc:mysql://localhost:3306/company";
	private static final String dbuserName = "root";
	private static final String dbPassword = "Zilker@123";

	// private static final String sqlExceptionMessage = "SQL exception occured";

	/**
	 * @return the driverclass
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			con = (Connection) DriverManager.getConnection(DatabaseUtils.dbURL, DatabaseUtils.dbuserName,DatabaseUtils.dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeResultSet(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeStatement(Statement s) {
		try {
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closePreparedStatement(PreparedStatement preparedstatement1) {
		try {
			preparedstatement1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeDatabaseResources(ResultSet rs,PreparedStatement preparedstatement,Connection con) {
		if(rs!=null) {
		closeResultSet(rs);
		}
		closePreparedStatement(preparedstatement);
		closeConnection(con);
	}
}

