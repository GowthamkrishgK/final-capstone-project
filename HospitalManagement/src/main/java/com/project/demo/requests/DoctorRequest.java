package com.project.demo.requests;



import org.springframework.boot.jackson.JsonComponent;

import com.project.demo.model.Department;

import com.project.demo.model.Doctor;
@JsonComponent
public class DoctorRequest {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String name;
	private String department;
	private String dob;
	private long phone;
	private String email;
	private String password;
	public Doctor toDoctor() {
		Doctor d=new Doctor();
		d.setName(name);
		d.setDepartment(department);
		d.setDob(dob);
		d.setPhone(phone);
		d.setEmail(email);
		
		return d;
	}
}
