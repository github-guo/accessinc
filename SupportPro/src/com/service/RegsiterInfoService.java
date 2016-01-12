package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.register.RegisterInfo;
import com.repository.RegisterInfoDao;
@Service
public class RegsiterInfoService {
	@Autowired
	private RegisterInfoDao dao;
	
	public boolean saveRegister(RegisterInfo info){
		return dao.save(info)==null?true:false;
	}

	public List<RegisterInfo> findAll() {
		return dao.findAll();
	}
}
