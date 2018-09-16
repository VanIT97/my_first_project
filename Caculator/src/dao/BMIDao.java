package dao;

import common.BMI;

public class BMIDao {
	/**
	 * @param weight: input from keybord weight of person 
	 * @param height:  input from keybord height of person 
	 * @return status of person which responsible with BMI's status
	 */
	public BMI calculateBMI(double weight, double height) {
		double indexBMI = weight / height;
		if (indexBMI < 19) {
			return BMI.THIN;
		} else if (indexBMI >= 19 && indexBMI <= 25) {
			return BMI.STANDARD;
		} else if (indexBMI > 25 && indexBMI <= 30) {
			return BMI.FAT;
		} else if (indexBMI > 30 && indexBMI <= 40) {
			return BMI.VERYFAT;
		} else {
			return BMI.VERYFAT2;
		}
	}
}
