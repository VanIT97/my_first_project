package com.fa.utils;

import java.util.regex.Pattern;

/**
 * @author du du
 * class provide many function to validate  input data from user
 */
public class ValidationData {
	/**
	 * @param idComputer: id of computer which user input from keyboard
	 * @return true if id is validate else return false
	 */
	public static boolean checkIdOfComputer(int idComputer) {
		return (idComputer < 10000 || idComputer > 99999) ? false : true;
	}

	/**
	 * @param locationOfComputer
	 * @return true if location is validate else return false
	 */
	public static boolean checkLocationOfComputer(String locationOfComputer) {
		return Pattern.matches("^FHO[0-9]{5}$", locationOfComputer) ? true : false;
	}
	
}
