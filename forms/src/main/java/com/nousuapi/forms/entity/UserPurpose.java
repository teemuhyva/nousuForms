package com.nousuapi.forms.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

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
	private String location;
	private String fieldName;
	private String personName;
	private String leaderFirstName;
	private String leaderLastName;
	private String leaderLocation;
	private Date date;
	private Date time;
	
	/*
	public UserPurpose(String location, String fieldName, String personName, Date date, Date time,
			String leaderFirstName, String leaderLastName, String leaderLocation) {
		this.location = location;
		this.fieldName = fieldName;
		this.personName = personName;
		this.date = date;
		this.time = time;
		this.leaderFirstName = leaderFirstName;
		this.leaderLastName = leaderLastName;
		this.leaderLocation = leaderLocation;
	}
	*/
}
