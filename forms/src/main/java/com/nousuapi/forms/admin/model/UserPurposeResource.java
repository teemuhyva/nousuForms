package com.nousuapi.forms.admin.model;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.nousuapi.forms.admin.AdminController;
import com.nousuapi.forms.entity.UserPurposeInfo;
import com.nousuapi.forms.enums.IlGroup;
import com.nousuapi.forms.enums.OnsiteDay;
import com.nousuapi.forms.enums.UserRole;
import com.nousuapi.forms.tournament.JklCupController;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPurposeResource  extends ResourceSupport {

	private long userId;
	private String location;
	private String fieldName;
	private OnsiteDay weekDay;
	private String personName;
	private UserRole userRole;
	private String successMessage;
	private IlGroup ilGroup;
	private String startTime;
	private String endTime;
	private String teamLeader;
	private String team;
	private String phoneNumber;
	
	public List<UserPurposeResource> mapList(List<UserPurposeInfo> userPurpose) {
		List<UserPurposeResource> resultList = new ArrayList<UserPurposeResource>();
		
		for(UserPurposeInfo up : userPurpose) {
			UserPurposeResource result = new UserPurposeResource();
			result.setUserId(up.getId());
			result.setLocation(up.getLocation().toString());
			result.setWeekDay(up.getWeekDay());
			result.setIlGroup(up.getIlGroup());
			result.setPersonName(up.getPersonName());
			result.setTeamLeader(up.getTeamLeader());
			result.setTeam(up.getLeaderTeam());
			result.setUserRole(up.getUserRole());
			result.setPhoneNumber(up.getPhoneNumber());
			result.setStartTime(up.getStartTime());
			result.setEndTime(up.getEndTime());
			result.add(
				linkTo(JklCupController.class).slash("updatepurpose")
												.slash(up.getId())
												.withRel("updatepurpose"),
				linkTo(AdminController.class).slash("removeuserfromrole").slash(up.getId()).withRel("removepurpose")
			);
			
			resultList.add(result);
			
		}
		
		return resultList;
	}
	
	public static UserPurposeResource getMessage() {
		UserPurposeResource message = new UserPurposeResource();
		message.setSuccessMessage("Päivitys onnistui");
		return message;
	}
}
