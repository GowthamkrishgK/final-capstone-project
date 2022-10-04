package com.project.demo.requests;



import org.springframework.boot.jackson.JsonComponent;

import com.project.demo.model.Doctor;

import com.project.demo.model.DoctorPrescription;
import com.project.demo.model.UserAppointment;
import com.project.demo.model.Userdetails;
@JsonComponent
public class AppointmentRequest {
	private String username;
	private String  Patientname;
	private String doctor;
	private String symptoms;
	private String date;
	
	
	public UserAppointment toAppointment() {
		UserAppointment appointment=new UserAppointment();
		appointment.setPatientname(Patientname);
		appointment.setSymptoms(symptoms);
		appointment.setDate(date);
		
		return appointment;
	}
	public String getPatientname() {
		return Patientname;
	}
	public void setPatientname(String patientname) {
		Patientname = patientname;
	}
	

	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
