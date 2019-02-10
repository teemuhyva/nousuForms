package com.nousuapi.forms.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userpurpose")
public class UserPurpose {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//where user is located during tournament
	
	private String location;
	
	//tournament field name
	private String fieldName;
	
	//name of user (not leader)
	
	private String personName;
	
	//teamleader (who will assign persons in purpose)
	
	private String leaderFirstName;
	
	
	private String leaderLastName;
	
	//leader team
	
	private String leaderTeam;
	
	
	private String phoneNumber;
	
	private String ilGroup;
	//date when person will be onsite
	//TODO: other date for when this info was entered / updated?
	
	private String userRole;
	
	private Date updatedTime;
	
	private Date dayOnsite;
	
	//what time person will be onsite
	private Date startTime;
	
	private Date endTime;
}
