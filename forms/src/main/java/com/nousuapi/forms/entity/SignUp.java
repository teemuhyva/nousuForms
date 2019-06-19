package com.nousuapi.forms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "signup")
public class SignUp {

	/*
	 * Table is for parents to signup their childs to football practise for season
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private long id;
	@NotNull
	private String email;
	@NotNull
	private String parentName;
	@NotNull
	private String childName;
	@NotNull
	private String phone;
	@NotNull
	private String ageClass;
}
