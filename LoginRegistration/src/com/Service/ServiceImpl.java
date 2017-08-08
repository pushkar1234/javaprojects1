package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.Userdao;
import com.Model.User;
@Service
@Transactional
public class ServiceImpl implements UserService{
	private Userdao userdao;
	
	public void setUserdao(Userdao userdao) {
		this.userdao = userdao;
	}

	@Override
	public void save(User user) {
		userdao.save(user);
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUseByName(String userName) {
		return userdao.getUseByName(userName);
		// TODO Auto-generated method stub
		/*return (User) userdao;*/
	}

	@Override
	public boolean validate(String userName, String password) {
		return userdao.validate(userName, password);
		/*return userdao != null;*/
	}

}
