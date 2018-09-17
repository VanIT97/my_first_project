package entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee implements Serializable{
	private String id;
	private String title;
	private String fullName;
	private String domain;
	private String poistion;
	private float monthSalary;
	private String  departmentId;
	
	public Employee() {
		super();
	}
	public Employee(String id) {
		super();
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getPoistion() {
		return poistion;
	}
	public void setPoistion(String poistion) {
		this.poistion = poistion;
	}
	public float getMonthSalary() {
		return monthSalary;
	}
	public void setMonthSalary(float monthSalary) {
		this.monthSalary = monthSalary;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", title=" + title + ", fullName=" + fullName + ", domain=" + domain
				+ ", poistion=" + poistion + ", monthSalary=" + monthSalary + ", departmentId=" + departmentId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
