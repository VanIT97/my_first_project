package entity;

public class Employee {
	private int id;
	private String nameEmp;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameEmp() {
		return nameEmp;
	}

	public void setNameEmp(String nameEmp) {
		this.nameEmp = nameEmp;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", nameEmp=" + nameEmp + ", age=" + age + "]";
	}

}
