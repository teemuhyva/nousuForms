package com.nousuapi.forms.createform;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ListIterator;

import javax.mail.MessagingException;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.Text;
import org.json.JSONArray;
import org.json.JSONException;

import com.nousuapi.forms.helpers.DocumentHelperUtil;
import com.nousuapi.forms.model.ActionFormModelResource;

public class CreateActionPlan {
	
	public void generateActionPlan(WordprocessingMLPackage template, List<ActionFormModelResource> actionPlan) throws  Docx4JException, MessagingException, FileNotFoundException, IOException, JSONException {
		DocumentHelperUtil docs = new DocumentHelperUtil();		
		JSONArray jsonModelObject =  docs.generateJsonFromForm(actionPlan);		
		DocumentHelperUtil docHelper = new DocumentHelperUtil();
		List<Object> texts = docHelper.getAllElementFromObject(template.getMainDocumentPart(), Text.class);
		
		int currentIndex = 0;
		  
	  	ListIterator<Object> wordTextIterator = texts.listIterator();
	  	do {
	  		if(wordTextIterator.hasNext()) {
	  			wordTextIterator.next();
	  		}
	  		
	  		currentIndex = wordTextIterator.nextIndex();
	  		//ikäluokka
	  		if(currentIndex == 7) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "ageClass"));
	  		}
	  		
	  		//pelaaja lukumäärä
	  		if(currentIndex == 12) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "players"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 20) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "headCoatch"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 22) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "headCoatch2"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 25) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "assistCoatch"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 27) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "assistCoatch2"));
	  		}
	  				  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 30) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "teamLeaders"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 32) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "teamLeaders2"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 35) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "moneyManagers"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 37) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "moneyManagers2"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 40) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "caringManager"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 42) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "caringManager2"));
	  		}	  		
	  			  		
	  		//harjoittelu
	  		if(currentIndex == 46) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "practiseTimes"));
	  		}
	  		
	  		//kesäharjoittelupaikat
	  		if(currentIndex == 53) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "summerPractise"));
	  		}
	  		
	  		//kesäharjoittelupaikat
	  		if(currentIndex == 55) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "summerPractise2"));
	  		}
	  		//kesäharjoittelupaikat
	  		if(currentIndex == 57) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "summerPractise3"));
	  		}
	  		//kesäharjoittelupaikat
	  		if(currentIndex == 59) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "summerPractise4"));
	  		}
	  		//talviharjoittelupaikat
	  		if(currentIndex == 62) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "winterPractise"));
	  		}
	  		//talviharjoittelupaikat
	  		if(currentIndex == 64) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "winterPractise2"));
	  		}
	  		//talviharjoittelupaikat
	  		if(currentIndex == 66) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "winterPractise3"));
	  		}
	  		//talviharjoittelupaikat
	  		if(currentIndex == 68) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "winterPractise4"));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 72) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "practiceWeeks"));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 76) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "practiceWeeks2"));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 80) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "practiceWeeks3"));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 85) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "practiceWeeks4"));
	  		}
	  		//harjoittelutarina
	  		if(currentIndex == 91) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "practiseStory"));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 97) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "sportActivitySummer"));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 101) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "sportActivitySummer2"));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 106) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "sportActivityWinter"));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 110) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "sportActivityWinter2"));
	  		}
	  		//turnauksien lukumäärä menneenä kalenteri vuonna
	  		if(currentIndex == 115) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "totalSportsEvents"));
	  		}
	  		//sarja ja turnausotteluiden lukumäärä
	  		if(currentIndex == 120) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "sportsEventsPerMatch"));
	  		}
	  		//sarja ja turnausotteluiden lukumäärä
	  		if(currentIndex == 124) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "sportsEventsPerMatch2"));
	  		}
	  		//sarja ja turnausotteluiden lukumäärä
	  		if(currentIndex == 128) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "sportsEventsPerMatch3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 138) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "educationHeadCoatch"));
	  		}
	  		//koulutus
	  		if(currentIndex == 140) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "educationHeadCoatch2"));
	  		}
	  		//koulutus
	  		if(currentIndex == 142) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "educationHeadCoatch3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 145) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "educationAssistCoatch"));
	  		}
	  		//koulutus
	  		if(currentIndex == 147) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "educationAssistCoatch2"));
	  		}
	  		//koulutus
	  		if(currentIndex == 149) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "educationAssistCoatch3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 152) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "educationTeamLeader"));
	  		}
	  		//koulutus
	  		if(currentIndex == 154) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "educationTeamLeader2"));
	  		}
	  		//koulutus
	  		if(currentIndex == 156) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "educationTeamLeader3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 159) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "educationMoneyManager"));
	  		}
	  		//koulutus
	  		if(currentIndex == 161) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "educationMoneyManager2"));
	  		}
	  		//koulutus
	  		if(currentIndex == 163) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "educationMoneyManager3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 166) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "educationCaringManager"));
	  		}
	  		//koulutus
	  		if(currentIndex == 168) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "educationCaringManager2"));
	  		}
	  		//koulutus
	  		if(currentIndex == 170) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "educationCaringManager3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 173) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "somethingElseEducation"));
	  		}
	  	//koulutus
	  		if(currentIndex == 175) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "somethingElseEducation2"));
	  		}
	  	//koulutus
	  		if(currentIndex == 177) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "somethingElseEducation3"));
	  		}
	  	//koulutus
	  		if(currentIndex == 180) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "parentEducation"));
	  		}
	  	//koulutus
	  		if(currentIndex == 183) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "parentEducation2"));
	  		}
	  	//koulutus
	  		if(currentIndex == 186) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "playerEducation"));
	  		}
	  	//koulutus
	  		if(currentIndex == 189) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "playerEducation2"));
	  		}
	  		//joukkueen muut tapahtumat
	  		if(currentIndex == 195) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "parentMeetings"));
	  		}
	  		//joukkueen muut tapahtumat
	  		if(currentIndex == 199) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(docs.loopJsonObjectToGetValue(jsonModelObject, "ruleMeeting"));
	  		}
	  		//muut toiminta
	  		if(currentIndex == 204) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.now();
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(dtf.format(localDate));
	  		}
  			
	  	} while(currentIndex < 205);
  		
	  docs.writeDocxToStream(template, "Toimintasuunnitelma2.docx");
	}
}
