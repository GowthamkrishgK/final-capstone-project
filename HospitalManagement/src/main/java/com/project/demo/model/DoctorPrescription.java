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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="DoctorPrescription",uniqueConstraints = @UniqueConstraint(columnNames = "patientname"))
public class DoctorPrescription implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int prescriptionid;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="patientname")
@JsonIgnoreProperties("p")
private UserAppointment patient;
private Boolean isAvailable;

public Boolean getIsAvailable() {
	return isAvailable;
}
public void setIsAvailable(Boolean isAvailable) {
	this.isAvailable = isAvailable;
}
private String description;
@ManyToOne( cascade = CascadeType.ALL)
@JoinColumn(name="docid")
@JsonIgnoreProperties("docprescription")
private Doctor doctor;
public int getPrescriptionid() {
	return prescriptionid;
}
public void setPrescriptionid(int prescriptionid) {
	this.prescriptionid = prescriptionid;
}


public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public UserAppointment getPatient() {
	return patient;
}
public void setPatient(UserAppointment patient) {
	this.patient = patient;
}
public Doctor getDoctor() {
	return doctor;
}
public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}

}
