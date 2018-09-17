package com.fa.utils;

import java.util.regex.Pattern;

public class ValidationData {
	/**
	 * @param birthDate
	 * @return
	 */
	public static boolean checkBirthDate(String birthDate) {
		return Pattern.matches("^[\\d]{2}/[\\d]{2}/[\\d]{4}$", birthDate);
	}
	
	public static boolean checkEmail(String email) {
		return Pattern.matches("^[0-9a-zA-Z]+@(gmail|email).(com|vn)$", email);
	}
	
	public static boolean checkPhone(String phone) {
		return Pattern.matches("^[0-9]{7,12}$", phone);
	}
	
}
