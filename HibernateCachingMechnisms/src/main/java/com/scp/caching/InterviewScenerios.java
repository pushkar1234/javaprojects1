package com.scp.caching;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class InterviewScenerios {
	
	public static void main(String[] args) {
		//testGetNLoadMethod();
		//testUpdateNMergeScenerios();
		getListOfObjectsFromDB();
		
	}

	private static void getListOfObjectsFromDB() {
		SessionFactory sFactory = AppUtility.getSessionFactory();
		Session session1 = sFactory.openSession();
		/**
		 * CreateQuery  > It will be for HQL > we need to specify object name and 
		 * their filed name instead of tablename and column name
		 * 
		 * CreateSQLQuery  > It will be for Database queries > we need to specify Tablename and 
		 *  column names instead of object name and field name
		 *  
		 *  
		 *  AddScalar Datatype
		 *  
		 */
		//Query hqlQuery = session1.createQuery(" from Product");  
		Query hqlQuery =session1.getNamedQuery("HQL_GET_ALL_PRODUCT");
		
		//Query sqlQuery = session1.createSQLQuery("select * from prod_cache").addEntity(Product.class);
		Query sqlQuery = session1.getNamedQuery("SQL_GET_ALL_PRODUCT");
		
		
		List<Object> hqllistofobjects = hqlQuery.list(); //14
		List<Object> sqllistofobjects = sqlQuery.list(); //14
		
		List<Product> hqlListofProducts = new ArrayList<Product>();//10
		List<Product> sqlListofProducts = new ArrayList<Product>();//10
		
		
		for (Object object : hqllistofobjects) {
			hqlListofProducts.add((Product)object);
		}
		
		System.out.println("HQL > "+hqlListofProducts);
		
		for (Object object : sqllistofobjects) {
			sqlListofProducts.add((Product)object);
		}
		System.out.println("SQL > "+sqlListofProducts);
		
		
		Query hqlQuerywithID =session1.getNamedQuery("HQL_GET_ALL_PRODUCT_WITH_ID");
		hqlQuerywithID.setParameter("pid", 202);

		List<Object> listOfProdUsingNamedQuery = hqlQuerywithID.list();
		for (Object object : listOfProdUsingNamedQuery) {
			hqlListofProducts.add((Product)object);
		}
		
		
		Query hqlQuerywithIDNName =session1.getNamedQuery("HQL_GET_ALL_PRODUCT_WITH_ID_N_NAME");
		hqlQuerywithIDNName.setParameter(0, "Product4");
		hqlQuerywithIDNName.setParameter(1, 4);
		
		
		List<Object> listOfProdUsingNamedQuery1 = hqlQuerywithIDNName.list();
		for (Object object : listOfProdUsingNamedQuery1) {
			hqlListofProducts.add((Product)object);
		}
		
		System.out.println(hqlListofProducts);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private static void testUpdateNMergeScenerios() {
		SessionFactory sFactory = AppUtility.getSessionFactory();
		Session session1 = sFactory.openSession();
		
		Product s1Value = (Product)session1.get(Product.class,303);
		// During persistent state
		s1Value.setProductName("pppp");
		session1.save(s1Value);
		session1.flush();
		session1.close(); // Detached
		
		// In Detached State
		s1Value.setProductName("qqqqq");
		s1Value.setProductPrice(11111);
		// s1value  > 303, bbbb ,1111
		
		Session session2 = sFactory.openSession();
		Product s2Value = (Product)session2.get(Product.class,303);
		Transaction t = session2.beginTransaction();
		System.out.println("Value from db "+s2Value);
		//s2value  - 303 aaa 400000
		s2Value.setProductName("rrrrr");
		//s2value  - 303 xxx 400000
		
		//session2.update(s1Value);
		System.out.println("Returning value"+session2.merge(s1Value));
		session2.flush();
		System.out.println("Object saved succefully...!");
		
		AppUtility.resourceCleanup(t, session2);
		
		
	}

	private static void testGetNLoadMethod() {
		SessionFactory sFactory = AppUtility.getSessionFactory();
		Session session = sFactory.openSession();
		
		/**
		 * It always hit the database and return the real object, an object that represent the database row, not proxy.
			If no row found , it return null.
		 */
		System.out.println("Retriving product using get method");
		Product p1 = (Product)session.get(Product.class, 5);

		
		/**
		 * It will always return a “proxy” (Hibernate term) without hitting the database. In Hibernate, proxy is an object with the given identifier value, its properties are not initialized yet, it just look like a temporary fake object.
			If no row found , it will throws an ObjectNotFoundException.
			org.hibernate.ObjectNotFoundException: No row with the given identifier exists: [com.scp.caching.Product#5]
		 */
		
		System.out.println("Retriving product using load method");
		Product p2 = (Product)session.load(Product.class, 5);

		System.out.println();
		System.out.println();
		System.out.println("Printing product Name > "+p1.getProductName());
		System.out.println("Printing product Name > "+p2.getProductName());
		
	}

}
