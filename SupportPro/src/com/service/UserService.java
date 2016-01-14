package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.register.User;
import com.repository.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	
	public User login(String name,String password){
		User user= dao.findByNameAndPassword(name,password);
		return user;
	}
}
