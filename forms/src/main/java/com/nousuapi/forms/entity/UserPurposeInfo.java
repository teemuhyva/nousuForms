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
@Getter
@Setter
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
	private String leaderFullName;
	
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
}
