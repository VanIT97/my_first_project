package com.fa.dao;

import java.util.ArrayList;
import java.util.List;

import com.fa.entity.Employee;

public class EmployeeDao {
	private List<Employee> listOfEmployee;
	public EmployeeDao() {
		listOfEmployee=new ArrayList<>();
	}
	/**
	 * @param employee: input data from keyborad
	 * create a new employee and save into listEmployee
	 */
	public void createEmployee(Employee employee) {
		listOfEmployee.add(employee);
	}
	/**
	 * @param name
	 * @return
	 */
	public List<Employee> findEmloyeeByName(String name){
		List<Employee> listEmp=new ArrayList<>();
		for(Employee employee:this.listOfEmployee) {
			if(employee.getLastName().equals(name)) {
				listEmp.add(employee);
			}
		}
		return listEmp;
	}
	/**
	 * @return
	 */
	public List<Employee> getAllEmployee(){
		return this.listOfEmployee;
	}
}
