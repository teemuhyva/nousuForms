package com.nousuapi.forms.entity;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	
	private String fullName;
	
	@NotNull
	private String team;
}