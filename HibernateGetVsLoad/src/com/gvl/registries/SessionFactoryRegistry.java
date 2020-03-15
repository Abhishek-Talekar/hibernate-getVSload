package com.gvl.registries;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryRegistry {
	public static SessionFactory sessionFactory;

	static {
		try {
			Map<String, String> settings = new HashMap();
			settings.put("connection.driver_class", "com.mysql.cj.jdbc.Driver");
			settings.put("connection.url", "jdbc:mysql://localhost:3306/common");
			settings.put("connection.username", "root");
			settings.put("connection.password", "root123");
			settings.put("show_sql", "true");
			settings.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
			settings.put("class", "com.hano.entities.Person");

			sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().applySettings(settings).build())
					.buildMetadata().buildSessionFactory();
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
