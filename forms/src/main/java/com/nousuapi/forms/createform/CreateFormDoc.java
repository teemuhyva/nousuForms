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
	  		if(currentIndex == 18) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "headCoatch"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 24) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "headCoatch2"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 31) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "assistCoatch"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 37) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "assistCoatch2"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 44) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "assistCoatch3"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 50) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "assistCoatch4"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 57) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "assistCoatch5"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 63) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "assistCoatch6"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 70) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "teamLeaders"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 76) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "teamLeaders2"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 83) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "teamLeaders3"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 89) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "teamLeaders4"));
	  		}	  		
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 96) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "moneyManagers"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 103) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "moneyManagers2"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 110) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "caringManager"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 116) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "caringManager2"));
	  		}	  		
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 123) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "caringManager3"));
	  		}
	  		
	  		//joukkueet ja pelaajat
	  		if(currentIndex == 129) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "caringManager4"));
	  		}
	  		
	  		//harjoittelu
	  		if(currentIndex == 133) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiseTimes"));
	  		}
	  		
	  		//kesäharjoittelupaikat
	  		if(currentIndex == 140) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "summerPractise"));
	  		}
	  		
	  		//kesäharjoittelupaikat
	  		if(currentIndex == 142) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "summerPractise2"));
	  		}
	  		//kesäharjoittelupaikat
	  		if(currentIndex == 144) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "summerPractise3"));
	  		}
	  		//kesäharjoittelupaikat
	  		if(currentIndex == 146) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "summerPractise4"));
	  		}
	  		//talviharjoittelupaikat
	  		if(currentIndex == 149) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "winterPractise"));
	  		}
	  		//talviharjoittelupaikat
	  		if(currentIndex == 151) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "winterPractise2"));
	  		}
	  		//talviharjoittelupaikat
	  		if(currentIndex == 153) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "winterPractise3"));
	  		}
	  		//talviharjoittelupaikat
	  		if(currentIndex == 155) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "winterPractise4"));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 159) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiceWeeks"));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 164) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiceWeeks2"));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 169) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiceWeeks3"));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 173) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiceWeeks4"));
	  		}
	  		//harjoittelutarina
	  		if(currentIndex == 178) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiseStory"));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 185) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportActivitySummer"));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 187) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportActivitySummer2"));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 192) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportActivitySummer3"));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 194) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportActivitySummer4"));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 199) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportActivityWinter"));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 202) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportActivityWinter2"));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 207) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportActivityWinter3"));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 209) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportActivityWinter4"));
	  		}
	  		//turnauksien lukumäärä menneenä kalenteri vuonna
	  		if(currentIndex == 213) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "totalSportsEvents"));
	  		}
	  		//sarja ja turnausotteluiden lukumäärä
	  		if(currentIndex == 218) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportsEventsPerMatch"));
	  		}
	  		//sarja ja turnausotteluiden lukumäärä
	  		if(currentIndex == 222) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportsEventsPerMatch2"));
	  		}
	  		//sarja ja turnausotteluiden lukumäärä
	  		if(currentIndex == 226) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "sportsEventsPerMatch3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 236) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationHeadCoatch"));
	  		}
	  		//koulutus
	  		if(currentIndex == 238) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationHeadCoatch2"));
	  		}
	  		//koulutus
	  		if(currentIndex == 240) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationHeadCoatch3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 243) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationAssistCoatch"));
	  		}
	  		//koulutus
	  		if(currentIndex == 245) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationAssistCoatch2"));
	  		}
	  		//koulutus
	  		if(currentIndex == 247) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationAssistCoatch3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 250) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationTeamLeader"));
	  		}
	  		//koulutus
	  		if(currentIndex == 252) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationTeamLeader2"));
	  		}
	  		//koulutus
	  		if(currentIndex == 254) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationTeamLeader3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 257) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationMoneyManager"));
	  		}
	  		//koulutus
	  		if(currentIndex == 259) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationMoneyManager2"));
	  		}
	  		//koulutus
	  		if(currentIndex == 261) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationMoneyManager3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 264) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationCaringManager"));
	  		}
	  		//koulutus
	  		if(currentIndex == 266) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationCaringManager2"));
	  		}
	  		//koulutus
	  		if(currentIndex == 268) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "educationCaringManager3"));
	  		}
	  		//koulutus
	  		if(currentIndex == 272) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "somethingElseEducation"));
	  		}
	  	//koulutus
	  		if(currentIndex == 274) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "somethingElseEducation2"));
	  		}
	  	//koulutus
	  		if(currentIndex == 276) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "somethingElseEducation3"));
	  		}
	  	//koulutus
	  		if(currentIndex == 279) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "parentEducation"));
	  		}
	  	//koulutus
	  		if(currentIndex == 282) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "parentEducation2"));
	  		}
	  	//koulutus
	  		if(currentIndex == 285) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "playerEducation"));
	  		}
	  	//koulutus
	  		if(currentIndex == 288) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "playerEducation2"));
	  		}
	  	//koulutus
	  		if(currentIndex == 291) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "playerEducation3"));
	  		}
	  	//koulutus
	  		if(currentIndex == 294) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "playerEducation4"));
	  		}
	  		//joukkueen muut tapahtumat
	  		if(currentIndex == 299) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "parentMeetings"));
	  		}
	  		//joukkueen muut tapahtumat
	  		if(currentIndex == 304) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "ruleMeeting"));
	  		}
	  		//muut toiminta
	  		if(currentIndex == 308) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "otherEvents"));
	  		}
	  		//muut toiminta
	  		if(currentIndex == 313) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.now();
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(dtf.format(localDate));
	  		}
	  		//muut toiminta		  	
	  		if(currentIndex == 316) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "signature"));
	  		}
	  		//muut toiminta	  	
	  		if(currentIndex == 318) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue("");
	  		}
	  		
  			
  			
	  	} while(currentIndex < 317);
	  		
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
				
				if(firstValue.contains(desiredValue)) {
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
