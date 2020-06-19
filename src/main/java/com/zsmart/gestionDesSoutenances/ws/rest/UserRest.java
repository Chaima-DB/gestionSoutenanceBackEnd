package com.zsmart.gestionDesSoutenances.ws.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsmart.gestionDesSoutenances.bean.User;
import com.zsmart.gestionDesSoutenances.service.facade.UserService;


@RestController
@RequestMapping("/")
public class UserRest {
	@Autowired
	UserService userService ;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userService.loadUserByUsername(username);
	}

	@GetMapping("public/users")
	public List<User> findAll() {
		return userService.findAll();
	}

   @PostMapping("/save")
   public int save(@RequestBody User user) {
       return userService.save(user);
   }
   
   @PostMapping("/authenticate")
   public String authenticate(@RequestBody User user) {
		return userService.authenticate(user);
	}
}
