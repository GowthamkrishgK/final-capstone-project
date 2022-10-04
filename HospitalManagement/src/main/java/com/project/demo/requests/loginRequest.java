package com.project.demo.requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.demo.encryption.EncryptPassword;
import com.project.demo.model.User;

@JsonComponent
public class loginRequest {
private String username;
private String password;
private String authorities;

@Autowired
private EncryptPassword encod;

public String getAuthorities() {
	return authorities;
}
public void setAuthorities(String authorities) {
	this.authorities = authorities;
}
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
public User toUser() throws Exception {
	User u=new User();
	u.setUsername(username);
	u.setPassword(encod.methodEncrypt(password, false));
	u.setAuthorities(authorities);
	return u;
}
}
