package com.project.demo.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.Profiles;
import com.project.demo.repository.ProfileRepository;

@Service
public class ProfileService {
     @Autowired
	private ProfileRepository repo;
public Profiles getProfile(int id) {
	return repo.getById(id);
}

public List<Profiles> getAllProfiles(){
	return repo.findAll();
}
@Transactional
public Profiles addProfile(Profiles p) {
	return repo.save(p);
}
}
