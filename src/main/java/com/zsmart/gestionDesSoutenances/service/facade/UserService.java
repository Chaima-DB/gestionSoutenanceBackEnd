package com.zsmart.gestionDesSoutenances.service.facade;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.zsmart.gestionDesSoutenances.bean.User;

public interface UserService extends UserDetailsService {

	int save(User user);

	List<User> findAll();

	User findByEmail(String email);
	public void addRoletouser(String email , String role);
	ResponseEntity<?> authenticate(User user);

}
