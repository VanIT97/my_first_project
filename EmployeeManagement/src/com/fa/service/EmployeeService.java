package com.fa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import com.fa.dao.EmployeeDao;
import com.fa.entity.Employee;
import com.fa.entity.HourlyEmployee;
import com.fa.entity.SalariedEmployee;
import com.fa.utils.ValidationData;

public class EmployeeService {
	private EmployeeDao employeeDao;
	public EmployeeService() {
		employeeDao=new EmployeeDao();
	}
	
	/**
	 * create a new Emp
	 */
	public void inputEmployee() {
		Scanner sc=new Scanner(System.in);
		Employee employee;
		System.out.println("input type of Employee,press 1: salariedEmployee, other: hourlyEmoloyee");
		int option=sc.nextInt();
		if(option==1) {
			employee=new SalariedEmployee();
		}else {
			employee=new HourlyEmployee();
		}
		System.out.println("ssn:");
		employee.setSsn(sc.nextLine());
		System.out.println("firstName:");
		employee.setFirstName(sc.nextLine());
		System.out.println("lastName:");
		employee.setLastName(sc.nextLine());
		boolean check=false;
		String phone;
		do{
			System.out.println("phone:");
			phone=sc.nextLine();
			if(ValidationData.checkPhone(phone)) {
				check=true;
				employee.setPhone(phone);
			}
			if(check==false) {
				System.out.println("input phone:");
			}
		}while(check==false);
		
		System.out.println("email:");
		employee.setEmail(sc.nextLine());
		System.out.println("birthDate:");
		employee.setBirthDate(sc.nextLine());
		if(employee instanceof SalariedEmployee) {
			SalariedEmployee salariedEmployee=(SalariedEmployee) employee;
			System.out.println("commisionRate:");
			salariedEmployee.setCommisionRate(sc.nextDouble());
			System.out.println("grossSale:");
			salariedEmployee.setGrossSale(sc.nextDouble());
			System.out.println("basicSalary:");
			salariedEmployee.setBasicSalary(sc.nextDouble()); 
			employeeDao.createEmployee(salariedEmployee);
		}else {
			HourlyEmployee hourlyEmployee=(HourlyEmployee) employee;
			System.out.println("wage:");
			hourlyEmployee.setWage(sc.nextDouble());
			System.out.println("workingHours:");
			hourlyEmployee.setWorkingHours(sc.nextDouble());
			employeeDao.createEmployee(hourlyEmployee);
		}
	}
	
	/**
	 * display all employee
	 */
	public void displayAllEmployee() {
		for(Employee employee:employeeDao.getAllEmployee()) {
			employee.display();
		}
	}
	private void displayListEmp(List<Employee> listEmp) {
		for(Employee employee:listEmp) {
			employee.display();
		}
	}
	public void classifyEmployee() {
		List<Employee> listSalariedEmp=new ArrayList<>();
		List<Employee> listHourlyEmp=new ArrayList<>();
		for(Employee employee:employeeDao.getAllEmployee()) {
			if(employee instanceof SalariedEmployee) {
				listSalariedEmp.add(employee);
			}else {
				listHourlyEmp.add(employee);
			}
		}
		System.out.println("----------SalariedEmployee-----------");
		displayListEmp(listSalariedEmp);
		System.out.println("----------HourlyEmployee-----------");
		displayListEmp(listHourlyEmp);
	}
	
	public void findEmployeeByName() {
		Scanner sc=new Scanner(System.in);
		System.out.println("input name of Employee:");
		List<Employee> listOfEmployee= employeeDao.findEmloyeeByName(sc.nextLine());
		displayListEmp(listOfEmployee);
	}
}
