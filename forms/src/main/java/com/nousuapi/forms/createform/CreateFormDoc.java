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
import org.apache.log4j.Priority;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Text;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nousuapi.forms.FormsController;
import com.nousuapi.forms.emailutil.EmailUtil;
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
		  
	public void populateWord(WordprocessingMLPackage template, ActionFormModel actionForm) throws  Docx4JException, MessagingException, FileNotFoundException, IOException {
	  JSONObject jsonModelObject =  generateJsonFromForm(actionForm);
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
	  		if(currentIndex == 133) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiseTimes"));
	  		}
	  		
	  		//kesäharjoittelupaikat
	  		if(currentIndex == 140) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "summerPractise", 0));
	  		}
	  		
	  		//kesäharjoittelupaikat
	  		if(currentIndex == 142) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "summerPractise", 1));
	  		}
	  		//kesäharjoittelupaikat
	  		if(currentIndex == 144) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "summerPractise", 2));
	  		}
	  		//kesäharjoittelupaikat
	  		if(currentIndex == 146) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "summerPractise", 3));
	  		}
	  		//talviharjoittelupaikat
	  		if(currentIndex == 149) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "winterPractise", 0));
	  		}
	  		//talviharjoittelupaikat
	  		if(currentIndex == 151) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "winterPractise", 1));
	  		}
	  		//talviharjoittelupaikat
	  		if(currentIndex == 153) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "winterPractise", 2));
	  		}
	  		//talviharjoittelupaikat
	  		if(currentIndex == 155) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "winterPractise", 3));
	  		}
	  		//harjoittelumäärä
	  		if(currentIndex == 159) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiceWeeks"));
	  		}
	  		//harjoittelutarina
	  		if(currentIndex == 178) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "practiseStory"));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 185) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportActivitySummer", 0));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 187) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportActivitySummer", 1));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 192) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportActivitySummer", 2));
	  		}
	  		//kilpailutoiminta kesä
	  		if(currentIndex == 194) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportActivitySummer", 3));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 199) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportActivityWinter", 0));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 202) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportActivityWinter", 1));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 207) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportActivityWinter", 2));
	  		}
	  		//kilpailutoiminta talvi
	  		if(currentIndex == 209) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "sportActivityWinter", 3));
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
	  		//koulutus
	  		if(currentIndex == 236) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationHeadCoatch", 0));
	  		}
	  		//koulutus
	  		if(currentIndex == 238) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationHeadCoatch", 1));
	  		}
	  		//koulutus
	  		if(currentIndex == 240) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationHeadCoatch", 2));
	  		}
	  		//koulutus
	  		if(currentIndex == 243) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationAssistCoatch", 0));
	  		}
	  		//koulutus
	  		if(currentIndex == 245) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationAssistCoatch", 1));
	  		}
	  		//koulutus
	  		if(currentIndex == 247) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationAssistCoatch", 2));
	  		}
	  		//koulutus
	  		if(currentIndex == 250) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationTeamLeader", 0));
	  		}
	  		//koulutus
	  		if(currentIndex == 252) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationTeamLeader", 1));
	  		}
	  		//koulutus
	  		if(currentIndex == 254) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationTeamLeader", 2));
	  		}
	  		//koulutus
	  		if(currentIndex == 257) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationMoneyManager", 0));
	  		}
	  		//koulutus
	  		if(currentIndex == 259) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationMoneyManager", 1));
	  		}
	  		//koulutus
	  		if(currentIndex == 261) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationMoneyManager", 2));
	  		}
	  		//koulutus
	  		if(currentIndex == 264) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationCaringManager", 0));
	  		}
	  		//koulutus
	  		if(currentIndex == 266) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationCaringManager", 1));
	  		}
	  		//koulutus
	  		if(currentIndex == 268) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "educationCaringManager", 2));
	  		}
	  		//koulutus
	  		if(currentIndex == 272) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "somethingElseEducation", 0));
	  		}
	  	//koulutus
	  		if(currentIndex == 274) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "somethingElseEducation", 1));
	  		}
	  	//koulutus
	  		if(currentIndex == 276) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "somethingElseEducation", 2));
	  		}
	  	//koulutus
	  		if(currentIndex == 279) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "parentEducation", 0));
	  		}
	  	//koulutus
	  		if(currentIndex == 282) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "parentEducation", 1));
	  		}
	  	//koulutus
	  		if(currentIndex == 285) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "playerEducation", 0));
	  		}
	  	//koulutus
	  		if(currentIndex == 288) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "playerEducation", 1));
	  		}
	  	//koulutus
	  		if(currentIndex == 291) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "playerEducation", 2));
	  		}
	  	//koulutus
	  		if(currentIndex == 294) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonArrayToGetValue(jsonModelObject, "playerEducation", 3));
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
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "acceptance"));
	  		}
	  		
	  	//muut toiminta
	  		/*
	  		if(currentIndex == 318) {
	  			Text formText = (Text) wordTextIterator.next();
	  			formText.setValue(loopJsonObjectToGetValue(jsonModelObject, "signature"));
	  		}
	  		*/
  			
  			
	  	} while(currentIndex < 317);
	  		
		  writeDocxToStream(template, "src/Toimintakertomus2.docx");
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
	
	public void writeDocxToStream(WordprocessingMLPackage template, String target) throws Docx4JException, MessagingException {
		 File f = new File(target);
		 template.save(f);
	}
	
	public JSONObject generateJsonFromForm(ActionFormModel actionForm) {
		Gson gson = new GsonBuilder().create();
		JSONObject jObject = new JSONObject(gson.toJson(actionForm));
		return jObject;
	}
}
