package service;

import java.util.List;
import java.util.Scanner;

import dao.DepartmentDao;
import entity.Department;
import utils.ValidationData;

public class DepartmentService {
	private DepartmentDao departmentDao;
	public DepartmentService() {
		departmentDao=new DepartmentDao();
	}
	
	/**
	 * add new department by input data from keyboard and save into file
	 */
	public void addNewDepartment() {
		Department department=new Department();
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String departmentId="";
		do {
			System.out.println("Please enter the id:");
			departmentId=sc.nextLine();
		}while(!ValidationData.checkIdDepartment(departmentId));
		department.setId(departmentId);
		System.out.println("Please enter the name:");
		department.setName(sc.nextLine());
		System.out.println("Please enter the domain:");
		department.setDomain(sc.nextLine());
		departmentDao.createDepartment(department);
	}
	
	/**
	 * search department by name
	 */
	public void searchDepartmentByName() {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String departmentName="";
		System.out.println("Please enter the name:");
		departmentName=sc.nextLine();
		List<Department> listDepartment=departmentDao.findDepartmentByName(departmentName);
		if(listDepartment.isEmpty()) {
			System.out.println("there is not any department in database!");
		}else {
			for(Department dep:listDepartment) {
				System.out.println(dep.toString());
			}
		}
	}
}
