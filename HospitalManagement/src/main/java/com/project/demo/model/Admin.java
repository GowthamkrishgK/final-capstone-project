package com.project.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity	
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int adminid;
private String email;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "userid")
private User user;
public int getAdminid() {
	return adminid;
}
public void setAdminid(int adminid) {
	this.adminid = adminid;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}


}
