package dao;

import java.util.ArrayList;
import java.util.List;

import common.FileDirectory;
import database.FileIO;
import entity.Employee;

public class EmployeeDao {
	/**
	 * @return all employee from File .dat
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeFromFile() {
		List<Employee> allEmployee = new ArrayList<>();
		if (FileIO.checkData(FileDirectory.FileData.FILE_EMPLOYEE)) {
			allEmployee = (List<Employee>) FileIO.readFile(FileDirectory.FileData.FILE_EMPLOYEE);
		}
		return allEmployee;
	}

	/*
	 * save an employee into file
	 */
	public void createEmployee(Employee employee) {
		List<Employee> listEmployee = getEmployeeFromFile();
		listEmployee.add(employee);
		FileIO.saveFile(listEmployee, FileDirectory.FileData.FILE_EMPLOYEE);
	}

	/*
	 * update an employee into department and update into file
	 */
	public void updateEmployee(Employee employee) {
		List<Employee> listEmployee = getEmployeeFromFile();
		int indexOfEmployee = listEmployee.indexOf(employee);
		listEmployee.set(indexOfEmployee, employee);
		FileIO.saveFile(listEmployee, FileDirectory.FileData.FILE_EMPLOYEE);
	}

	/*
	 * get an Employee from file by Id
	 */
	public Employee getEmployeeById(String id) {
		List<Employee> listEmployee = getEmployeeFromFile();
		int index = listEmployee.indexOf(new Employee(id));
		if (index >= 0) {
			return listEmployee.get(index);
		}
		return null;
	}
}
