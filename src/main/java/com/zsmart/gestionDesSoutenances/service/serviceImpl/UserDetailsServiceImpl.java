package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zsmart.gestionDesSoutenances.bean.User;
import com.zsmart.gestionDesSoutenances.service.facade.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("No user Have this email: "+ email);
		} else {
			return new UserDetailsImpl(user);
		}
	}

}
