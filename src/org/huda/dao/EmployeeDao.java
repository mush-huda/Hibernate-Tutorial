package org.huda.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.huda.dto.Address;
import org.huda.dto.Department;
import org.huda.dto.Employee;
import org.huda.util.HibernateUtil;

public class EmployeeDao {

//	private Transaction transaction = null;
	
	public void saveObject(Object object) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(object);
			transaction.commit();
		} catch (Exception e) {
			if (transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Employee getUser(int employeeId) {
		Transaction transaction = null;
		Employee user = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			user = (Employee) session.get(Employee.class, employeeId);
			transaction.commit();
			return user;
		} catch (Exception e) {
			if (transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}

	public void updateUserEmail(int employeeId, String newEmail) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Employee user = getUser(employeeId);
			user.setEmail(newEmail);
			session.update(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteUser(int employeeId) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Employee user = getUser(employeeId);
			session.delete(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}