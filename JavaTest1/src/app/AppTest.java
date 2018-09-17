package app;

import java.util.Scanner;

import service.DepartmentService;
import service.EmployeeService;

public class AppTest {
	private DepartmentService departmentService;
	private EmployeeService employeeService;

	public AppTest() {
		departmentService = new DepartmentService();
		employeeService = new EmployeeService();
	}

	private void createUI() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Start program!");
		int select;
		do {
			System.out.println("1.Add new department!");
			System.out.println("2.Search departments, selected by department name!");
			System.out.println("3.Add new employee!");
			System.out.println("4.Add one or more existed employee to the department!");
			System.out.println("5.Display list of all employees with its department ID");
			select = sc.nextInt();
			switch (select) {
			case 1:
				departmentService.addNewDepartment();
				break;
			case 2:
				departmentService.searchDepartmentByName();
				break;
			case 3:
				employeeService.addNewEmployee();
				break;
			case 4:
				employeeService.addEmployeeIntoDepartment();
				break;
			case 5:
				employeeService.displayAllEmployee();
			default:
				break;
			}
		} while (select >= 1 && select < 6);
	}

	public static void main(String[] args) {
		AppTest appTest = new AppTest();
		appTest.createUI();
	}
}
