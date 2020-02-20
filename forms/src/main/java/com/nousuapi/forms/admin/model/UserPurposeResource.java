package com.nousuapi.forms.admin.model;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.nousuapi.forms.admin.AdminController;
import com.nousuapi.forms.enums.IlGroup;
import com.nousuapi.forms.enums.OnsiteDay;
import com.nousuapi.forms.enums.UserRole;
import com.nousuapi.forms.tournament.JklCupController;

import lombok.Data;

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
	private String phoneNumber;
	
	
	public UserPurposeResource() {}
	/*
	public static UserPurpose mapPurpose(UserPurposeResource userPurpose) {
		UserPurpose user = new UserPurpose();
		user.setUserId(userPurpose.getUserId());
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
	 */
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
			user.add(
					linkTo(AdminController.class).slash("updatepurpose").withRel("updatepurpose"),
					linkTo(AdminController.class).slash("deletepurpose").withRel("removepurpose")
			);
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
					linkTo(AdminController.class).slash("updatepurpose").withRel("updatepurpose"),
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public OnsiteDay getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(OnsiteDay weekDay) {
		this.weekDay = weekDay;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public IlGroup getIlGroup() {
		return ilGroup;
	}

	public void setIlGroup(IlGroup ilGroup) {
		this.ilGroup = ilGroup;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
