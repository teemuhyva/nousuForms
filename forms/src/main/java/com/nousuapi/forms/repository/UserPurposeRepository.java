package com.nousuapi.forms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nousuapi.forms.admin.model.UserPurposeResource;
import com.nousuapi.forms.entity.UserPurposeInfo;
import com.nousuapi.forms.enums.Location;
import com.nousuapi.forms.enums.OnsiteDay;
import com.nousuapi.forms.enums.UserRole;

@Repository
public interface UserPurposeRepository extends JpaRepository<UserPurposeInfo, String>{
	
	@Transactional
	@Modifying
	@Query("SELECT u FROM UserPurposeInfo u WHERE u.teamLeader =:leaderFullName")
	List<UserPurposeInfo> getPurposeByTeamLeader(String leaderFullName);
	
	@Transactional
	@Query("SELECT u FROM UserPurposeInfo u WHERE u.personName =:personName and u.userRole =:userRole and u.phoneNumber =:phoneNumber and u.startTime =:startTime and u.weekDay =:weekDay")
	UserPurposeInfo getUserByGivenInfo(String personName, UserRole userRole, String phoneNumber, String startTime, OnsiteDay weekDay);
	
	@Transactional
	@Query("SELECT u FROM UserPurposeInfo u")
	List<UserPurposeInfo> listAll();
	
	@Transactional
	@Modifying	
	@Query("DELETE FROM UserPurposeInfo  u WHERE u.personName =:personName and u.id =:id")
	void deleteGivenRow(String personName, long id);
	
	/*
	@Transactional
	@Modifying	
	@Query("UPDATE UserPurposeInfo u WHERE u.personName =:personName and u.leaderTeam =:leaderTeam and u.ilGroup =:ilGroup and u.phoneNumber =:phoneNumber and u.teamLeader =:teamLeader")
	void updateuserPurposeRow(String personName, String leaderTeam, String ilGroup, String phoneNumber, String teamLeader);
	*/
}
