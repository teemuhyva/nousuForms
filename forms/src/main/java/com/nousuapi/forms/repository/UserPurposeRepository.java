package com.nousuapi.forms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nousuapi.forms.admin.model.UserPurposeResource;
import com.nousuapi.forms.entity.UserPurpose;
import com.nousuapi.forms.enums.Location;
import com.nousuapi.forms.enums.UserRole;

@Repository
public interface UserPurposeRepository extends JpaRepository<UserPurpose, String>{
	
	@Transactional
	@Modifying
	@Query("SELECT u FROM UserPurpose u WHERE u.leaderFullName =:leaderFullName")	
	List<UserPurpose> getPurposeByTeamLeader(String leaderFullName);
	
	@Transactional
	@Query("SELECT u FROM UserPurpose u")
	List<UserPurpose> listAll();
	
	@Transactional
	@Modifying
	@Query("DELETE FROM UserPurpose  u WHERE u.personName =:personName and u.id =:id")
	void deleteGivenRow(String personName, long id);
}
