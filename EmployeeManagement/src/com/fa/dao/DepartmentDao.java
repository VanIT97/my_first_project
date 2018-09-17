package com.fa.dao;

import java.util.List;

import com.fa.entity.Department;
import com.fa.entity.Employee;

public class DepartmentDao {
	private List<Department> listOfDepartment;
	
	/**
	 * @param nameOfDep
	 * @return 
	 */
	public List<Employee> getEmployeeByNameOfDeparment(String nameOfDep){
		Department dep=null;
		for(Department department:this.listOfDepartment) {
			if(department.getDepartmentName().equals(nameOfDep)) {
				dep=department;
				break;
			}
		}
		return dep.getListOfEmployee();
	}
	/**
	 * @param employee
	 * @param department
	 * add a new employee into a department
	 */
	public void addEmployeeIntoDeparment(Employee employee, Department department) {
		List<Employee> listEmp=department.getListOfEmployee();
		listEmp.add(employee);
		department.setListOfEmployee(listEmp);
	}
}
