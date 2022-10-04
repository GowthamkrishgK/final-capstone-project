package com.project.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.project.demo.model.Admin;
import com.project.demo.requests.AdminRequest;
import com.project.demo.service.AdminService;

@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan({"com.project.demo.requests","com.project.demo.controller"})
public class HospitalManagementApplication implements CommandLineRunner{
  @Autowired
  AdminService as;
  
	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	   AdminRequest a=new AdminRequest();
	   a.setUsername("admin123@prodapt.com");
	   a.setPassword("admin123");
	   as.addAdmin(a);
	}

}
