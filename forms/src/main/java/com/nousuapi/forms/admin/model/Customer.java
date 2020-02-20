package com.nousuapi.forms.admin.model;

import java.util.List;

public class Customer {
	
	private long userId;
	private String teamLeader;
	private String email;
	private String phone;
	private String team;
	private List<UserPurpose> userPurpose;
	
	public Customer() {}
	
	public Customer(long userId, String teamLeader, String email, String phone, String team,
			List<UserPurpose> userPurpose) {
		super();
		this.userId = userId;
		this.teamLeader = teamLeader;
		this.email = email;
		this.phone = phone;
		this.team = team;
		this.userPurpose = userPurpose;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team1) {
		team = team1;
	}

	public List<UserPurpose> getUserPurpose() {
		return userPurpose;
	}

	public void setUserPurpose(List<UserPurpose> userPurpose) {
		this.userPurpose = userPurpose;
	}

}
