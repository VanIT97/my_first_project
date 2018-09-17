package main;

import service.StudentService;

public class Test {
	public static void main(String[] args) {
		StudentService studentService=new StudentService();
//		studentService.displayAnEmployee();
//		studentService.displayAllStudent();
		studentService.createNewStudent(); 
	}
}
