package org.huda.app;

import java.util.List;
import org.huda.dao.EmployeeHQLDao;
import org.huda.model.Employee;
import org.huda.model.Skill;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class HibernateHQLTest {
	
	public static void main(String[] args) {
		EmployeeHQLDao employeeHQLDao = new EmployeeHQLDao();
		
		// Retrieving all the employees
		List<Employee> listOfEmployees = employeeHQLDao.getAllEmployees();
		print(listOfEmployees);
		
		// Retrieving employee email by last name
		employeeHQLDao.getEmployeeEmailByLastName("Smith");
		
		// Retrieving street names
		List<String> listOfStreetNames = employeeHQLDao.getStreetNamesByCity("Bayreuth");
		printAListOfStrings(listOfStreetNames);
		
		// Retrieving skill names by id
		employeeHQLDao.getSkillNameById(3);
		
		// Retrieving all the skills names
		List<Skill> listOfSkills = employeeHQLDao.getAllSkills();
		print(listOfSkills);
		
		// Retrieving a department name by its id
		employeeHQLDao.getDepartmentIdByName();
		
		// Retrieving the names of all the employees under the department with id = 1 
		List<String> listOfEmployeeNames = employeeHQLDao.getAllEmployeeNamesOfADepartment(1);
		printAListOfStrings(listOfEmployeeNames);
		
		// Updating the email address of an employee by his/her id
		employeeHQLDao.updateEmployeeEmailById("john.smith@hotmail.com", 2);
		
		// Deleting an employee by its id
//		employeeHQLDao.deleteEmployeeById(7);
//		employeeHQLDao.deleteEmployeeById(8);
	}
	

	public static <T> void print(List<T> list) {
		for(T c : list) {
			System.out.println(c.toString());
		}
	}
	
	public static void printAListOfStrings(List<String> listOfStrings) {
		for(String e : listOfStrings) {
			System.out.println(e);
		}
	}
}
