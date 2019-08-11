package com.nousuapi.forms.createform;

import java.util.List;
import java.util.ListIterator;

import javax.mail.MessagingException;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.Text;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nousuapi.forms.helpers.DateHelper;
import com.nousuapi.forms.helpers.DocumentHelperUtil;
import com.nousuapi.forms.signup.model.SignupResource;

public class PaymentTemplate {
	
	private static Logger logger = LoggerFactory.getLogger(PaymentTemplate.class);

	public void createPaymentTemplate(List<Object> texts, WordprocessingMLPackage template, JSONArray jsonModelObject, SignupResource signUpFormModel) throws Docx4JException, MessagingException {
		/*
		 * below code does return empty list. If tried again later parameter for this metod is
		 * WordprocessingMLPackage template
		 */
		/*
		
		List<Object> texts = docs.getAllElementFromObject(template.getMainDocumentPart(), Text.class);
		logger.info("list size is " + texts.size());
		*/
		DocumentHelperUtil docs = new DocumentHelperUtil();	
		int currentIndex = 0;
		ListIterator<Object> worldTextIter = texts.listIterator();
		
		do {
			if(worldTextIter.hasNext()) {
				Text formText = (Text)worldTextIter.next();
				if(currentIndex == 0) {
					formText.setValue(signUpFormModel.getParentName());
				} else if(currentIndex == 1) {
					formText.setValue(signUpFormModel.getAddress());
				} else if(currentIndex == 2) {
					formText.setValue(signUpFormModel.getPostNum() + " " + signUpFormModel.getPostOffice());
				} else if(currentIndex == 19) {
					formText.setValue(DateHelper.calcExpDate());
				} else if(currentIndex == 52) {
					formText.setValue(signUpFormModel.getChildName());
				} else if(currentIndex == 100) {
					formText.setValue(signUpFormModel.getParentName());
				} else if(currentIndex == 101) {
					formText.setValue(signUpFormModel.getAddress());
				} else if(currentIndex == 102) {
					formText.setValue(signUpFormModel.getPostNum() + " " + signUpFormModel.getPostOffice());
				} else if(currentIndex == 112) {
					formText.setValue(DateHelper.calcExpDate());
				}
			}
			
			
			currentIndex++;
			
		} while(worldTextIter.hasNext());
		
		docs.writeDocxToStream(template, "Ilmoittautumislasku.docx");
	}
}
