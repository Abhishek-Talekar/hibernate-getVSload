package com.gvl.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gvl.entities.IPerson;
import com.gvl.entities.Person;
import com.gvl.registries.SessionFactoryRegistry;

import javassist.tools.rmi.ObjectNotFoundException;

public class GVLTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryRegistry.getSessionFactory();
		Session session = sessionFactory.openSession();

		// savePerson(session);

		IPerson person = session.load(IPerson.class, 2);
		//session.close();
		
		System.out.println(person.getAge());
		System.out.println(person.getClass().getCanonicalName());
		

	}

	public static void savePerson(Session session) {
		Transaction transaction = null;
		boolean flag = false;
		try {
			Person person = new Person();
			transaction = session.beginTransaction();
			person.setPersonId(2);
			person.setPersonName("Rohit");
			person.setPersonSurname("Pawar");
			person.setAge(29);
			person.setEmailAddress("rohitpawar469@gmail.com");
			person.setMobileNumber("12314325");

			session.save(person);
			flag = true;
		} finally {
			if (session != null) {
				if (flag == true) {
					transaction.commit();
				}
			} else {
				transaction.rollback();
			}
		}
	}
}
