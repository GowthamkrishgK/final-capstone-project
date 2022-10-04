package com.project.demo.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.*;

import com.project.demo.repository.*;
import com.project.demo.requests.AppointmentRequest;
import com.project.demo.response.AppointmentResponse;


@Service
public class UserAppointmentService {
@Autowired
private UserAppointmentRepository appointment;
@Autowired 
private DoctorPrescriptionRepository presrepo;
@Autowired
private DoctorRepository doctorrepo;
@Autowired
private UserRepository userrepo;
@Transactional
public UserAppointment addAppointment(AppointmentRequest apply) {
	UserAppointment app=apply.toAppointment();
	Doctor d=doctorrepo.findbyName(apply.getDoctor());
	 app.setDoctor(d);
	 Userdetails u=userrepo.findbyemail(apply.getUsername());
	 app.setUser(u);
	return appointment.save(app);
}
public List<AppointmentResponse> getAppointments(){
	List<String>  a= appointment.getAppointments();
	List<AppointmentResponse> obj1=new ArrayList<>();
	int i=0;
	for(String app:a) {
		String obj[];
		   obj=a.get(i).split(",");
			AppointmentResponse app1=new AppointmentResponse();
			app1.setAvailable(Boolean.parseBoolean(obj[4]) );
			app1.setDate(obj[2]);
			app1.setDoctorname(obj[3]);
			app1.setPatientname(obj[0]);
			app1.setSymptoms(obj[1]);
		   obj1.add(app1);
		   i++;
		   
	}
	return obj1;
}

public UserAppointment getAppointmentByUserName(String name){
	return appointment.findbyname(name);
	
}

//public User

public String DeleteAppointmentByname(String name) {
	appointment.deleteAppointment(name);
	return "Appointment Deleted "+name;
}

}
