package com.project.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Appointment")
public class UserAppointment implements Serializable {
	
	public UserAppointment() {
		appointmentid++;
	}
	@Id
	@Column(nullable = false,unique = true)
private String  Patientname;
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
private static int appointmentid;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "prescriptionid")
@JsonIgnoreProperties("prescriptionid")
private DoctorPrescription p;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "docid")
private Doctor doctor;
@ManyToOne(cascade = CascadeType.ALL)
private Userdetails user;

private String symptoms;
private String date;
public int getAppointmentid() {
	return appointmentid;
}
public void setAppointmentid(int appointmentid) {
	this.appointmentid = appointmentid;
}



public Userdetails getUser() {
	return user;
}
public void setUser(Userdetails user) {
	this.user = user;
}
public DoctorPrescription getP() {
	return p;
}
public void setP(DoctorPrescription p) {
	this.p = p;
}
public String getPatientname() {
	return Patientname;
}
public void setPatientname(String patientname) {
	Patientname = patientname;
}
public Doctor getDoctor() {
	return doctor;
}
public void setDoctor(Doctor doctor) {
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
