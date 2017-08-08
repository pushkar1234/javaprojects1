package com.Dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Model.User;
@Repository
public class DaoImpl implements Userdao{
	
	@Autowired
	private SessionFactory session;

	@Override
	public void save(User user) {
		session.getCurrentSession().save(user);
		// TODO Auto-generated method stub
		
	}
    
	@Override
	public User getUseByName(String userName) {
		Criteria criteria=session.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.like("userName",userName ));
		Object result=criteria.uniqueResult();
		User user=(User) result;
		return user;
	}

	@Override
	public boolean   validate(String userName, String password) {
		Criteria criteria=session.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.like("userName", userName));
		boolean flag=false;
		Object result=criteria.uniqueResult();
		if(result!=null)
		{
			User user=(User) result;
			if(user.getUserPassword().equalsIgnoreCase(password))
			{
				flag=true;
			}
		}
		if(flag==true)
		{
			return true;
		}
		else
		{
			return false;
		}
		// TODO Auto-generated method stub
	
	}

	

	
	

}
