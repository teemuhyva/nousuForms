package com.nousuapi.forms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nousuapi.forms.entity.TeamLeader;

@Repository
public interface TeamLeaderRepository extends JpaRepository<TeamLeader, String> {
	
}