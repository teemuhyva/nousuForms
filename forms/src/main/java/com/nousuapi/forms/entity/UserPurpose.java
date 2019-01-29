package com.nousuapi.forms.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userpurpose")
public class UserPurpose {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;	
	private String location;
	private String fieldName;
	private String personName;
	private Date date;
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
