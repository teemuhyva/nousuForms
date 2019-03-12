package com.nousuapi.forms.createform;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.mail.MessagingException;
import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Text;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.nousuapi.forms.model.ActionFormModel;

public class CreateFormDoc {

	private static final Logger LOGGER = Logger.getLogger(CreateFormDoc.class);
	
	public WordprocessingMLPackage getTemplate(File file) throws FileNotFoundException, Docx4JException {
		WordprocessingMLPackage template = WordprocessingMLPackage.load(new FileInputStream(file));
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
		  
	public void populateWord(WordprocessingMLPackage template, List<ActionFormModel> actionForm) throws  Docx4JException, MessagingException, FileNotFoundException, IOException {
		JSONArray jsonModelObject =  generateJsonFromForm(actionForm);
	  List<Object> texts = getAllElementFromObject(template.getMainDocumentPart(), Text.class);
	  int currentIndex = 0;
	  	ListIterator<Object> wordTextIterator = texts.listIterator();
	  	do {
	  		if(wordTextIterator.hasNext()) {
	  			wordTextIterator.next();
	  		}
	  		
	  		currentIndex = wordTextIterator.nextIndex();
	  		//ikäluokka
	  		if(currentIndex == 3) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "ageClass"));
	  		}
	  		
	  		//pelaaja lukumäärä
	  		if(currentIndex == 8) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "players"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 15) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "headCoatch"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 17) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "headCoatch2"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 20) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "assistCoatch"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 22) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "assistCoatch2"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 25) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "assistCoatch3"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 27) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "assistCoatch4"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 30) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "assistCoatch5"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 32) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "assistCoatch6"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 35) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "teamLeaders"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 37) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "teamLeaders2"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 40) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "teamLeaders3"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 42) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "teamLeaders4"));
	  		}	  		
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 45) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "moneyManagers"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 47) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "moneyManagers2"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 50) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "caringManager"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 52) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "caringManager2"));
	  		}	  		
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 55) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "caringManager3"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 57) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "caringManager4"));
	  		}
	  		
	  		//harjoittelu
	  		if(currentIndex == 61) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiseTimes"));
	  		}
	  		
	  		//kesäharjoittelupaikat
	  		if(currentIndex == 68) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "summerPractise"));
	  		}
	  		
	  		//kesäharjoittelupaikat
	  		if(currentIndex == 70) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "summerPractise2"));
	  		}
	  		//kesäharjoittelupaikat
	  		if(currentIndex == 72) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "summerPractise3"));
	  		}
	  		//kesäharjoittelupaikat
	  		if(currentIndex == 74) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "summerPractise4"));
	  		}
	  		//talviharjoittelupaikat
	  		if(currentIndex == 77) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "winterPractise"));
	  		}
	  		//talviharjoittelupaikat
	  		if(currentIndex == 79) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "winterPractise2"));
	  		}
	  		//talviharjoittelupaikat
	  		if(currentIndex == 81) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "winterPractise3"));
	  		}
	  		//talviharjoittelupaikat
	  		if(currentIndex == 83) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "winterPractise4"));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 87) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiceWeeks"));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 92) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiceWeeks2"));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 97) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiceWeeks3"));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 101) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiceWeeks4"));
	  		}
	  		//harjoittelutarina
	  		if(currentIndex == 106) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiseStory"));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 113) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportActivitySummer"));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 115) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportActivitySummer2"));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 120) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportActivitySummer3"));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 122) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportActivitySummer4"));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 127) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportActivityWinter"));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 130) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportActivityWinter2"));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 135) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportActivityWinter3"));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 137) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportActivityWinter4"));
	  		}
	  		//turnauksien lukumäärä menneenä kalenteri vuonna
	  		if(currentIndex == 141) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "totalSportsEvents"));
	  		}
	  		//sarja ja turnausotteluiden lukumäärä
	  		if(currentIndex == 146) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportsEventsPerMatch"));
	  		}
	  		//sarja ja turnausotteluiden lukumäärä
	  		if(currentIndex == 150) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportsEventsPerMatch2"));
	  		}
	  		//sarja ja turnausotteluiden lukumäärä
	  		if(currentIndex == 154) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportsEventsPerMatch3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 164) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationHeadCoatch"));
	  		}
	  		//koulutus
	  		if(currentIndex == 166) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationHeadCoatch2"));
	  		}
	  		//koulutus
	  		if(currentIndex == 168) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationHeadCoatch3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 171) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationAssistCoatch"));
	  		}
	  		//koulutus
	  		if(currentIndex == 173) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationAssistCoatch2"));
	  		}
	  		//koulutus
	  		if(currentIndex == 175) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationAssistCoatch3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 178) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationTeamLeader"));
	  		}
	  		//koulutus
	  		if(currentIndex == 180) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationTeamLeader2"));
	  		}
	  		//koulutus
	  		if(currentIndex == 182) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationTeamLeader3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 185) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationMoneyManager"));
	  		}
	  		//koulutus
	  		if(currentIndex == 187) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationMoneyManager2"));
	  		}
	  		//koulutus
	  		if(currentIndex == 189) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationMoneyManager3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 192) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationCaringManager"));
	  		}
	  		//koulutus
	  		if(currentIndex == 194) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationCaringManager2"));
	  		}
	  		//koulutus
	  		if(currentIndex == 196) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationCaringManager3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 200) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "somethingElseEducation"));
	  		}
	  	//koulutus
	  		if(currentIndex == 202) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "somethingElseEducation2"));
	  		}
	  	//koulutus
	  		if(currentIndex == 204) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "somethingElseEducation3"));
	  		}
	  	//koulutus
	  		if(currentIndex == 207) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "parentEducation"));
	  		}
	  	//koulutus
	  		if(currentIndex == 210) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "parentEducation2"));
	  		}
	  	//koulutus
	  		if(currentIndex == 213) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "playerEducation"));
	  		}
	  	//koulutus
	  		if(currentIndex == 216) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "playerEducation2"));
	  		}
	  	//koulutus
	  		if(currentIndex == 219) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "playerEducation3"));
	  		}
	  	//koulutus
	  		if(currentIndex == 222) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "playerEducation4"));
	  		}
	  		//joukkueen muut tapahtumat
	  		if(currentIndex == 227) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "parentMeetings"));
	  		}
	  		//joukkueen muut tapahtumat
	  		if(currentIndex == 232) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "ruleMeeting"));
	  		}
	  		//muut toiminta
	  		if(currentIndex == 236) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "otherEvents"));
	  		}
	  		//muut toiminta
	  		if(currentIndex == 241) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.now();
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(dtf.format(localDate));
	  		}
	  		//muut toiminta		  	
	  		if(currentIndex == 244) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "signature"));
	  		}
	  		//muut toiminta	  	
	  		if(currentIndex == 246) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue("");
	  		}
	  		
  			
  			
	  	} while(currentIndex < 247);
	  		
		  writeDocxToStream(template, "Toimintakertomus2.docx");
	 }
	
	public String loopJsonObjectToGetValue(JSONArray jArray, String desiredValue) {
		
		String desired = "";		
		
		for(int i = 0; i < jArray.length(); i++) {
			JSONObject jObject = jArray.getJSONObject(i);
			Iterator iter = jObject.keys();
			while(iter.hasNext()) {
				String firstKey = (String)iter.next();
				String firstValue = jObject.getString(firstKey);
				
				if(firstValue.equals(desiredValue)) {
					while(iter.hasNext()) {
						String key = (String)iter.next();
						String value = jObject.getString(key);
						desired = value;
					}
				}
			}
		}
		
		return desired;
	}
	
	public void writeDocxToStream(WordprocessingMLPackage template, String target) throws Docx4JException, MessagingException {
		File f = new File(target);
		 template.save(f);		 
	}
	
	public JSONArray generateJsonFromForm(List<ActionFormModel> actionForm) throws JsonParseException, JsonMappingException, IOException {
		String json = new Gson().toJson(actionForm);
		JSONArray arr = new JSONArray(json);
		
		return arr;
	}
}
