package com.nousuapi.forms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clerks {

	private List<String> headCoatch;
	private List<String> assistCoatch;
	private List<String> manager;
		
	public Clerks() {};
	
	public Clerks(List<String> headCoatch, List<String> assistCoatch, List<String> manager) {
		this.headCoatch = headCoatch;
		this.assistCoatch = assistCoatch;
		this.manager = manager;
	}
}
