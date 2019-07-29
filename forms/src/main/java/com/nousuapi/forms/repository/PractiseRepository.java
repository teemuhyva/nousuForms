package com.nousuapi.forms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nousuapi.forms.entity.SignUp;

@Repository
public interface PractiseRepository extends JpaRepository<SignUp, String> {

	@Transactional
	@Query("SELECT u FROM SignUp u")
	List<SignUp> getUsers();
		
	@Transactional
	@Modifying
	@Query("DELETE FROM SignUp u WHERE u.dateOfBirth =:dateOfBirth and u.email =:email and u.childName =:childName")
	void deleteSignedUpChildern(String dateOfBirth, String childName, String email);
}
