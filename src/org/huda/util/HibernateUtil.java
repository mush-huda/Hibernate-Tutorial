package org.huda.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {

			try {
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
				return sessionFactory;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
