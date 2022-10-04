package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.demo.model.Profiles;

public interface ProfileRepository extends JpaRepository<Profiles, Integer> {
	

}
