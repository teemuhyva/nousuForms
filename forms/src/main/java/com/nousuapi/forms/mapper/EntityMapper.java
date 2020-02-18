package com.nousuapi.forms.mapper;

import com.nousuapi.forms.admin.model.TeamLeaderResource;
import com.nousuapi.forms.entity.SignUp;
import com.nousuapi.forms.entity.TeamLeader;
import com.nousuapi.forms.signup.model.SignupResource;

public class EntityMapper {

	public static TeamLeader valueOf(TeamLeaderResource teamleader) {
		TeamLeader leader = new TeamLeader();
		leader.setFirstName(teamleader.getFirstName());
		leader.setLastName(teamleader.getLastName());
		leader.setTeam(teamleader.getTeam());
		
		return leader;
	}
	
	public static SignUp valueOf(SignupResource signUp) {
		SignUp sign = new SignUp();
		sign.setId(signUp.getRowId());
		sign.setDateOfBirth(signUp.getDateOfBirth());
		sign.setAddress(signUp.getAddress());
		sign.setPostNum(signUp.getPostNum());
		sign.setPostOffice(signUp.getPostOffice());
		sign.setEmail(signUp.getEmail());
		sign.setParentName(signUp.getParentName());
		sign.setChildName(signUp.getChildName());
		sign.setPhone(signUp.getPhone());
		sign.setAgeClass(signUp.getAgeClass());
		sign.setSignedUpFor(signUp.getSignedUpFor());
		sign.setPayment(signUp.getPayment());
		sign.setOther(signUp.getOther());
		
		return sign;
	}
}
