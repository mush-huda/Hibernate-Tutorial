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
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
//		user.setVehicle(vehicle);
//		user.setVehicle(vehicle2);
		
		
		
		
		System.out.println("Starts");
		System.out.println(vehicle.getVehicleId());
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
		Session session = sessionFactory.openSession();
		
		System.out.println("Session created");
		session.beginTransaction();
		session.save(user);
		System.out.println("User saved");
		System.out.println(user.getUserName());
		session.save(vehicle);
		System.out.println("Vehicle 1 saved");
		System.out.println(vehicle.getVehicleName());
		System.out.println(vehicle.getVehicleId());
		session.save(vehicle2);
		System.out.println("Vehicle 2 saved");
		System.out.println(vehicle2.getVehicleName());
		System.out.println(vehicle2.getVehicleId());
		session.getTransaction().commit();
		System.out.println("Commit");
		session.close();
	}
}