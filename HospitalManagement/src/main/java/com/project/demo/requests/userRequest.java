package com.project.demo.requests;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.demo.model.Userdetails;
@JsonComponent
public class userRequest {

	
	private String name;
	private String dob;
	private long phone;
	private String email;
	private String password;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
		this.password=password;
		
	}


	public Userdetails toUser() {
		Userdetails u=new Userdetails();
		u.setName(this.name);
		u.setDob(this.dob);
		u.setPhone(this.phone);
		u.setEmail(this.email);
		return u;
	}
}
