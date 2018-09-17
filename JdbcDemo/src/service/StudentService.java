package service;

import java.util.List;
import java.util.Scanner;

import dao.StudentDao;
import entity.Student;

public class StudentService {
	private StudentDao studentDao;

	public StudentService() {
		studentDao = new StudentDao();
	}

	public void displayAnEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter id:");
		Student student = studentDao.getEmployeeById(sc.nextInt());
		if (student != null) {
			System.out.println(student.toString());
		} else {
			System.out.println("this student is not exist!");
		}

	}

	public void displayAllStudent() {
		List<Student> listStudent = studentDao.getAllStudent();
		if (listStudent.isEmpty()) {
			System.out.println("data is empty!");
		} else {
			for (Student student : listStudent) {
				System.out.println(student.toString());
			}
		}
	}

	public void createNewStudent() {
		Student student = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter name:");
		student.setNameStudent(sc.nextLine());
		System.out.println("please enter age:");
		student.setAge(sc.nextInt());
		if(studentDao.insertStudent(student)) {
			System.out.println("completely created!");
		}else {
			System.out.println("fail created!");
		}
	}
}
