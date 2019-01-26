package com.nousuapi.forms.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USERPURPOSE")
@Getter
@Setter
public class UserPurpose {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "FIELD_NAME")
	private String fieldName;
	
	@Column(name = "PERSON_NAME")
	private String personName;
	
	@Column(name = "GAME_DATE")
	private Date date;
	
	@Column(name = "TIME")
	private Date time;
	
	public UserPurpose() {}
	
	public UserPurpose(String location, String fieldName, String personName, Date date, Date time) {
		this.location = location;
		this.fieldName = fieldName;
		this.personName = personName;
		this.date = date;
		this.time = time;
	}
}
