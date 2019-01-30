package com.nousuapi.forms.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nousuapi.forms.entity.Customer;

@Repository
public interface UserRepository extends JpaRepository<Customer, String> {

	@Query("SELECT u FROM Customer u WHERE u.fullName =:fullName")
	Customer findUserByFullName(String fullName);
	
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Customer u WHERE u.fullName =:fullName")
	void deleteByFullName(String fullName);
}
