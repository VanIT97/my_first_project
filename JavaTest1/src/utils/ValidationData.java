package utils;

import java.util.regex.Pattern;

public class ValidationData {
	public static boolean checkIdEmployee(String employeeId) {
		return Pattern.matches("^EM[0-9]{5}$", employeeId);
	}
	public static boolean checkIdDepartment(String departmentId) {
		return Pattern.matches("^DE[0-9]{5}$", departmentId);
	}
}
