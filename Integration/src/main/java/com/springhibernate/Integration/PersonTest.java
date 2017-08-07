package com.springhibernate.Integration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import antlr.collections.List;

public class PersonTest {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonDao personDao=(PersonDao) context.getBean("personDAO");
		Person person=new Person();
		person.setName("Pushkar");
		person.setCountry("India");
		//personDao.save(person);
        System.out.println("success");
        java.util.List<Person> list=personDao.list();
        System.out.println("Person List");
        for(Person p:list)
        {
        	System.out.println(p);
        }
        personDao.update();
        System.out.println("updated");
        personDao.delete();
        System.out.println("Deleted");
		((AbstractApplicationContext) context).close();
		// TODO Auto-generated method stub

	}

}
