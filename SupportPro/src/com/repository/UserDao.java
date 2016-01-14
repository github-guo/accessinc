package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.register.User;

public interface UserDao extends JpaRepository<User, Long>{
	User findByNameAndPassword(String name,String password);
}
