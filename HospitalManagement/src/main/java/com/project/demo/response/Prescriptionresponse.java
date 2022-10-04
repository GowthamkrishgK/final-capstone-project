package com.project.demo.response;

import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class Prescriptionresponse {
 private long Doctorphone;
 private String Doctoremail;
 private String Description;
 private String patientName;
 private String DoctorName;
private String symptoms;
public long getDoctorphone() {
	return Doctorphone;
}
public void setDoctorphone(long doctorphone) {
	Doctorphone = doctorphone;
}
public String getDoctoremail() {
	return Doctoremail;
}
public void setDoctoremail(String doctoremail) {
	Doctoremail = doctoremail;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public String getDoctorName() {
	return DoctorName;
}
public void setDoctorName(String doctorName) {
	DoctorName = doctorName;
}
public String getSymptoms() {
	return symptoms;
}
public void setSymptoms(String symptoms) {
	this.symptoms = symptoms;
}
 
}
