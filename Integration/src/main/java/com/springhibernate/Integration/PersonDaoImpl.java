package com.springhibernate.Integration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PersonDaoImpl implements PersonDao{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Person p) {
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
		// TODO Auto-generated method stub
		
	}

	public List<Person> list() {
		Session session=this.sessionFactory.openSession();
		List<Person> persons=session.createQuery("from Person").list();
		session.close();
		// TODO Auto-generated method stub
		return persons;
	}

	public void update() {
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Person person=(Person) session.get(Person.class,1);
		person.setName("mahendra");
		session.update(person);
		tx.commit();
		session.close();
		// TODO Auto-generated method stub
		
	}

	public void delete() {
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Person person=(Person) session.get(Person.class,5);
		session.delete(person);
		tx.commit();
		session.close();
		// TODO Auto-generated method stub
		
	}

	

}
