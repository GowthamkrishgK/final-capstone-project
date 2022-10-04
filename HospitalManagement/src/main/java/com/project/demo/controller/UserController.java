package com.project.demo.controller;

import java.security.Principal;
import java.util.Base64;
import java.util.List;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.demo.model.Doctor;
import com.project.demo.model.User;
//import com.project.demo.MyConfiguration;
import com.project.demo.model.Userdetails;
import com.project.demo.repository.UserRepository;
import com.project.demo.requests.loginRequest;
import com.project.demo.requests.userRequest;
import com.project.demo.response.loginResponse;
import com.project.demo.service.DoctorService;
import com.project.demo.service.UserService;
@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	private UserRepository userrepo;
	
	
	@Autowired
	private UserService serve;
	@PostMapping("/addregistration")
	public Userdetails registerUsers(@RequestBody userRequest userdetail) throws Exception{
		serve.addUser(userdetail);
		return userdetail.toUser();

	}

@PostMapping("/user/signup")
public String registerUser(@RequestBody userRequest u) throws Exception{
	serve.addUser(u);
	return  "Registered Successfully";
}
@PostMapping("/admin/user/adduser")
public String addUser(@RequestBody userRequest u) throws Exception{
	serve.addUser(u);
	return  "user added";
}

@RequestMapping("/loginuser")
public loginResponse login(@RequestBody loginRequest user) throws Exception {
	String tempuser = user.getUsername();
    String temppassword = user.getPassword();
    String tempauth=user.getAuthorities();
    loginResponse u=null;
    if(tempuser!=null && temppassword!=null)
    {
        u=serve.findByloginParameter(tempuser, temppassword,tempauth);
    }
    if(u == null) {
        throw new Exception("Wrong credentials");
    }
	return u;
}
@RequestMapping("/user")
public Principal user(HttpServletRequest request) {
	String authtoken=request.getHeader("Authorization").substring("Basic".length()).trim();
	return () -> new String(Base64.getDecoder().decode(authtoken)).split(":")[0];
}

@GetMapping("/admin/user/name")
public Userdetails getUser(@RequestParam( "name")String name) {
	
	return serve.finduserbyname();
	
}
@GetMapping("/user")
public Userdetails getUserbyName() {

	return serve.finduserbyname();
	
}


@PutMapping("/admin/user/update/{email}")
public String updateUser(@PathVariable("email")String email,@RequestBody  userRequest user) throws Exception{
	user.setEmail(email);
	 serve.addUser(user);
	 return "user "+email+"updated";
}
@PutMapping("/user/update/forgotpassword/{password}")
public User updateuserpassword(@RequestParam("email")String email,@RequestParam("password")String password) throws Exception { 
	return serve.forgotPassword(email, password);
}
@DeleteMapping("/admin/user/delete/{name}")
public String deleteUser(@PathVariable("name")String name) {
      return serve.DeleteByName(name);
}
@PostMapping("/admin/user/addUsers")
public List<Userdetails> registerUsers(@RequestBody List<userRequest> u) {
	return  serve.addUsers(u);
}
@GetMapping("/admin/user/users")
public List<Userdetails> getUser() {
	
	return serve.getUsers();
	
}
}
//if(u.getUsername()!=null && u.getPassword()!=null )
//{
//
//  
// 
//}
//if(user == null) {
//  throw new Exception("Wrong credentials");
//}
