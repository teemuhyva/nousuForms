package com.nousuapi.forms.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nousuapi.forms.entity.UserPurposeInfo;
import com.nousuapi.forms.enums.IlGroup;
import com.nousuapi.forms.enums.OnsiteDay;
import com.nousuapi.forms.enums.UserRole;

@Repository
public interface UserPurposeRepository extends JpaRepository<UserPurposeInfo, String>{
	
	@Transactional
	@Modifying
	@Query("SELECT u FROM UserPurposeInfo u WHERE u.teamLeader =:leaderFullName")
	List<UserPurposeInfo> getPurposeByTeamLeader(String leaderFullName);
	
	@Transactional
	@Query("SELECT u FROM UserPurposeInfo u WHERE userid =:id")
	UserPurposeInfo getUserByGivenInfo(long id);
	
	@Transactional
	@Query("SELECT u FROM UserPurposeInfo u")
	List<UserPurposeInfo> listAll();
	
	@Transactional
	@Modifying	
	@Query("DELETE FROM UserPurposeInfo  u WHERE u.personName =:personName and u.id =:id")
	void deleteGivenRow(String personName, long id);
	
	@Transactional
	@Modifying	
	@Query("UPDATE UserPurposeInfo u SET u.personName =:personName, u.ilGroup =:ilGroup, u.phoneNumber =:phoneNumber, u.teamLeader =:teamLeader WHERE userid =:id")
	void updateFields(String personName, String teamLeader, String phoneNumber, IlGroup ilGroup, long id);
	
}
