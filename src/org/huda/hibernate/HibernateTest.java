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
		vehicle.setVehicleName("Any Vehicle");
		
		TwoWheeler vehicle2 = new TwoWheeler();
		vehicle2.setVehicleName("Bike");
		vehicle2.setSteeringHandle("Bike steering handle");
		
		FourWheeler vehicle3 = new FourWheeler();
		vehicle3.setVehicleName("Car");
		vehicle3.setSteeringWheel("Car steering wheel");
		
		user.setVehicle(vehicle);
		user.setVehicle(vehicle2);
		user.setVehicle(vehicle3);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.save(vehicle1);
		session.save(vehicle2);
		session.save(vehicle3);
		session.getTransaction().commit();
		session.close();
	}
}