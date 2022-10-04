package com.project.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.demo.service.UsrService;
@Configuration
public class AppConfig extends WebSecurityConfigurerAdapter {

	
	@Value("${app.user.role}")
	private  String  user_role;
	@Value("${app.admin.role}")
	private  String  admin_role;
	@Value("${app.doctor.role}")
	private  String  doctor_role;
	
	@Autowired
	private UsrService userservice;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userservice).passwordEncoder(getPasswordEncryption());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	.csrf().disable()
		.authorizeRequests()
		.antMatchers("/**").permitAll()
		.antMatchers("/user/appointment/**").hasAuthority(user_role)
		.antMatchers(HttpMethod.POST,"/user/**").permitAll()
		.antMatchers(HttpMethod.PUT,"/user/**").hasAuthority(user_role)
		.antMatchers(HttpMethod.GET,"/user").hasAuthority(user_role)
		.antMatchers("/appointment/**").hasAuthority(user_role)
//		 this is user api auth for user entity
		.antMatchers("/admin/**").hasAuthority(admin_role)
//		this is api auth for admin role for user entity
		.antMatchers(" /doctor/prescription/**").hasAuthority(doctor_role)
		.antMatchers(HttpMethod.POST,"/doctor/**").permitAll()
		.antMatchers(HttpMethod.PUT,"/doctor/**").hasAuthority(doctor_role)
		.antMatchers(HttpMethod.GET,"/doctor").hasAuthority(doctor_role)
		.antMatchers(HttpMethod.GET,"/prescription/**").hasAnyAuthority(user_role,doctor_role)
		.antMatchers("/prescription/**").hasAuthority(doctor_role)
		.antMatchers("/login").permitAll()
//		   admin role
	
		.and().httpBasic();
		               
	}
   
	@Bean
	public  PasswordEncoder getPasswordEncryption() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return NoOpPasswordEncoder.getInstance();
//		return new BCryptPasswordEncoder();
	}
	
	
}
