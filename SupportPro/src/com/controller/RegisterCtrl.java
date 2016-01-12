package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.register.RegisterInfo;

import com.service.RegsiterInfoService;

@Controller
public class RegisterCtrl {
	
	@Autowired
	private RegsiterInfoService registerService;

	@RequestMapping("/register")
	public String register(RegisterInfo info) {
		info.setPass(false);
		registerService.saveRegister(info);
		return "result";
	}
}
