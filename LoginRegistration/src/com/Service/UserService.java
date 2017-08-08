package com.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.Dao.Userdao;
import com.Model.User;

public interface UserService {
	public void save(User user);
	public User getUseByName(String userName);
	public  boolean validate(String userName,String password);

}
