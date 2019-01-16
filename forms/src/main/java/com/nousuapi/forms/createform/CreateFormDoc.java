package com.nousuapi.forms.createform;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.P;
import org.docx4j.wml.Text;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
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
	  
	  	Iterator<Object> wordTextIterator = texts.iterator();
	  	while(wordTextIterator.hasNext()) {
	  		Object wordText = wordTextIterator.next();
	  		
	  		for(Iterator<?> iterator = jsonModelObject.keys(); iterator.hasNext();) {
				 String key = (String) iterator.next();
				 Text castedWordTextObj = (Text) wordText;
				 if(castedWordTextObj.getValue().contains(key.toUpperCase())) {
					 Text formText = (Text) wordTextIterator.next();
					 if(formText.getValue().contains("FORMTEXT")) {
						 Text replaceText = (Text) wordTextIterator.next();
						 replaceText.setValue(jsonModelObject.getString(key));
						 
					  }
				 }
	  		}
  	}
		
	  writeDocxToStream(template, "src\\main\\resources\\templates\\ToimintakertomusNew.docx");
	 }
	
	public void writeDocxToStream(WordprocessingMLPackage template, String target) throws IOException, Docx4JException {
		 File f = new File(target);
		 template.save(f);
	}
	/*
	public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
	    Map<String, Object> jsonMap = new HashMap<String, Object>();

	    if(json != JSONObject.NULL) {
	    	jsonMap = toMap(json);
	    }
	    return jsonMap;
	}

	public static Map<String, Object> toMap(JSONObject object) throws JSONException {
	    Map<String, Object> map = new HashMap<String, Object>();

	    Iterator<String> keysItr = object.keys();
	    while(keysItr.hasNext()) {
	        String key = keysItr.next();
	        Object value = object.get(key);

	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }

	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        map.put(key, value);
	    }
	    return map;
	}

	public static List<Object> toList(JSONArray array) throws JSONException {
	    List<Object> list = new ArrayList<Object>();
	    for(int i = 0; i < array.length(); i++) {
	        Object value = array.get(i);
	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }

	        else if(value instanceof JSONObject) {
	            value = toMap((JSONObject) value);
	        }
	        list.add(value);
	    }
	    return list;
	}
*/
	public JSONObject generateJsonFromForm(ActionFormModel actionForm) {
		Gson gson = new GsonBuilder().create();
		JSONObject jObject = new JSONObject(gson.toJson(actionForm));
		return jObject;
	}
}
