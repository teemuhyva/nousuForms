package com.nousuapi.forms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionFormModel {

	private String title;
	private int ageClass;
	private String firstParagraphCommon;
	private List<String> clerks;
	private int practises;
	private List<String> summerPractisePlaces;
	private List<String> winterPractisePlaces;
	
	public ActionFormModel(String title, int ageClass, String firstParagraphCommon, List<String> clerks, 
							int practises, List<String> summerPractisePlaces, List<String> winterPractisePlaces) {
		this.title = title;
		this.ageClass = ageClass;
		this.firstParagraphCommon = firstParagraphCommon;
		this.clerks = clerks;
		this.practises = practises;
		this.summerPractisePlaces = summerPractisePlaces;
		this.winterPractisePlaces = winterPractisePlaces;
	}
}
