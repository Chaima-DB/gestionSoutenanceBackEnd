package com.zsmart.gestionDesSoutenances.service.facade;

import java.util.List;

import com.zsmart.gestionDesSoutenances.bean.Role;

public interface RoleService {

	public Role findByTitre(String string);

	int save(Role role);

	public List<Role> findAll();

}
