package com.nousuapi.forms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nousuapi.forms.entity.UserPurposeInfo;

@Repository
public interface UserPurposeRepository extends JpaRepository<UserPurposeInfo, String>{
	
	@Transactional
	@Modifying
	@Query("SELECT u FROM UserPurposeInfo u WHERE u.leaderFullName =:leaderFullName")	
	List<UserPurposeInfo> getPurposeByTeamLeader(String leaderFullName);
	
	@Transactional
	@Query("SELECT u FROM UserPurposeInfo u")
	List<UserPurposeInfo> listAll();
	
	@Transactional
	@Modifying
	@Query("DELETE FROM UserPurposeInfo  u WHERE u.personName =:personName and u.id =:id")
	void deleteGivenRow(String personName, long id);
}
