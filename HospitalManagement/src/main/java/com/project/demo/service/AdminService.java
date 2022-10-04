package com.project.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.demo.encryption.EncryptPassword;
import com.project.demo.model.Admin;
import com.project.demo.model.User;
import com.project.demo.model.Userdetails;
import com.project.demo.repository.AdminRepository;
import com.project.demo.repository.UsrRepository;
import com.project.demo.requests.AdminRequest;
import com.project.demo.requests.userRequest;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminrepo;
	@Autowired
	private UsrRepository user;
	@Value("${app.admin.role}")
	private String Adminrole;
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private EncryptPassword encod;
public Admin getAdmin() {
	Authentication a=SecurityContextHolder.getContext().getAuthentication();
	User u=(User)a.getPrincipal();
	int id=u.getAdmin().getAdminid();
	return adminrepo.findbyid(id);
}
@Transactional
public void addAdmin(AdminRequest admin)throws Exception {
	  Admin a=admin.toAdmin();
	  a=adminrepo.save(a);
	  User u=new User();
	  u.setAdmin(a);
	  u.setAuthorities(Adminrole);
	  u.setUsername(a.getEmail());
	  u.setPassword(encoder.encode(encod.methodEncrypt(admin.getPassword(), false))   );
	 u= user.save(u);
	  a.setUser(u);
	  adminrepo.save(a);
	  
		
	}

}
