package org.huda.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.huda.dao.EmployeeDao;
import org.huda.model.Address;
import org.huda.model.Department;
import org.huda.model.Employee;
import org.huda.model.Skill;
import org.huda.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		
//		populateData();
		
		EmployeeDao employeeDao = new EmployeeDao();
		
		// retrieving user
		Employee employee = employeeDao.getObject(Employee.class, 1);
		System.out.println(employee.toString());
		System.out.println(employee.getAddress().toString());
		employee = employeeDao.getObject(Employee.class, 2);
		System.out.println(employee.toString());
		System.out.println(employee.getAddress().toString());
		
		// retrieving address
		Address address = employeeDao.getObject(Address.class, 1);
		System.out.println(address.toString());
		
		// retrieving a single skill
		Skill skill = employeeDao.getObject(Skill.class, 2);
		System.out.println(skill.toString());
		System.out.println("Employees that obtain this skill: ");
		
		// retrieving a skill and the list of employees who obtain that skill. 
		// it has to be done in a single transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Skill skill2 = session.get(Skill.class, 1);
		System.out.println(skill2.toString());
		System.out.println("Employees that obtain this skill: ");
		List<Employee> listOfEmployees = skill2.getEmployees();
		for(Employee e : listOfEmployees) {
			System.out.println(e.getFirstName() + " " + e.getLastName());
		}
		session.getTransaction().commit();
		
		
		// retrieving a single department
		Department dept = employeeDao.getObject(Department.class, 1);
		System.out.println(dept.toString());

		// retrieving a department and the employees who work under that department.
		// it has to be done in a single transaction
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Department dept2 = session.get(Department.class, 1);
		System.out.println(dept2.toString());
		System.out.println("Employees that work under this department: ");
		List<Employee> listOfEmp = dept2.getEmployees();
		for(Employee e : listOfEmp) {
			System.out.println(e.getFirstName() + " " + e.getLastName());
		}
		session.getTransaction().commit();
		
		
//		// updating user
		employeeDao.updateUserEmail(1, "mushfiqul.onee@yahoo.com");
//		// showing that user has been updated
		employee = employeeDao.getObject(Employee.class, 1);
		System.out.println(employee.toString());
		
		//deleting user
//		employeeDao.deleteObject(Employee.class, 9);
//		employeeDao.deleteObject(Employee.class, 10);
//		employeeDao.deleteObject(Department.class, 5);
//		employeeDao.deleteObject(Skill.class, 11);
//		employeeDao.deleteObject(Skill.class, 12);
		
	}
	
	public static void populateData() {
		
		EmployeeDao employeeDao = new EmployeeDao();
		
		// creating skills
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
		
		// creating addresses
		Address address1 = new Address();
		address1.setStreet("Wiesenstr. 17");
		address1.setCity("Bayreuth");
		address1.setZipCode("95444");
		address1.setCountry("Germany");
		
		Address address2 = new Address();
		address2.setStreet("Blinking street");
		address2.setCity("London");
		address2.setZipCode("U13-780");
		address2.setCountry("England");
		
		// creating employees
		Employee employee1 = new Employee();
		employee1.setFirstName("Mushfiqul");
		employee1.setLastName("Huda");
		employee1.setEmail("mushfiqul.onee@gmail.com");
		// setting address to employee(one-to-one)
		employee1.setAddress(address1);
		//	setting skills to employee (many-to-many)
		employee1.setSkills(skill1);
		employee1.setSkills(skill2);
		employee1.setSkills(skill3);
		
		Employee employee2 = new Employee();
		employee2.setFirstName("John");
		employee2.setLastName("Smith");
		employee2.setEmail("john.smith@gmail.com");
		employee2.setAddress(address2);
		employee2.setSkills(skill1);
		employee2.setSkills(skill3);
		employee2.setSkills(skill5);
		
		// setting employees to department (one-to-many)
		Department dept1 = new Department();
		dept1.setDepartmentName("Development");
		dept1.setDepartmentDesc("Turns coffee into code");
		dept1.setEmployees(employee1);
		dept1.setEmployees(employee2);
		
//		// saving all the created objects		
		employeeDao.saveObject(dept1);
		employeeDao.persistObject(employee1);
		employeeDao.persistObject(employee2);
	}
	
}