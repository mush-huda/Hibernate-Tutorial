package org.huda.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.huda.dto.*;

public class HibernateTest {

	public static void main(String[] args) {
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Audi");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("BMW");
		
		UserDetails user = new UserDetails();
		user.setUserName("Mushfiqul");
		
		user.setVehicleList(vehicle1);
		user.setVehicleList(vehicle2);
		
		vehicle1.setUserList(user);
		vehicle2.setUserList(user);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
	}
}