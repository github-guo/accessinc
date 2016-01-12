package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.register.RegisterInfo;
import com.repository.RegisterInfoDao;

@Controller
public class RegisterCtrl {
	
	@Autowired
	private RegisterInfoDao registerDao;

	@RequestMapping("/register")
	public String register(RegisterInfo info) {
		registerDao.saveRegister(info);
		return "result";
	}
}
