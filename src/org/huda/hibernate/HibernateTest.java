package org.huda.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.huda.dto.*;

public class HibernateTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Vehicle.class);
		criteria.add(Restrictions.eq("vehicleName", "Car"));

		List<Vehicle> veh = (List<Vehicle>)criteria.list();

		session.getTransaction().commit();
		session.close();
		
		for(Vehicle v : veh)
			System.out.println(v.getVehicleName());		
	}
}