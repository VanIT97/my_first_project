package dao;

import common.Operator;

public class CalculatorDao {
	/**
	 * @param firstNumber
	 * @param operator
	 * @param secondNumber
	 * @return result of operator
	 */
	public double calculate(double firstNumber, Operator operator, double secondNumber) {
		switch (operator) {
		case PLUS:
			return firstNumber + secondNumber;
		case MINUS:
			return firstNumber - secondNumber;
		case MULTI:
			return firstNumber * secondNumber;
		case DIVIDE:
			if(secondNumber==0) {
				try {
					throw new Exception("devide by zoro");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return firstNumber / secondNumber;
		default:
			return 0;
		}
	}

}
