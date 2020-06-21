package com.zsmart.gestionDesSoutenances.request;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestUser {

	private String email;

	private String password;

	private Boolean isEnabled;

	private Set<String> roles;

	public String getEmail() {
		return email;
	}

}
