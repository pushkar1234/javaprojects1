package com.FirstlevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SecondLevelTest {

	public static void main(String[] args) {
		SessionFactory factory=null;
		factory=AppUtility.GetFactory();
		Session session1=factory.openSession();
		/*Transaction tr=session1.beginTransaction();
		Employee e=new Employee(); 
		e.setEmp_name("pushkar");
		e.setSalary(20000);
		session1.save(e);
		tr.commit();*/
	Employee e11=(Employee)session1.get(Employee.class,1);
		System.out.println(e11.getEmpId()+" "+e11.getEmp_name()+""+e11.getSalary());
		session1.close();
		Session session2=factory.openSession();
		Employee e12=(Employee)session2.get(Employee.class,1);
		System.out.println(e12.getEmpId()+" "+e12.getEmp_name()+""+e12.getSalary());
		session2.close();
		
		// TODO Auto-generated method stub

	}

}
