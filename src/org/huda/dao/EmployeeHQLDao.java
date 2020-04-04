package org.huda.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.huda.model.Address;
import org.huda.model.Employee;
import org.huda.model.Skill;
import org.huda.util.HibernateUtil;

public class EmployeeHQLDao {

	//Working
	public List<Employee> getAllEmployees() {
		Transaction transaction = null;
		List<Employee> listOfEmployees = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			Query<Employee> query = session.createQuery("from org.huda.model.Employee", Employee.class);
			listOfEmployees = query.list();
			transaction.commit();
		} catch(Exception e) {
			if(transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfEmployees;
	}
	
	// Working
	public void getEmployeeEmailByLastName(String lastName) {
		Transaction transaction = null;
		String email = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			String hql = "select e.email from org.huda.model.Employee e where e.lastName=:name";
			Query<String> query = session.createQuery(hql, String.class);
			query.setParameter("name", lastName);
			email = query.uniqueResult();
			transaction.commit();
		} catch(Exception e) {
			if(transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		System.out.println("The email of " + lastName + " is: " + email);
	}
	
	// Working
	public List<String> getStreetNamesByCity(String cityName) {
		Transaction transaction = null;
		List<String> listOfStreets = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			Query<String> query = session.createQuery("select a.street from Address a where a.city=:name", String.class);
			query.setParameter("name", cityName);
			listOfStreets = query.list();
			transaction.commit();
		} catch(Exception e) {
			if(transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfStreets;
	}
	

	//Working
	public void getSkillNameById(int id) {
		Transaction transaction = null;
		String skillName = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			String hql = "select skillName from Skill where skillId=:id";
			Query<String> query = session.createQuery(hql, String.class);
			query.setParameter("id", id);
			skillName = query.uniqueResult();
			transaction.commit();
		} catch(Exception e) {
			if(transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		System.out.println(skillName);
	}
	
	//Working
	public List<Skill> getAllSkills() {
		Transaction transaction = null;
		List<Skill> listOfSkills = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			Query<Skill> query = session.createQuery("from Skill", Skill.class);
			listOfSkills = query.list();
			transaction.commit();
		} catch(Exception e) {
			if(transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfSkills;
	}
	
	//Working
	public void getDepartmentIdByName() {
		Transaction transaction = null;
		int departmentId = 0;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			String hql = "select departmentId from Department where departmentName='Development'";
			Query<Integer> query = session.createQuery(hql, Integer.class);
			departmentId = query.uniqueResult();
			transaction.commit();
		} catch(Exception e) {
			if(transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		System.out.println("The department id of the Development department is: " + departmentId);
	}
	
	//Joining Tables
	public List<String> getAllEmployeeNamesOfADepartment(int deptId) {
		Transaction transaction = null;
		List<String> listOfNames = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			//TODO: paramaterize the class
			//TODO: return employee instead of firstName
			String hql = "select e.firstName"
					+ " from org.huda.model.Employee e"
					+ " right join e.department d"
					+ " where d.departmentId=:id";
		Query<String> query = session.createQuery(hql, String.class);
		query.setParameter("id", deptId);
		listOfNames = query.list();
		transaction.commit();
		} catch(Exception e) {
			if(transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfNames;
	}
	
	public void updateEmployeeEmailById(String newEmail, int employeeId) {
		Transaction transaction = null;
		int rowsUpdated = 0;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			Query query = session.createQuery("update org.huda.model.Employee e set e.email=:email where e.employeeId=:id");
			query.setParameter("email", newEmail);
			query.setParameter("id", employeeId);
			rowsUpdated = query.executeUpdate();
			transaction.commit();
		} catch(Exception e) {
			if(transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		System.out.println(rowsUpdated + "row(s) updated");
	}

	// Done
	public int updateZipCodeByCity(String zip, String city) {
		Transaction transaction = null;
		int rowsAffected = 0;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			Query query = session.createQuery("update Address a set a.zipCode=:zip where a.city=:name");
			query.setParameter("name", city);
			query.setParameter("zip", "zip");
			rowsAffected = query.executeUpdate();
			transaction.commit();
			return rowsAffected;
		} catch(Exception e) {
			if(transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	
	public void deleteEmployeeById(int id) {
		Transaction transaction = null;
		int rowsDeleted = 0;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete from org.huda.model.Employee e where e.employeeId=:id");
			query.setParameter("id", id);
			rowsDeleted = query.executeUpdate();
			transaction.commit();
		} catch(Exception e) {
			if(transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		String output = (rowsDeleted > 0) ? rowsDeleted + "row(s) were deleted." : "No rows could be deleted";
		
		System.out.println(output);
	}
	
//	public void templateMethod() {
//		Transaction transaction = null;
//		
//		try(Session session = HibernateUtil.getSessionFactory().openSession()){
//			transaction = session.beginTransaction();
//			
//			transaction.commit();
//			
//		} catch(Exception e) {
//			if(transaction == null) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
//	}

}
