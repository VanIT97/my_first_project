package service;

import java.util.Scanner;

import common.Operator;
import dao.CalculatorDao;

public class CalculatorService {
	private CalculatorDao calculatorDao;

	public CalculatorService() {
		calculatorDao = new CalculatorDao();
	}

	/**
	 * function requiment of calculate
	 */
	@SuppressWarnings("resource")
	public void calculateNomal() {
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		double firstNumber;
		double secondNumber;
		double memory = 0;
		System.out.println("input number:");
		firstNumber = Double.parseDouble(sc.nextLine());
		do {
			try {
				System.out.println("input operation:");
				String operatorInput = sc.nextLine();
				if (operatorInput.equals("=")) {
					memory=firstNumber;
					System.out.println("result:" + memory);
					check = true;
				} else {
					Operator operator = checkOperator(operatorInput);
					if (operator != null) {
						System.out.println("input number:");
						secondNumber = Double.parseDouble(sc.nextLine());
						memory = calculatorDao.calculate(firstNumber, operator, secondNumber);
						firstNumber=memory;
						System.out.println("memory:" + memory);
					} else {
						System.out.println("Please input operator(+,-,*,/)");
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("please input a number!");
			}
		} while (check == false);
	}

	private Operator checkOperator(String input) {
		switch (input) {
		case "+":
			return Operator.PLUS;
		case "-":
			return Operator.MINUS;
		case "*":
			return Operator.MULTI;
		case "/":
			return Operator.DIVIDE;
		default:
			return null;
		}
	}
}
