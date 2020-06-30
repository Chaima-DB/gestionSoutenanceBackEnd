package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zsmart.gestionDesSoutenances.bean.User;
import com.zsmart.gestionDesSoutenances.dao.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userDao.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("No user Have this email: "+ email);
		} else {
			return new UserDetailsImpl(user);
		}
	}

}
