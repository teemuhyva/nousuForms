package com.nousuapi.forms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nousuapi.forms.entity.TeamLeader;

@Repository
public interface UserRepository extends JpaRepository<TeamLeader, String> {

	@Transactional
	@Query("SELECT u FROM TeamLeader u WHERE u.fullName =:fullName")
	TeamLeader findTeamLeaderByName(String fullName);
	
	
	@Transactional
	@Modifying
	@Query("DELETE FROM TeamLeader u WHERE u.fullName =:fullName")
	void deleteByFullName(String fullName);
	
	@Transactional
	@Query("SELECT u FROM TeamLeader u")
	List<TeamLeader> listTeamLeaders();
}
