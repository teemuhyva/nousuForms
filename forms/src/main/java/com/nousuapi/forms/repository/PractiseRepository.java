package com.nousuapi.forms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nousuapi.forms.entity.SignUpDao;

@Repository
public interface PractiseRepository extends JpaRepository<SignUpDao, String> {

	@Transactional
	@Query("SELECT u FROM SignUp u")
	List<SignUpDao> getUsers();
	
	@Transactional
	@Query("SELECT u FROM SignUp u WHERE u.id =:rowId")
	SignUpDao getSingleUserById(long rowId);

	@Transactional
	@Modifying
	@Query("DELETE FROM SignUp u WHERE u.id =:rowId")
	void deleteById(Long rowId);

}
