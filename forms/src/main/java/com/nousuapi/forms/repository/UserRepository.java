package com.nousuapi.forms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nousuapi.forms.entity.CustomerDao;
import com.nousuapi.forms.entity.SignUpDao;
import com.nousuapi.forms.entity.UserPurposeDao;

@Repository
public interface UserRepository extends JpaRepository<CustomerDao, String> {

	@Transactional
	@Query("SELECT u FROM Customer  u WHERE u.fullName =:fullName")
	CustomerDao findTeamLeaderByName(String fullName);
	
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Customer  u WHERE u.fullName =:fullName")
	void deleteByFullName(String fullName);
	
	@Transactional
	@Query("SELECT u FROM Customer u")
	List<CustomerDao> listTeamLeaders();
}
