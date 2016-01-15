package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.register.RegisterInfo;
import com.repository.RegisterInfoDao;
@Service
public class RegsiterInfoService {
	@Autowired
	private RegisterInfoDao dao;
	
	@Transactional
	public boolean saveRegister(RegisterInfo info){
		return dao.save(info)==null?true:false;
	}

	public List<RegisterInfo> findAll() {
		return dao.findAll();
	}

	public List<RegisterInfo> findWaiting() {
		return dao.findByPass(false);
	}

	public List<RegisterInfo> findPassed() {
		return dao.findByPass(true);
	}

	public RegisterInfo findByID(long id) {
		return dao.findById(id);
	}

	public boolean setResult(Long id, boolean b,RegisterInfo info2) {
		RegisterInfo info=dao.findById(id);
		info.setPass(b);
		info2.copy(info);
		return dao.save(info)==null?false:true;
	}

}
