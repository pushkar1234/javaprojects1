package com.FirstlevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class FirstLevelTest {

	public static void main(String[] args) {
	SessionFactory factory=null;
	factory=AppUtility.GetFactory();
	Session session1=factory.openSession();
	Transaction tr=session1.beginTransaction();
	/*Employee e1=new Employee();
	e1.setEmpId(101);
	e1.setEmp_name("raj");
	e1.setSalary(20000);
	session1.save(e1);*/
	tr.commit();
	System.out.println("success");
	
Employee e11=(Employee)session1.get(Employee.class,1);
	System.out.println(e11.getEmpId()+" "+e11.getEmp_name());
	
	session1.close();
	Session session2=factory.openSession();
	Employee e12=(Employee)session2.get(Employee.class,2);
	System.out.println(e12.getEmpId()+" "+e12.getEmp_name());
	
	//Session s1=factory.openSession();
	
	
    
	}

}
