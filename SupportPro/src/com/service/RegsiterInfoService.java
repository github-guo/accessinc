package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.domain.register.RegisterInfo;
import com.repository.RegisterInfoDao;

public class RegsiterInfoService {
	@Autowired
	private RegisterInfoDao dao;
	
	boolean saveRegister(RegisterInfo info){
		return dao.saveRegister(info);
	}
}
