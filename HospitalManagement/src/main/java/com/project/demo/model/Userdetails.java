package com.project.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="user",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Userdetails  implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int id;
@Column(name="name",nullable = false)
private String name;
@Column(name="dob",nullable = false)
private String dob;
@Column(name="phone",nullable = false)
private long phone;
@Column(name="email",nullable = false)
private String email;

@CreationTimestamp
private Date regdate;
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="userid")
private User user;

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
@OneToMany(mappedBy = "user")
private List<UserAppointment> appointment;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}




@Override
public String toString() {
	return "Userdetails [id=" + id + ", name=" + name + ", dob=" + dob + ", phone=" + phone + ", email=" + email
			+  ", regdate=" + regdate + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getRegdate() {
	return regdate;
}
public void setRegdate(Date regdate) {
	this.regdate = regdate;
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




}
