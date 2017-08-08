package com.scp.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppUtility {

	static SessionFactory sessionFactory=null;
	
	public static SessionFactory getSessionFactory(){
		
		if(null==sessionFactory)
			sessionFactory=new Configuration().configure().buildSessionFactory();
		
		return sessionFactory;
	}

	public static void resourceCleanup(Transaction tr, Session session) {
		if(null!=session){
			session.flush();
			if(null!=tr)
				tr.commit();	
			session.close();
		}
		
		
		
	}
	
	
	
}
