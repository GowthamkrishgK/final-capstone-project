package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.demo.model.UserAppointment;
import com.project.demo.requests.AppointmentRequest;
import com.project.demo.response.AppointmentResponse;
import com.project.demo.service.UserAppointmentService;
@CrossOrigin
@RestController
public class AppointmentController {
	@Autowired
	private UserAppointmentService appservice;
@PostMapping("/appointment/book")
public UserAppointment book(@RequestBody AppointmentRequest req) {
	         return  appservice.addAppointment(req);
}
@PostMapping("/appointmentbook")
public UserAppointment Abook(@RequestBody AppointmentRequest req) {
	         return  appservice.addAppointment(req);
}
@GetMapping("/appointments")
public List<AppointmentResponse> viewall() {
	         return  appservice.getAppointments();
}
}
