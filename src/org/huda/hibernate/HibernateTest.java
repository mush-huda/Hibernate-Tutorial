package org.huda.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.huda.dto.*;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserName("Mushfiqul");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Audi");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("BMW");
		
		user.setVehicle(vehicle);
		user.setVehicle(vehicle2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
	}
}