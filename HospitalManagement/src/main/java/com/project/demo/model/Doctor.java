package com.project.demo.model;

import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="doctor",uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Doctor implements Serializable {
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="docid")
private int docid;
private String name;

private String department;
@Column(name="dob",nullable = false)
private String dob;
@Column(name="phone",nullable = false)
private long phone;
@Column(name="email",nullable = false,unique = true)
private String email;

@OneToMany(cascade=CascadeType.ALL,mappedBy = "doctor")
@JsonIgnoreProperties("doctor")
private List<DoctorPrescription> docprescription;
@OneToMany(cascade=CascadeType.ALL,mappedBy = "doctor")
@JsonIgnoreProperties("doctor")
private List<UserAppointment> appointment;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="userid")
@JsonIgnoreProperties("doctor")
private User user;



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


public int getDocid() {
	return docid;
}
public void setDocid(int docid) {
	this.docid = docid;
}

@Override
public String toString() {
	return "Doctor [docid=" + docid + ", name=" + name + ", department=" + department + ", dob=" + dob + ", phone="
			+ phone + ", email=" + email +  ", docprescription=" + docprescription
			+ ", appointment=" + appointment + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}




}
