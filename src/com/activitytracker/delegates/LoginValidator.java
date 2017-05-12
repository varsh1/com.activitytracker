package com.activitytracker.delegates;
import com.activitytracker.dto.*;
import com.activitytracker.utilities.*;
import com.activitytracker.constants.*;
import com.activitytracker.dao.EmployeeAccount;

public class LoginValidator {

	public static EmployeeDetailsResponse validateLogin(UserLogin userlogin) {
		
		EmployeeDetailsResponse employeedetails = EmployeeAccount.checkIfEmployeeExists(userlogin);
		return employeedetails;
	}
	
	public static String validateCredentials(UserLogin userlogin) {
		
		if(!InputValidator.emailValidate(userlogin.getUserName())) {
			return ErrorMessages.INVALID_EMAIL_MESSAGE;
		}
		if(InputValidator.passwordValidate(userlogin.getPassword())) {
			return ErrorMessages.INVALID_PASSWORD_MESSAGE;
		}
		return "";
	}
	
	public static String userDoesNotExists() {
		return ErrorMessages.USER_NOT_FOUND;
	}
}
