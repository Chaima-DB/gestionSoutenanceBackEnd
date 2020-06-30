package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zsmart.gestionDesSoutenances.bean.Role;
import com.zsmart.gestionDesSoutenances.bean.User;
import com.zsmart.gestionDesSoutenances.dao.UserDao;
import com.zsmart.gestionDesSoutenances.response.JwtResponse;
import com.zsmart.gestionDesSoutenances.security.JwtUtil;
import com.zsmart.gestionDesSoutenances.service.facade.RoleService;
import com.zsmart.gestionDesSoutenances.service.facade.UserService;

@Service
public class UserServiceImpl implements UserService {
        @Autowired
        UserDao userDao;
	@Autowired
	RoleService roleService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public int save(User user) {
		User founderUser = userDao.findByEmail(user.getEmail());
		if (founderUser != null) {
			return 0;
		} else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setIsEnabled(true);
			userDao.save(user);
			return 1;
		}
	}
	

	@Override
	public void addRoletouser(String email, String role) {
		Role roles = roleService.findByTitre(role);
		User user = userDao.findByEmail(email);
		user.getRoles().add(roles);
		
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public ResponseEntity<?> authenticate(User user) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails userDetails = new UserDetailsImpl(user);
		String jwt = JwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}

	

}
