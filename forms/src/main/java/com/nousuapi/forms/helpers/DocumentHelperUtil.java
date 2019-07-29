package com.nousuapi.forms.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.xml.bind.JAXBElement;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.ContentAccessor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.nousuapi.forms.model.ActionFormModel;

public class DocumentHelperUtil {
	
	private static Logger logger = LoggerFactory.getLogger(DocumentHelperUtil.class);	
	
	public WordprocessingMLPackage getTemplate(File file) throws FileNotFoundException, Docx4JException {
		WordprocessingMLPackage template = WordprocessingMLPackage.load(new FileInputStream(file));
		
		return template;
	}

	//gets all word elements to list of objects
	public List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {
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
