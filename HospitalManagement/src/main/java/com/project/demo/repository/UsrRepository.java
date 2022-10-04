package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.demo.model.User;
import com.project.demo.model.Userdetails;
import com.project.demo.response.loginResponse;

public interface UsrRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.username=:email")
	  User findbyname(String email);
	@Query("select u.username,u.password,u.Authorities from User u where u.password=:pass and u.username=:email and u.Authorities=:auth")
	  String findbyPassandName(String pass,String email,String auth);
}
