package com.savecreator.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savecreator.dao.LoginDao;
import com.savecreator.web.entity.User;

@Service
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private LoginDao loginDao;

	@Override
	public int insertSignup(User user) {
		
		return loginDao.insertSignup(user);
	}
}