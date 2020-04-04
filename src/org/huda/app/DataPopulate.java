package org.huda.app;

import org.huda.dao.EmployeeDao;
import org.huda.model.Address;
import org.huda.model.Department;
import org.huda.model.Employee;
import org.huda.model.Skill;

public class DataPopulate {
	
	public static void main(String[] args) {
		Skill skill1 = addNewSkill("Talent Hunting");
		Skill skill2 = addNewSkill("Resource Management");
		Address address1 = addNewAddress("Carl-Schüler Str. 7", "Berlin", "10455", "Germany");
		Address address2 = addNewAddress("Maximilianstr. 24", "Berlin", "10762", "Germany");
		Employee employee1 = addNewEmployee("Merry", "Jane", "merry_jane@gmail.com");
		employee1.setAddress(address1);
		employee1.setSkills(skill1);
		Employee employee2 = addNewEmployee("Max", "Fowler", "max_fowler@hotmail.com");
		employee2.setAddress(address2);
		employee2.setSkills(skill1);
		employee2.setSkills(skill2);
		
		Department dept = addNewDepartment("HR", "Manages human resources");
		dept.setEmployees(employee1);
		dept.setEmployees(employee2);
		
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.persistObject(dept);
		employeeDao.persistObject(employee1);
		employeeDao.persistObject(employee2);
	}
	
	
	public static Skill addNewSkill(String name) {
		Skill skill = new Skill();
		skill.setSkillName(name);
		return skill;
	}
	
	public static Address addNewAddress(String street, String city, String zipCode, String country){
		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setZipCode(zipCode);
		address.setCountry(country);
		return address;
	}
	
	public static Employee addNewEmployee(String firstName, String lastName, String email) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		return employee;
	}
	
	public static Department addNewDepartment(String deptName, String deptDesc) {
		Department dept = new Department();
		dept.setDepartmentName(deptName);
		dept.setDepartmentDesc(deptDesc);
		return dept;
	}

}
