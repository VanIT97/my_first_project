package service;

import java.util.Scanner;

import dao.BMIDao;

/**
 * @author du du
 * this class provides many funtion bussiness logic for object bmi
 */
public class BMIService {
	private BMIDao bmiDao;
	public BMIService() {
		bmiDao=new BMIDao();
	}
	/**
	 * function requirement for calculate
	 */
	public void calculateBMI() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		boolean check=true;
		do {
			try {
				System.out.println("input weight:");
				double weight=Double.parseDouble(sc.nextLine());
				System.out.println("input height:");
				double height=Double.parseDouble(sc.nextLine());
				System.out.println("BMI digit:"+bmiDao.calculateBMI(weight, height));
				check=true;
			} catch (NumberFormatException e) {
				System.out.println("please input a number!");
				check=false;
			}
		} while (check==false);
	}
}
