package org.huda.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dept_id")
	private int departmentId;

	@Column(name = "dept_name")
	private String departmentName;

	@Column(name = "dept_desc")
	private String departmentDesc;

	@OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
	List<Employee> employees = new ArrayList<Employee>();

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDesc() {
		return departmentDesc;
	}

	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employee) {
		this.employees.add(employee);
		employee.setDepartment(this);
	}

	@Override
	public String toString() {
		return "\n" + "dept_id: " + this.getDepartmentId() + "\n" + "dept_name: " + this.getDepartmentName() + "\n"
				+ "dept_desc: " + this.getDepartmentDesc() + "\n";
	}
}
