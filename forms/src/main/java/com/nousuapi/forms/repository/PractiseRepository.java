package com.nousuapi.forms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.nousuapi.forms.entity.SignUpUser;

@Repository
public interface PractiseRepository extends JpaRepository<SignUpUser, String> {

	@Transactional
	@Query("SELECT u FROM SignUpUser u")
	List<SignUpUser> getUsers();
	
	@Transactional
	@Query("SELECT u FROM SignUpUser u WHERE u.signedUpFor =: signedUpFor")
	List<SignUpUser> getUsers(String signedUpFor);
	
	@Transactional
	@Query("SELECT u FROM SignUpUser u WHERE u.id =:rowId")
	SignUpUser getSingleUserById(long rowId);

	@Transactional
	@Modifying
	@Query("DELETE FROM SignUpUser u WHERE u.id =:rowId")
	void deleteById(Long rowId);

}
