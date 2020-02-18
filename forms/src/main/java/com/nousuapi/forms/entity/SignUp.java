package com.nousuapi.forms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "signup")
public class SignUp  {

	/*
	 * Table is for parents to signup their childs to football practise for season
	 */
	
	public SignUp() {
	}
			
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private long id;
	@NotNull
	private String dateOfBirth;
	@NotNull
	private String address;
	@NotNull
	private String email;
	@NotNull
	private int postNum;
	@NotNull
	private String postOffice;
	@NotNull
	private String parentName;
	@NotNull
	private String childName;
	@NotNull
	private String phone;
	@NotNull
	private String ageClass;
	@NotNull
	private String signedUpFor;
	
	private Double payment;
	private String other;
}
