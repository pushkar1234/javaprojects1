package com.FirstlevelCache;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class AppUtility {
	public static SessionFactory GetFactory()
	{
		SessionFactory factory=new AnnotationConfiguration().configure("hibernet.cfg.xml").buildSessionFactory();
		return factory;
	}

}
