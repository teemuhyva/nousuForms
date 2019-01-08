package com.nousuapi.forms.createform;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.P;
import org.docx4j.wml.Text;


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
		  
	public void replacePlaceholder(WordprocessingMLPackage template, String name, String placeholder ) throws IOException, Docx4JException {
	  List<Object> texts = getAllElementFromObject(template.getMainDocumentPart(), Text.class);
	  for (Object text : texts) {
	   Text textElement = (Text) text;
		   if (textElement.getValue().equals(name)) {
		    textElement.setValue(placeholder);
		   }
	  }
	  writeDocxToStream(template, "C:\\Users\\\\Matty\\Downloads\\Toimintakertomus2.docx");
	 }
	
	public void writeDocxToStream(WordprocessingMLPackage template, String target) throws IOException, Docx4JException {
		 File f = new File(target);
		 template.save(f);
	}

}
