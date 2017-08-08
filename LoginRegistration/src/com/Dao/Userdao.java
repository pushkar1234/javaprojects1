package com.Dao;


import com.Model.User;

public interface Userdao {
	public void save(User user);
	public User getUseByName(String userName);
	public  boolean validate(String userName,String password);

}
