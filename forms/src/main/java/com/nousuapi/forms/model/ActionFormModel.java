package com.nousuapi.forms.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionFormModel {

	private String ageClass;
	private String players;
	private List<String> headCoatch;
	private List<String> assistCoatch;
	private List<String> teamLeaders;
	private List<String> moneyManagers;
	private List<String> caringManager;
	private String practiseTimes;
	private List<String> winterPractise;
	private List<String> summerPractise;
	private List<String> practiceWeeks;
	private String practiseStory;
	private List<String> sportActivitySummer;
	private List<String> sportActivityWinter;
	private String totalSportsEvents;
	private List<String> sportsEventsPerMatch;
	private List<String> educationHeadCoatch;
	private List<String> educationAssistCoatch;
	private List<String> educationTeamLeader;
	private List<String> educationMoneyManager;
	private List<String> educationCaringManager;
	private List<String> somethingElseEducation;
	private List<String> parentEducation;
	private List<String> playerEducation;
	private String parentMeetings;
	private String ruleMeeting;
	private String otherEvents;
	private Date date;
	private String coatchSignature;
	private String teamManagerSignature;
	
	public ActionFormModel() {}
	
	public ActionFormModel(String ageClass, String players, List<String> headCoatch, List<String> assistCoatch, 
			List<String> teamLeaders, List<String> moneyManagers, List<String> caringManager, String practiseTimes, 
			List<String> summerPractise, List<String> winterPractise, List<String> practiceWeeks, String practiseStory,
			List<String> sportActivitySummer, List<String> sportActivityWinter, String totalSportsEvents, 
			List<String> sportsEventsPerMatch, List<String> educationHeadCoatch, List<String> educationAssistCoatch,
			List<String> educationTeamLeader, List<String> educationMoneyManager, List<String> educationCaringManager,
			List<String> somethingElseEducation, List<String> parentEducation, List<String> playerEducation, String parentMeetings,
			String ruleMeeting, String otherEvents, Date date, String coatchSignature, String teamManagerSignature) {
		this.ageClass = ageClass;
		this.players = players;
		this.headCoatch = headCoatch;
		this.assistCoatch = assistCoatch;
		this.teamLeaders = teamLeaders;
		this.moneyManagers = moneyManagers;
		this.caringManager = caringManager;
		this.practiseTimes = practiseTimes;
		this.summerPractise = summerPractise;
		this.winterPractise = winterPractise;
		this.practiceWeeks =practiceWeeks;
		this.practiseStory = practiseStory;
		this.sportActivitySummer = sportActivitySummer;
		this.sportActivityWinter = sportActivityWinter;
		this.totalSportsEvents = totalSportsEvents;
		this.sportsEventsPerMatch = sportsEventsPerMatch;
		this.educationHeadCoatch = educationHeadCoatch;
		this.educationAssistCoatch = educationAssistCoatch;
		this.educationTeamLeader = educationTeamLeader;
		this.educationMoneyManager = educationMoneyManager;
		this.educationCaringManager = educationCaringManager;
		this.somethingElseEducation = somethingElseEducation;
		this.parentEducation = parentEducation;
		this.playerEducation = playerEducation;
		this.parentMeetings = parentMeetings;
		this.ruleMeeting = ruleMeeting;
		this.otherEvents = otherEvents;
		this.date = date;
		this.coatchSignature = coatchSignature;
		this.teamManagerSignature = teamManagerSignature;
	}
}
