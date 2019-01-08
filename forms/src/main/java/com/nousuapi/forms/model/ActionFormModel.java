package com.nousuapi.forms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionFormModel {

	private int ageClass;
	private int playersInTeam;
	private List<Clerks> clerks;
	private int practises;
	private List<String> summerPractisePlaces;
	private List<String> winterPractisePlaces;
	
	public ActionFormModel() {}
	
	public ActionFormModel(int ageClass, int playersInTeam, List<Clerks> clerks, 
							int practises, List<String> summerPractisePlaces, List<String> winterPractisePlaces) {
		this.ageClass = ageClass;
		this.clerks = clerks;
		this.practises = practises;
		this.summerPractisePlaces = summerPractisePlaces;
		this.winterPractisePlaces = winterPractisePlaces;
	}
}
