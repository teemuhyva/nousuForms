package com.nousuapi.forms.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nousuapi.forms.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query("SELECT u FROM User u WHERE u.fullName =:fullName")
	User findUserByFullName(String fullName);
	
	
	@Transactional
	@Modifying
	@Query("DELETE FROM User u WHERE u.fullName =:fullName")
	void deleteByFullName(String fullName);
}
