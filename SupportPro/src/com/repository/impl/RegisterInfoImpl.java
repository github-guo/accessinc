package com.repository.impl;

import org.springframework.stereotype.Repository;

import com.domain.register.RegisterInfo;
import com.repository.RegisterInfoDao;
@Repository
public class RegisterInfoImpl implements RegisterInfoDao {

	@Override
	public boolean saveRegister(RegisterInfo info) {
		return false;
	}
}
