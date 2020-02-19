package com.gvl.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gvl.entities.Person;
import com.gvl.registries.SessionFactoryRegistry;

public class GVLTest {

	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryRegistry.getSessionFactory();
		Session session = factory.openSession();
		storePerson(session);
		SessionFactoryRegistry.closeSessionFactory();
	}

	public static void storePerson(Session session) {
		Transaction transaction = null;
		boolean flag = false;
		try {
			Person person = new Person();
			transaction = session.beginTransaction();
			person.setPersonId(1);
			person.setPersonName("Abhi");
			person.setPersonSurname("Talekar");
			person.setAge(23);
			person.setEmailAddress("talekarabhishek41@gmail.com");
			person.setMobileNumber("9595503081");

			session.save(person);
			flag = true;

		} finally {
			if (session != null) {
				if (flag = true) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
		}
	}
}
