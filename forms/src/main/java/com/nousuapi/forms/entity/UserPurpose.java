package com.nousuapi.forms.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.nousuapi.forms.enums.IlGroup;
import com.nousuapi.forms.enums.Location;
import com.nousuapi.forms.enums.UserRole;

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
	@NotNull
	@Enumerated(EnumType.STRING)
	private Location location;
	
	//tournament field name
	private String fieldName;
	
	//name of user (not leader)	
	@NotNull
	private String personName;
	
	//teamleader (who will assign persons in purpose)
	@NotNull
	private String leaderFirstName;
	
	@NotNull
	private String leaderLastName;
	
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
	
	private Date updatedTime;
	
	private Date dayOnsite;
	
	//what time person will be onsite
	private Date startTime;
	
	private Date endTime;
}
