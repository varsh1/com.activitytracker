package com.activitytracker.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

	public static boolean emailValidate(String email) {

		final Pattern EMAIL_REGEX_PATTERN = Pattern.compile("^[a-zA-Z0-9]+@[A-Za-z]+\\.[a-z]{2,3}$");
		Matcher matcher = EMAIL_REGEX_PATTERN.matcher(email);
		return matcher.find();
	}
	public static boolean passwordValidate(String password) {

		final Pattern PASSWORD_REGEX_PATTERN = Pattern.compile("^((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,})$");
		Matcher matcher = PASSWORD_REGEX_PATTERN.matcher(password);
		return matcher.find();
	}
}
