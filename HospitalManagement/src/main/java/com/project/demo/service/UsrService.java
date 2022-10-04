package com.project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.demo.repository.UserRepository;
import com.project.demo.repository.UsrRepository;
@Service
public class UsrService implements UserDetailsService {
     @Autowired
    private UsrRepository userrepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userrepo.findbyname(username);
	}

}
