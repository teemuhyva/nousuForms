package com.nousuapi.forms.entity;

import java.sql.Date;

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
	@NotNull
	private String location;
	
	//tournament field name
	@NotNull
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
	@NotNull
	private String leaderTeam;
	
	//date when person will be onsite
	//TODO: other date for when this info was entered / updated?
	@NotNull
	private Date date;
	
	//what time person will be onsite
	@NotNull
	private Date time;
	
}
