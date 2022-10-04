package com.project.demo.requests;

import org.springframework.boot.jackson.JsonComponent;

import com.project.demo.model.Admin;
import com.project.demo.model.Userdetails;

@JsonComponent
public class AdminRequest {
private String username;
private String password;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Admin toAdmin() {
 Admin a=new Admin();
	a.setEmail(username);
	return a;
}
}
