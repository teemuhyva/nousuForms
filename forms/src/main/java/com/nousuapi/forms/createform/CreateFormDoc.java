package com.nousuapi.forms.createform;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.xml.bind.JAXBElement;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Text;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nousuapi.forms.model.ActionFormModel;

public class CreateFormDoc {

	public WordprocessingMLPackage getTemplate(String name) throws FileNotFoundException, Docx4JException {
		WordprocessingMLPackage template = WordprocessingMLPackage.load(new FileInputStream(new File(name)));
		return template;
	}

	//gets all word elements to list of objects
	public static List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {
		List<Object> result = new ArrayList<Object>();
		  if(obj instanceof JAXBElement) {
			  obj = ((JAXBElement<?>) obj).getValue();
		  }
		  
		  if(obj.getClass().equals(toSearch)) {
			  result.add(obj);  
		
		  } else if (obj instanceof ContentAccessor) {
		   List<?> children = ((ContentAccessor) obj).getContent(); 
		   
			   for (Object child : children) {
				    result.addAll(getAllElementFromObject(child, toSearch));
			   }
		  }
		  return result;
	  }
		  
	public void populateWord(WordprocessingMLPackage template, ActionFormModel actionForm) throws IOException, Docx4JException {
	  JSONObject jsonModelObject =  generateJsonFromForm(actionForm);
	  List<Object> texts = getAllElementFromObject(template.getMainDocumentPart(), Text.class);
	  
	  	ListIterator<Object> wordTextIterator = texts.listIterator();
	  	while(wordTextIterator.hasNext()) {
	  		int currentIndex = wordTextIterator.nextIndex();
	  		
	  		//ikäluokka
	  		if(currentIndex == 3) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "ageClass"));
	  		}
	  		
	  		//pelaaja lukumäärä
	  		if(currentIndex == 12) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "players"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 18) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "headCoatch", 0));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 24) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "headCoatch", 1));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 31) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "assistCoatch", 0));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 37) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "assistCoatch", 1));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 44) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "assistCoatch", 2));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 50) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "assistCoatch", 3));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 57) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "assistCoatch", 4));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 63) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "assistCoatch", 5));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 70) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "teamLeaders", 0));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 76) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "teamLeaders", 1));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 83) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "teamLeaders", 2));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 89) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "teamLeaders", 3));
	  		}	  		
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 96) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "moneyManagers", 0));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 103) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "moneyManagers", 1));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 110) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "caringManager", 0));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 116) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "caringManager", 1));
	  		}	  		
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 123) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "caringManager", 2));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 129) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "caringManager", 3));
	  		}
	  		
	  		//harjoittelu
	  		if(currentIndex == 136) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiseTimes"));
	  		}
	  		
	  		//harjoittelupaikat
	  		if(currentIndex == 145) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "summerPractise", 0));
	  		}
	  		
	  		//harjoittelupaikat
	  		if(currentIndex == 146) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "summerPractise", 1));
	  		}
	  		//harjoittelupaikat
	  		if(currentIndex == 147) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "summerPractise", 2));
	  		}
	  		//harjoittelupaikat
	  		if(currentIndex == 148) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "summerPractise", 3));
	  		}
	  		//harjoittelupaikat
	  		if(currentIndex == 155) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "winterPractise", 0));
	  		}
	  		//harjoittelupaikat
	  		if(currentIndex == 156) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "winterPractise", 1));
	  		}
	  		//harjoittelupaikat
	  		if(currentIndex == 157) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "winterPractise", 2));
	  		}
	  		//harjoittelupaikat
	  		if(currentIndex == 158) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "winterPractise", 3));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 162) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "practiceWeeks", 0));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 165) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "practiceWeeks", 1));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 168) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "practiceWeeks", 2));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 171) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "practiceWeeks", 3));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 176) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiseStory"));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 185) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportActivitySummer", 0));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 186) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportActivitySummer", 1));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 189) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportActivitySummer", 2));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 190) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportActivitySummer", 3));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 194) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportActivityWinter", 0));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 195) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportActivityWinter", 1));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 198) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportActivityWinter", 2));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 199) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportActivityWinter", 3));
	  		}
	  		//turnauksien lukumäärä menneenä kalenteri vuonna
	  		if(currentIndex == 207) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "totalSportsEvents"));
	  		}
	  		//sarja ja turnausotteluiden lukumäärä
	  		if(currentIndex == 211) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportsEventsPerMatch", 0));
	  		}
	  		//sarja ja turnausotteluiden lukumäärä
	  		if(currentIndex == 214) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportsEventsPerMatch", 1));
	  		}
	  		//sarja ja turnausotteluiden lukumäärä
	  		if(currentIndex == 217) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportsEventsPerMatch", 2));
	  		}
	  		//koulutus
	  		if(currentIndex == 227) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationHeadCoatch", 0));
	  		}
	  		//koulutus
	  		if(currentIndex == 233) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationHeadCoatch", 1));
	  		}
	  		//koulutus
	  		if(currentIndex == 237) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationHeadCoatch", 2));
	  		}
	  		//koulutus
	  		if(currentIndex == 242) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationAssistCoatch", 0));
	  		}
	  		//koulutus
	  		if(currentIndex == 248) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationAssistCoatch", 1));
	  		}
	  		//koulutus
	  		if(currentIndex == 251) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationAssistCoatch", 2));
	  		}
	  		//koulutus
	  		if(currentIndex == 256) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationTeamLeader", 0));
	  		}
	  		//koulutus
	  		if(currentIndex == 262) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationTeamLeader", 1));
	  		}
	  		//koulutus
	  		if(currentIndex == 264) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationTeamLeader", 2));
	  		}
	  		//koulutus
	  		if(currentIndex == 269) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationMoneyManager", 0));
	  		}
	  		//koulutus
	  		if(currentIndex == 275) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationMoneyManager", 1));
	  		}
	  		//koulutus
	  		if(currentIndex == 278) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationMoneyManager", 2));
	  		}
	  		//koulutus
	  		if(currentIndex == 284) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationCaringManager", 0));
	  		}
	  		//koulutus
	  		if(currentIndex == 288) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationCaringManager", 1));
	  		}
	  		//koulutus
	  		if(currentIndex == 292) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationCaringManager", 2));
	  		}
	  		//koulutus
	  		if(currentIndex == 297) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "somethingElseEducation", 0));
	  		}
	  	//koulutus
	  		if(currentIndex == 306) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "somethingElseEducation", 1));
	  		}
	  	//koulutus
	  		if(currentIndex == 309) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "somethingElseEducation", 2));
	  		}
	  	//koulutus
	  		if(currentIndex == 315) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "parentEducation", 0));
	  		}
	  	//koulutus
	  		if(currentIndex == 317) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "parentEducation", 1));
	  		}
	  	//koulutus
	  		if(currentIndex == 324) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "playerEducation", 0));
	  		}
	  	//koulutus
	  		if(currentIndex == 326) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "playerEducation", 1));
	  		}
	  	//koulutus
	  		if(currentIndex == 328) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "playerEducation", 2));
	  		}
	  	//koulutus
	  		if(currentIndex == 330) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "playerEducation", 3));
	  		}
	  		//joukkueen muut tapahtumat
	  		if(currentIndex == 334) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "parentMeetings"));
	  		}
	  	//joukkueen muut tapahtumat
	  		if(currentIndex == 338) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "ruleMeeting"));
	  		}
	  	//muut toiminta
	  		if(currentIndex == 341) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "otherEvents"));
	  		}
	  	//muut toiminta
	  		if(currentIndex == 350) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "date"));
	  		}
	  	//muut toiminta
	  		if(currentIndex == 357) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "coatchSignature"));
	  		}
	  	//muut toiminta
	  		if(currentIndex == 363) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "teamManagerSignature"));
	  		}
	  		wordTextIterator.next();
	  	}
	  		
	  writeDocxToStream(template, "src\\main\\resources\\templates\\Toimintakertomus.docx");
	 }
	
	public String loopJsonObjectToGetValue(JSONObject jsonModelObject, String desiredValue) {
		String desired = "";
		String temp = "";
		for(Iterator<?> iterator = jsonModelObject.keys(); iterator.hasNext();) {
			temp = (String) iterator.next();
			if(temp.contains(desiredValue)) {
				desired = jsonModelObject.getString(temp);
			}
		}
		
		return desired;
	}
	
	public String loopJsonArrayToGetValue(JSONObject jsonModelObject, String desiredValue, int index) {
		JSONArray arr = jsonModelObject.getJSONArray(desiredValue);
		String key = "";
		
		for(int i = 0; i < arr.length(); i++) {
			if(i == index) {
				key = arr.getString(i);
			}
		}
		
		return key;
	}
	
	public void writeDocxToStream(WordprocessingMLPackage template, String target) throws IOException, Docx4JException {
		 File f = new File(target);
		 template.save(f);
	}
	
	public JSONObject generateJsonFromForm(ActionFormModel actionForm) {
		Gson gson = new GsonBuilder().create();
		JSONObject jObject = new JSONObject(gson.toJson(actionForm));
		return jObject;
	}
}
