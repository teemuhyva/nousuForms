package com.nousuapi.forms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.MessagingException;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.createform.CreateFormDoc;
import com.nousuapi.forms.emailutil.EmailUtil;
import com.nousuapi.forms.model.ActionFormModel;


@RestController
@RequestMapping("/api/forms")
public class FormsController {

	private static final Logger logger = Logger.getLogger(FormsController.class.getName());
	
	@PostMapping("/actionForm")
	public ResponseEntity<?> createForm(@RequestBody ActionFormModel actionForm) throws Docx4JException,  MessagingException {
		CreateFormDoc form = new CreateFormDoc();
		File file = new File("Toimintakertomus.docx");		
		try {
			form.populateWord(form.getTemplate(file), actionForm);
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, "File not found");
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Something went horribly wrong!!!!!");
			e.printStackTrace();
		}
		
		try {
			SendEmailWithAttachment(new File("Toimintakertomus2.docx"), actionForm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/jyvaskylacupjobsForm")
	public ResponseEntity<Object> generateJob() {
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}
	
	public void SendEmailWithAttachment(File file, ActionFormModel actionForm) throws MessagingException, IOException {
		
		 EmailUtil sendAttachmentViaEmail = new EmailUtil();
		 try {			 
			 sendAttachmentViaEmail.createEmail(file, actionForm);
		} catch (FileNotFoundException e) {
		}		 
	}
}
