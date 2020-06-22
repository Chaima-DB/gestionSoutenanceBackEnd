package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsmart.gestionDesSoutenances.bean.Role;
import com.zsmart.gestionDesSoutenances.dao.RoleDao;
import com.zsmart.gestionDesSoutenances.service.facade.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDao roleDao;

	@Override
	public int save(Role role) {
		Role loadedRole = roleDao.findByTitre(role.getTitre());
		if (loadedRole != null) {
			return 0;
		} else {
			roleDao.save(role);
			return 1;
		}
	}

	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Override
	public Role findByTitre(String titre) {
		return roleDao.findByTitre(titre);
	}


}
