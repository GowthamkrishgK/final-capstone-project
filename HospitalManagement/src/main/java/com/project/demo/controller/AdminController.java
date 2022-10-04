package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Admin;
import com.project.demo.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService service;
	@GetMapping("/admin")
	public Admin getAdmin() {
		return service.getAdmin();
	}
}
