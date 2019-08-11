package com.nousuapi.forms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.createform.CreateFormDoc;
import com.nousuapi.forms.emailutil.EmailUtil;
import com.nousuapi.forms.exceptions.ErrorLogging;
import com.nousuapi.forms.helpers.DocumentHelperUtil;
import com.nousuapi.forms.model.ActionFormModel;


@RestController
@RequestMapping("/api/forms")
public class FormsController {
	
	@PostMapping("/actionForm")
	public ResponseEntity<?> createForm(@RequestBody List<ActionFormModel> actionForm) throws Exception {
		
		CreateFormDoc form = new CreateFormDoc();
		File file = new File("Toimintakertomus.docx");		
		
		try {
			DocumentHelperUtil docs = new DocumentHelperUtil();
			form.populateWord(docs.getTemplate(file), actionForm, null);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		
		try {
			SendEmailWithAttachment(new File("Toimintakertomus2.docx"), actionForm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	public void SendEmailWithAttachment(File file, List<ActionFormModel> actionForm) throws Exception {
		EmailUtil sendAttachmentViaEmail = new EmailUtil();
		 
		try {			 
			 sendAttachmentViaEmail.createEmail(file, actionForm);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
