package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zsmart.gestionDesSoutenances.bean.User;
import com.zsmart.gestionDesSoutenances.dao.UserDao;
import com.zsmart.gestionDesSoutenances.security.JwtUtil;
import com.zsmart.gestionDesSoutenances.service.facade.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public int save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User foundedUser = userDao.findByEmail(user.getEmail());
		if (foundedUser != null) {
			return -1;
		} else {
			userDao.save(user);
			return 1;
		}
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public String authenticate(User user) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		} catch (Exception e) {
			return "Bad Creditienl for " + user.getEmail() + e;
		}
		UserDetails userDetails = loadUserByUsername(user.getEmail());
		return JwtUtil.generateToken(userDetails);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userDao.findByEmail(email);
	}


}
