package com.nousuapi.forms.admin.model;

import java.util.Date;

import com.nousuapi.forms.enums.IlGroup;
import com.nousuapi.forms.enums.OnsiteDay;
import com.nousuapi.forms.enums.UserRole;

public class UserPurpose {

	private long userId;
	private String location;
	private String fieldName;
	private OnsiteDay weekDay;
	private String startTime;
	private String endTime;
	private String personName;
	private String teamLeader;
	private UserRole userRole;
	private String successMessage;
	private IlGroup ilGroup;
	private String phoneNumber;
	
	public UserPurpose() {}
	
	public UserPurpose(long userId, String location, String fieldName, OnsiteDay weekDay, String startTime, String endTime, String personName,
			String teamLeader, UserRole userRole, String successMessage, IlGroup ilGroup, String phoneNumber) {
		super();
		this.userId = userId;
		this.location = location;
		this.fieldName = fieldName;
		this.weekDay = weekDay;
		this.startTime = startTime;
		this.endTime = endTime;
		this.personName = personName;
		this.userRole = userRole;
		this.successMessage = successMessage;
		this.ilGroup = ilGroup;
		this.teamLeader = teamLeader;
		this.phoneNumber = phoneNumber;
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
	public void setITeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
