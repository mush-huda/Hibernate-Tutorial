package org.huda.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.huda.model.Address;
import org.huda.model.Department;
import org.huda.model.Employee;
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
	
	public void persistObject(Object object) {
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(object);
			transaction.commit();
		} catch (Exception e) {
			if (transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public <T> T getObject(Class<T> className, int key) {
		Transaction transaction = null;
		T dbObject = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			dbObject = className.cast(session.get(className, key));
			transaction.commit();
			return dbObject;
		} catch (Exception e) {
			if (transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return dbObject;
	}
		

	public void updateUserEmail(int employeeId, String newEmail) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Employee employee = getObject(Employee.class, employeeId);
			employee.setEmail(newEmail);
			session.update(employee);
			transaction.commit();
		} catch (Exception e) {
			if (transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public <T> void deleteObject(Class<T> className, int employeeId) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.delete(getObject(className, employeeId));
			transaction.commit();
		} catch (Exception e) {
			if (transaction == null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}