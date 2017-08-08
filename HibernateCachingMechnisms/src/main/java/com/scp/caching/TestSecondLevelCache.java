package com.scp.caching;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

public class TestSecondLevelCache {

	
	
	public static void main(String[] args) {
		
	/*	Product p1 = new Product("Product1",10000);
		Product p2 = new Product("Product2",4000);
		Product p3 = new Product("Product3",12000);
		Product p4 = new Product("Product4",59000);*/
		
		SessionFactory sFactory = AppUtility.getSessionFactory();
		Session session1 = sFactory.openSession();
		Session session2 = sFactory.openSession();
		Transaction tr1 = session1.beginTransaction();
		Transaction tr2 = session2.beginTransaction();
    /*  session1.save(p1);
      session1.save(p2);*/
//	    //session2.save(p3);
		System.out.println("Get Product id 1 from DB >> FirstTime");
		System.out.println();
		System.out.println();
		Product dbp1 = (Product)session1.get(Product.class,1);
		
		// Product dbp2= (Product)session1.get(Product.class,1);
		
		Product dbp3 = (Product)session2.get(Product.class,1);
		
		System.out.println();System.out.println();
		System.out.println("DBP1" +dbp1);
		System.out.println("##################");
		/*System.out.println("Get Product id 1 from DB >> Second time with same session");
		System.out.println("DBP2" +dbp2);*/
		System.out.println("##################");
		System.out.println("Get Product id 1 from DB >> thirdtime bt another sesion");
		System.out.println("DBP3" +dbp3);
		
		
		/*Query query = session1.createQuery("from Product as prod where prod.productId = ? "
				+ "and prod.productName = ?");
		query.setInteger(0, 2);
		query.setString(1, "Product2");
		query.setCacheable(true);
		List<Product> l = query.list();
		for (Product product : l) {
			System.out.println(product);
		}*/
		
		
		AppUtility.resourceCleanup(tr1, session1);
		AppUtility.resourceCleanup(tr2, session2);
		
	}
	
	
	/*private static void printStats(Statistics stats, int i) {
		System.out.println("***** " + i + " *****");
		System.out.println("Fetch Count="+ stats.getEntityFetchCount());
		System.out.println("Second Level Hit Count="+ stats.getSecondLevelCacheHitCount());
		System.out.println("Second Level Miss Count="+ stats.getSecondLevelCacheMissCount());
		System.out.println("Second Level Put Count="+ stats.getSecondLevelCachePutCount());
	}
*/
	/*private static void printData(Product p, Statistics stats, int count) {
		System.out.println(count+":: ProductId="+p.getProductId()+", ProductName="+p.getProductName() +", ProductPrice=" +p.getProductPrice());
		printStats(stats, count);
	}*/

	
	
}




