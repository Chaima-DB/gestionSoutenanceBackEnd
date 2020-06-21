package com.zsmart.gestionDesSoutenances.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsmart.gestionDesSoutenances.bean.User;
import com.zsmart.gestionDesSoutenances.service.facade.UserService;

import io.swagger.annotations.Api;

@Api
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserRest {

	@Autowired
	UserService userService;

	@GetMapping("/email/{email}")
	public User findByEmail(@PathVariable String email) {
		return userService.findByEmail(email);
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to spring boot";
	}

	@GetMapping("public/users")
	public List<User> findAll() {
		return userService.findAll();
	}

	@PostMapping("/")
	public int save(@Validated @RequestBody User user) {
		return userService.save(user);
	}

	@PostMapping("/authenticate")
	public String authenticate(@RequestBody User user) {
		return userService.authenticate(user);
	}
}
