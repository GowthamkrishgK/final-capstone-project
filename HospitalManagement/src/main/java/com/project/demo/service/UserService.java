package com.project.demo.service;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.demo.encryption.EncryptPassword;
import com.project.demo.model.*;

import com.project.demo.repository.*;
import com.project.demo.requests.DoctorRequest;
import com.project.demo.requests.userRequest;
import com.project.demo.response.loginResponse;

//import org.springframework.security.core.userdetails.User;
@Service
public class UserService {
	
	
	
@Autowired
private UserRepository userRepo;
@Value("${app.user.role}")
private String UserAuthority;

@Autowired
private UsrRepository usr;
@Autowired
private PasswordEncoder encoder;
@Autowired
private EncryptPassword encod;



@Transactional
public void addUser(userRequest user) throws Exception {
   Userdetails u=user.toUser();
   u=userRepo.save(u);
   User u1=new User();
   u1.setUser(u);
   u1.setAuthorities(UserAuthority);
   u1.setPassword(encoder.encode(encod.methodEncrypt(user.getPassword(), false)));
   u1.setUsername(user.getEmail());
  u1= usr.save(u1);
  u.setUser(u1);
userRepo.save(u);
	
}
public loginResponse findByloginParameter(String username,String password,String auth)throws Exception {
	String login=usr.findbyPassandName( encoder.encode(encod.methodEncrypt(password, false)),username,auth);
	String obj[]=login.split(",");
	loginResponse lr=new loginResponse();
	lr.setUsername(obj[0]);
	lr.setPassword(obj[1]);
	lr.setAuthorities(obj[2]);
	return lr;
}
public Userdetails getUserbyid(int id) {
 return userRepo.findById(id).orElse(null);
}
public List<Userdetails> addUsers(List<userRequest> users){
	
	List<Userdetails> u=new ArrayList<>();
	int i=0;
	for(Userdetails ud :u ) {
		ud=users.get(i).toUser();
		u.add(ud);
				i++;
	}
	i=0;
	

	return userRepo.saveAll(u);
}
public List<Userdetails> getUsers(){
	return userRepo.findAll();
}

//public String deleteUsers(int id) {
//	userRepo.deleteById(id);
//	return "User Removed "+id;
//}

public String DeleteByName( String name) {
	userRepo.deleteUserbyName(name);
	return "User Removed "+name;
}

public Userdetails finduserbyname() {
	Authentication a=  SecurityContextHolder.getContext().getAuthentication();
	User u=(User) a.getPrincipal();
	String name=u.getUser().getName();
	return userRepo.findbyname(name);
}
public Userdetails findbyemail(String email){
	return userRepo.findbyemail(email);
}

public User forgotPassword(String email,String pass) throws Exception {  
	   User d=usr.findbyname(email);
	           d.setPassword(pass);
return  usr.save(d);

	
}
}
