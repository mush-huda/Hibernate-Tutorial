package org.huda.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.huda.dto.*;

public class HibernateTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query<Vehicle> query = session.createQuery("from Vehicle as v where vehicleId>1");

		List<Vehicle> veh = query.list();
		session.getTransaction().commit();
		session.close();
		
		for(Vehicle v : veh)
			System.out.println(v.getVehicleName());		
	}
}