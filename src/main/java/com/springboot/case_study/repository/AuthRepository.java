package com.springboot.case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.case_study.model.User;

public interface AuthRepository  extends JpaRepository<User, Integer>{
	User findByUsername(String username); 

}
