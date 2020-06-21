package com.zsmart.gestionDesSoutenances.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zsmart.gestionDesSoutenances.bean.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {

	public Role findByTitre(String titre);

	public List<Role> findAll();
}
