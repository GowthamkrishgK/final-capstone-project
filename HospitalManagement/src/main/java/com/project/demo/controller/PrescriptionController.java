package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.DoctorPrescription;
import com.project.demo.requests.PrescribeRequest;
import com.project.demo.requests.viewRequest;
import com.project.demo.response.Prescriptionresponse;
import com.project.demo.service.DoctorPrescriptionService;
@CrossOrigin
@RestController
public class PrescriptionController {
	
	@Autowired
	private DoctorPrescriptionService prescribeservice;
@PostMapping("/prescription/add")
public String addPrescription(@RequestBody PrescribeRequest pres) {
	
	 prescribeservice.addprescription(pres);
	 return "prescribed" +pres.getPatientname();
}
@PostMapping("/Addprescription")
public String addPres(@RequestBody PrescribeRequest pres) {
	
	 prescribeservice.addprescription(pres);
	 return "prescribed" +pres.getPatientname();
}
@GetMapping("/prescription/viewPrescription/{name}")
public Prescriptionresponse viewPrescription(@PathVariable	String name) {

	
//	System.out.println(name);
	return prescribeservice.viewPrescription(name);
}
}
