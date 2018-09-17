package dao;

import java.util.ArrayList;
import java.util.List;

import common.FileDirectory;
import database.FileIO;
import entity.Department;

public class DepartmentDao {
	/**
	 * @return all employee from File .dat
	 */
	@SuppressWarnings("unchecked")
	public List<Department> getDepartmentFromFile() {
		List<Department> allDepartment = new ArrayList<>();
		if (FileIO.checkData(FileDirectory.FileData.FILE_DEPARTMENT)) {
			allDepartment = (List<Department>) FileIO.readFile(FileDirectory.FileData.FILE_DEPARTMENT);
		}
		return allDepartment;
	}

	/**
	 * @param Department
	 *            save an Department into file
	 */
	public void createDepartment(Department department) {
		List<Department> listDepartment = getDepartmentFromFile();
		listDepartment.add(department);
		FileIO.saveFile(listDepartment, FileDirectory.FileData.FILE_DEPARTMENT);
	}

	/**
	 * @param nameDepartment
	 * @return list department which have the same name
	 */
	public List<Department> findDepartmentByName(String nameDepartment) {
		List<Department> listDepartment = getDepartmentFromFile();
		List<Department> listDepartmentSameName = new ArrayList<>();
		for (Department department : listDepartment) {
			if (department.getName().equals(nameDepartment)) {
				listDepartmentSameName.add(department);
			}
		}
		return listDepartmentSameName;
	}

	/**
	 * @return a department in db
	 */
	public Department getDepartmentById(String id) {
		List<Department> listDepartment = getDepartmentFromFile();
		int index = listDepartment.indexOf(new Department(id));
		if (index >= 0) {
			return listDepartment.get(index);
		}
		return null;
	}
}
