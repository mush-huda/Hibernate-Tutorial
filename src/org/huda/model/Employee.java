package org.huda.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
	@ManyToOne
	@JoinColumn(name="fk_dept_id")
	private Department department;
	
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="employee_skills", joinColumns=@JoinColumn(name="fk_employee"), inverseJoinColumns=@JoinColumn(name="fk_skills"))
	private Set<Skill> skills = new HashSet<Skill>();
	

	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Skill skills) {
		this.skills.add(skills);
		skills.setEmployees(this);
	}
	
	
	@Override
	public String toString() {
		return "\n" + "user_id: " + this.getEmployeeId() + "\n" + "first_name: " 
				+ this.getFirstName() + "\n" + "last_name: " + this.getLastName() 
				+ "\n" + "email: " + this.getEmail() + "\n";
	}
	
}
