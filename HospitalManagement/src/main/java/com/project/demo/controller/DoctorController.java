package com.project.demo.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.Doctor;
import com.project.demo.model.User;
import com.project.demo.requests.DoctorRequest;
import com.project.demo.service.DoctorService;
@CrossOrigin
@RestController
public class DoctorController {
  @Autowired
  DoctorService doctorservice;
	
	@PostMapping("/doctorregister")
	public Doctor  signup(@RequestBody DoctorRequest doc) throws Exception{
		
		doctorservice.saveDoctor(doc);
		return doc.toDoctor();
		    
	}
	@PostMapping("/doctorsignup")
	public String  signupdoc(@RequestBody DoctorRequest doc) throws Exception{
		doctorservice.saveDoctor(doc);
		    return "Registered";
	}
	@PostMapping("/admin/doctor/addDoctor")
	public String addDoctor(@RequestBody DoctorRequest doc)throws Exception {
		doctorservice.saveDoctor(doc);
		    return "doctor added";
	}
	@GetMapping("/doctor")
	public Doctor getByname() {
		User u=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name=u.getDoctor().getName();
				
		
		return doctorservice.docbyName(name);
	}
	@GetMapping("/doctorname")
	public List<Doctor> getname() {
		User u=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name=u.getDoctor().getName();
				
		
		return doctorservice.docName();
	}
	@GetMapping("/doctornames")
	public List<String> fetchdoctors(){
		return doctorservice.doctors();
	}
	@GetMapping("/admin/doctor/name")
	public Doctor getDoctor(@RequestParam("name") String name) {
		return doctorservice.docbyName(name);
	}
	@GetMapping("/admin/doctor/doctors")
	public List<Doctor> getAll() {
		return doctorservice.getDoctors();
	}
	@PutMapping("/admin/doctor/update")
	public ResponseEntity<Doctor> updatedocbyName(@RequestBody DoctorRequest doc) {
		
		 
		 Doctor d=doctorservice.updateDoctor(doc);
		 return new ResponseEntity<>(d,HttpStatus.OK);
		
	}
	@PutMapping("/doctor/update/{email}/forgotpassword/{password}")
	public User updatedocpassword(@PathVariable("email")String email,@PathVariable("password")String password) throws Exception { 
		return doctorservice.forgotPassword(email, password);
	}
	
	
	@DeleteMapping("/admin/doctor/delete/{id}")
	public String deleteDoctor(@PathVariable("id")int id) throws Exception {
		return doctorservice.deleteDoctor(id);
	}
}
