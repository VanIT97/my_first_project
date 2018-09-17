package service;

import java.util.List;
import java.util.Scanner;

import dao.DepartmentDao;
import dao.EmployeeDao;
import entity.Department;
import entity.Employee;
import utils.ValidationData;

public class EmployeeService {
	private EmployeeDao employeeDao;
	private DepartmentDao departmentDao;

	public EmployeeService() {
		employeeDao = new EmployeeDao();
		departmentDao = new DepartmentDao();
	}

	/**
	 * add new employee
	 */
	public void addNewEmployee() {
		Employee employee = new Employee();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String idEmployee = null;
		do {
			System.out.println("please enter id:");
			idEmployee = sc.nextLine();
		} while (!ValidationData.checkIdEmployee(idEmployee));
		employee.setId(idEmployee);
		System.out.println("please enter the title:");
		employee.setTitle(sc.nextLine());
		System.out.println("please enter the fullName:");
		employee.setFullName(sc.nextLine());
		System.out.println("please enter the domain:");
		employee.setDomain(sc.nextLine());
		System.out.println("please enter the position:");
		employee.setPoistion(sc.nextLine());
		System.out.println("please enter the month salary:");
		employee.setMonthSalary(sc.nextFloat());
		employeeDao.createEmployee(employee);
	}

	/**
	 * Add one or more existed employee(s) to the department
	 */
	public void addEmployeeIntoDepartment() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number employee:");
		int number = sc.nextInt();
		Employee employee;
		String idEmployee = null;
		for (int i = 0; i < number; i++) {
			do {
				System.out.println("please enter id:");
				idEmployee = sc.nextLine();
			} while (!ValidationData.checkIdEmployee(idEmployee));
			employee = employeeDao.getEmployeeById(idEmployee);
			if (employee != null) {
				System.out.println("please enter the departmentId:");
				Department department = departmentDao.getDepartmentById(sc.nextLine());
				if (department != null) {
					employee.setDepartmentId(department.getId());
					employeeDao.updateEmployee(employee);
				} else {
					System.out.println("id department is not exist!");
				}
			} else {
				System.out.println("id employee is not exist!");
			}
		}
	}

	/**
	 * remove one employee from a department, by employee id
	 */
	public void removeEmployeeFromDepartment() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the id Employee:");
		Employee employee = employeeDao.getEmployeeById(sc.nextLine());
		employee.setDepartmentId(null);
		employeeDao.updateEmployee(employee);
	}

	/**
	 * Display list of all employees with its department ID
	 */
	public void displayAllEmployee() {
		List<Employee> listEmployee = employeeDao.getEmployeeFromFile();
		for (Employee employee : listEmployee) {
			if (employee.getDepartmentId() != null) {
				System.out.println(employee.toString());
			}
		}
	}
}
