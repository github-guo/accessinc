package com.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.register.RegisterInfo;

@Repository
public interface RegisterInfoDao extends JpaRepository<RegisterInfo, Long>{

	List<RegisterInfo> findByPass(boolean passed);
	
}
