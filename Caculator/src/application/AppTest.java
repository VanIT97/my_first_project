package application;

import java.util.Scanner;

import service.BMIService;
import service.CalculatorService;

public class AppTest {
	private static BMIService bmiService;
	private static CalculatorService calculatorService;
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		bmiService=new BMIService();
		calculatorService=new CalculatorService();
		Scanner sc=new Scanner(System.in);
		int select;
		do {
			System.out.println("1.calculator, 2.BMI, other.EXIT");
			select=sc.nextInt();
			switch (select) {
			case 1:
				calculatorService.calculateNomal();
				break;
			case 2:
				bmiService.calculateBMI();
				break;	
			default:
				break;
			}
		} while (select==1 || select==2);
	}
}
