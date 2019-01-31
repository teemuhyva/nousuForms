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
	
	@NotNull
	private String location;
	
	@NotNull
	private String fieldName;
	
	@NotNull
	private String personName;
	
	@NotNull
	private String leaderFirstName;
	
	@NotNull
	private String leaderLastName;
	
	@NotNull
	private String leaderTeam;
	
	@NotNull
	private Date date;
	
	@NotNull
	private Date time;
	
}
