package com.project.demo.repository;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.demo.model.*;

public interface UserRepository extends JpaRepository<Userdetails, Integer> {
	@Query("select u from Userdetails u where u.name=:name")
  Userdetails findbyname(String name);
	@Query(value="select * from user u where u.email=?1",nativeQuery = true)
   Userdetails findbyemail(String email);
	

	
	
	@Modifying
	@Transactional
	@Query("delete from Userdetails u where u.name=?1")
	void deleteUserbyName(String name);
	
}
