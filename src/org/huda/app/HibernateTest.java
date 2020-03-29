package org.huda.app;

import org.huda.dao.EmployeeDao;
import org.huda.dto.Address;
import org.huda.dto.Department;
import org.huda.dto.Employee;
import org.huda.dto.Skill;

public class HibernateTest {

	public static void main(String[] args) {

		EmployeeDao employeeDao = new EmployeeDao();
		
		// creating user
		Skill skill1 = new Skill();
		skill1.setSkillName("Java");
		Skill skill2 = new Skill();
		skill2.setSkillName("Spring");
		Skill skill3 = new Skill();
		skill3.setSkillName("Hibernate");
		Skill skill4 = new Skill();
		skill4.setSkillName("Thymeleaf");
		Skill skill5 = new Skill();
		skill5.setSkillName("Docker");
		
		
		Address address1 = new Address();
		address1.setStreet("Wiesenstr. 17");
		address1.setCity("Bayreuth");
		address1.setZipCode("95444");
		address1.setCountry("Germany");
		
		
		Employee employee1 = new Employee();
		employee1.setFirstName("Mushfiqul");
		employee1.setLastName("Huda");
		employee1.setEmail("mushfiqul.onee@gmail.com");
		employee1.setAddress(address1);
		employee1.setSkills(skill1);
		employee1.setSkills(skill2);
		employee1.setSkills(skill3);
		
		
		//creating another user
		Address address2 = new Address();
		address2.setStreet("Blinking street");
		address2.setCity("London");
		address2.setZipCode("U13-780");
		address2.setCountry("England");
		
		
		Employee employee2 = new Employee();
		employee2.setFirstName("John");
		employee2.setLastName("Smith");
		employee2.setEmail("john.smith@gmail.com");
		employee2.setAddress(address2);
		employee2.setSkills(skill1);
		employee2.setSkills(skill3);
		employee2.setSkills(skill5);
		
		
		skill1.setEmployees(employee1);
		skill1.setEmployees(employee2);
		skill2.setEmployees(employee1);
		skill3.setEmployees(employee1);
		skill3.setEmployees(employee2);
		skill5.setEmployees(employee2);
		
		
		Department dept1 = new Department();
		dept1.setDepartmentName("Development");
		dept1.setDepartmentDesc("Turns coffee into code");
		dept1.setEmployees(employee1);
		dept1.setEmployees(employee2);
//		employeeDao.saveDepartment(dept1);

		
		employeeDao.saveObject(address1);
		employeeDao.saveObject(address2);
		employeeDao.saveObject(skill1);
		employeeDao.saveObject(skill2);
		employeeDao.saveObject(skill3);
//		employeeDao.saveObject(skill4);
		employeeDao.saveObject(skill5);
		employeeDao.saveObject(employee1);
		employeeDao.saveObject(employee2);
		employeeDao.saveObject(dept1);
		
		// retrieving user
//		Employee employee = (Employee) employeeDao.getUser(1);
//		System.out.println(employee.toString());

		// updating user
//		employeeDao.updateUserEmail(1, "mushfiqul.onee@gmail.com");

		// retrieving user
//		employee = (Employee) employeeDao.getUser(1);
//		System.out.println(employee.toString());

		//deleting user
//		employeeDao.deleteUser(2);
	}
}