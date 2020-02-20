package com.nousuapi.forms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.nousuapi.forms.enums.IlGroup;
import com.nousuapi.forms.enums.OnsiteDay;
import com.nousuapi.forms.enums.UserRole;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "userpurposeinfo")
public class UserPurposeInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private long id;
	
	//where user is located during tournament
	@NotNull
	//@Enumerated(EnumType.STRING)
	private String location;
	
	//name of user (not leader)	
	@NotNull
	private String personName;
	
	//teamleader (who will assign persons in purpose)
	@NotNull
	private String teamLeader;
	
	//leader team
	private String leaderTeam;
	
	
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	private IlGroup ilGroup;
	//date when person will be onsite
	//TODO: other date for when this info was entered / updated?
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private OnsiteDay weekDay;
		
	//what time person will be onsite
	private String startTime;
	
	private String endTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getLeaderTeam() {
		return leaderTeam;
	}

	public void setLeaderTeam(String leaderTeam) {
		this.leaderTeam = leaderTeam;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public IlGroup getIlGroup() {
		return ilGroup;
	}

	public void setIlGroup(IlGroup ilGroup) {
		this.ilGroup = ilGroup;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
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
	
	
}
