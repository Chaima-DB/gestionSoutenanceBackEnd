package com.zsmart.gestionDesSoutenances.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsmart.gestionDesSoutenances.bean.Role;
import com.zsmart.gestionDesSoutenances.dao.RoleDao;
import com.zsmart.gestionDesSoutenances.service.facade.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleDao roleDao;
	@Override
	public Role findByTitre(String titre) {
		return roleDao.findByTitre(titre);
	}

}
