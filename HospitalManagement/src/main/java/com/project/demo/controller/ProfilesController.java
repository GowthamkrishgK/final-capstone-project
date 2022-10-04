package com.project.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Profiles;
import com.project.demo.service.ProfileService;

@RestController
public class ProfilesController {
	@Autowired
	private ProfileService ps;
@GetMapping("/profiles")
public List<Profiles> getProfile() {
	return ps.getAllProfiles();
}
@PostMapping("/profiles/addProfile")
public Profiles addProfile(@RequestBody Profiles p) {
	return ps.addProfile(p);
}
@GetMapping("/profiles/{id}")
public Profiles getIndividualProfile(@PathVariable("id")int id) {
	return ps.getProfile(id);
}

}
