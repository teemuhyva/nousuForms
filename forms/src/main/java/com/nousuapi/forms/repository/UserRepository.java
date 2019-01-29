package com.nousuapi.forms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nousuapi.forms.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	User findUserByFullName(String fullname);
}
