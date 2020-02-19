package com.gvl.registries;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryRegistry {
	private static SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new MetadataSources()
					.buildMetadata(new StandardServiceRegistryBuilder().configure().build()).buildSessionFactory();

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
