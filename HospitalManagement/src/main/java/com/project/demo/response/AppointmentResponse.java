package com.project.demo.response;

public class AppointmentResponse {
private String Patientname;
private String symptoms;
private String date;
private String Doctorname;
private boolean isAvailable;
public String getPatientname() {
	return Patientname;
}
public void setPatientname(String patientname) {
	Patientname = patientname;
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
public String getDoctorname() {
	return Doctorname;
}
public void setDoctorname(String doctorname) {
	Doctorname = doctorname;
}
public boolean isAvailable() {
	return isAvailable;
}
public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
}

}
