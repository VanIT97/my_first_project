package com.fa.main;

import java.util.Scanner;

import com.fa.service.EmployeeService;

public class Main {
	public static void main(String[] args) {
		EmployeeService employeeService=new EmployeeService();
		int condition=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("--------Start Program-----");
		do {
			System.out.println("1.input employee");
			System.out.println("2.display all employee");
			System.out.println("3.classify employee");
			System.out.println("4.find employee by name:");
			System.out.println("other.exit program:");
			condition=sc.nextInt();
			switch (condition) {
			case 1:
				employeeService.inputEmployee();
				break;
			case 2:
				employeeService.displayAllEmployee();
				break;
			case 3:
				employeeService.classifyEmployee();
				break;
			case 4:
				employeeService.findEmployeeByName();
				break;
			default:
				break;
			}
		} while (condition>=1 && condition<=4);
		
	}
}
