package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.demo.model.Admin;

public interface AdminRepository  extends JpaRepository<Admin, Integer>{
	@Query("select a from Admin a where a.adminid=?1")
public Admin findbyid(int id);
}
