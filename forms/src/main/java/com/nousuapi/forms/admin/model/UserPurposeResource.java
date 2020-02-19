package com.nousuapi.forms.admin.model;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.nousuapi.forms.admin.AdminController;
import com.nousuapi.forms.enums.IlGroup;
import com.nousuapi.forms.enums.OnsiteDay;
import com.nousuapi.forms.enums.UserRole;
import com.nousuapi.forms.tournament.JklCupController;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserPurposeResource  extends ResourceSupport {

	private long userId;
	private String location;
	private String fieldName;
	private OnsiteDay weekDay;
	private String startTime;
	private String endTime;
	private String personName;
	private UserRole userRole;
	private String successMessage;
	private IlGroup ilGroup;
	private String teamLeader;
	
	
	public static UserPurpose mapPurpose(UserPurposeResource userPurpose) {
		UserPurpose user = new UserPurpose();
		user.setFieldName(userPurpose.getFieldName());
		user.setIlGroup(userPurpose.getIlGroup());
		user.setLocation(userPurpose.getLocation());
		user.setPersonName(userPurpose.getPersonName());
		user.setStartTime(userPurpose.getStartTime());
		user.setEndTime(userPurpose.getEndTime());
		user.setUserId(userPurpose.getUserId());
		user.setUserRole(userPurpose.getUserRole());
		user.setWeekDay(userPurpose.getWeekDay());
		user.setTeamLeader(userPurpose.getTeamLeader());
		return user;
	}
	 
	public static List<UserPurpose> mapUserPurposeList(List<Customer> customerList) {
		List<UserPurpose> resultList = new ArrayList<UserPurpose>();
		
		for (Customer userPurpose : customerList) {
			for (UserPurpose userPurpose2 : userPurpose.getUserPurpose()) {
				UserPurpose user = new UserPurpose();
				user.setFieldName(userPurpose2.getFieldName());
				user.setIlGroup(userPurpose2.getIlGroup());
				user.setLocation(userPurpose2.getLocation());
				user.setPersonName(userPurpose2.getPersonName());
				user.setStartTime(userPurpose2.getStartTime());
				user.setEndTime(userPurpose2.getEndTime());
				user.setUserId(userPurpose2.getUserId());
				user.setUserRole(userPurpose2.getUserRole());
				user.setWeekDay(userPurpose2.getWeekDay());
				user.setTeamLeader(userPurpose2.getTeamLeader());
				resultList.add(user);
			}
			
		}
		
		return resultList;
	}
	
	public static List<UserPurposeResource> mapPurposeList(List<UserPurpose> userPurposeList) {
		List<UserPurposeResource> resultList = new ArrayList<UserPurposeResource>();
		
		for (UserPurpose userPurpose : userPurposeList) {
			UserPurposeResource user = new UserPurposeResource();
			user.setFieldName(userPurpose.getFieldName());
			user.setIlGroup(userPurpose.getIlGroup());
			user.setLocation(userPurpose.getLocation());
			user.setPersonName(userPurpose.getPersonName());
			user.setStartTime(userPurpose.getStartTime());
			user.setEndTime(userPurpose.getEndTime());
			user.setUserId(userPurpose.getUserId());
			user.setUserRole(userPurpose.getUserRole());
			user.setWeekDay(userPurpose.getWeekDay());
			user.setTeamLeader(userPurpose.getTeamLeader());
			resultList.add(user);
		}
		
		return resultList;
	}
	
	public static List<UserPurposeResource> mapUserPurpose(Customer userPurpose) {
		List<UserPurposeResource> resultList = new ArrayList<UserPurposeResource>();
		
		for(UserPurpose up : userPurpose.getUserPurpose()) {
			if(up.getPersonName() != null) {
				UserPurposeResource result = new UserPurposeResource();
				result.setUserId(up.getUserId());
				result.setLocation(up.getLocation().toString());
				result.setWeekDay(up.getWeekDay());
				result.setIlGroup(up.getIlGroup());
				result.setPersonName(up.getPersonName());
				result.setUserRole(up.getUserRole());
				result.setStartTime(up.getStartTime());
				result.setEndTime(up.getEndTime());
				result.add(
					linkTo(JklCupController.class).slash("updatepurpose").withRel("updatepurpose"),
					linkTo(AdminController.class).slash("deletepurpose").withRel("removepurpose")
				);
				resultList.add(result);
			}
			
		}
		
		return resultList;
	}
	
	public static UserPurposeResource getMessage() {
		UserPurposeResource message = new UserPurposeResource();
		message.setSuccessMessage("Päivitys onnistui");
		return message;
	}
}
