package com.nousuapi.forms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nousuapi.forms.entity.UserPurpose;

@Repository
public interface UserPurposeRepository extends JpaRepository<UserPurpose, String>{
	
	@Transactional
	@Modifying
	@Query("SELECT u FROM UserPurpose u WHERE u.leaderFirstName =:leaderFirstName AND u.leaderLastName =:leaderLastName")	
	List<UserPurpose> getPurposeByTeamLeader(String leaderFirstName, String leaderLastName);
	
	@Transactional
	@Query("SELECT u FROM UserPurpose u")
	List<UserPurpose> listAll();
	
}
