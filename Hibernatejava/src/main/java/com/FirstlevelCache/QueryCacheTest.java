package com.FirstlevelCache;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class QueryCacheTest {

	public static void main(String[] args) {
		SessionFactory factory=null;
		factory=AppUtility.GetFactory();
		Session session1=factory.openSession();
		//Transaction tr=session1.beginTransaction();
		String str="from Employee where EmpId=1";
		
		Query q=session1.createQuery(str);
		q.setCacheable(true);
	Employee d=	(Employee)q.uniqueResult();
	System.out.println(d.getEmp_name()+" "+d.getEmpId());
	session1.close();
	Session session2=factory.openSession();
	String str1="from Employee where EmpId=1";
	
	Query q1=session2.createQuery(str1);
	q1.setCacheable(true);
Employee d1=	(Employee)q1.uniqueResult();
System.out.println(d1.getEmp_name()+" "+d1.getEmpId());
	session2.close();
		

	}

}
