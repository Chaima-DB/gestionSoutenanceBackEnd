package com.zsmart.gestionDesSoutenances.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zsmart.gestionDesSoutenances.bean.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
	public User findByEmail(String email);
	public List<User> findAll();

}
