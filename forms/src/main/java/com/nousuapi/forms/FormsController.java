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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nousuapi.forms.createform.CreateFormDoc;
import com.nousuapi.forms.emailutil.EmailUtil;
import com.nousuapi.forms.model.ActionFormModel;
import com.nousuapi.forms.model.EmailLogger;


@RestController
@RequestMapping("/api/forms")
public class FormsController {

	private static final Logger logger = Logger.getLogger(FormsController.class.getName());
	
	@SuppressWarnings("deprecation")
	@PostMapping("/actionForm")
	public ResponseEntity<EmailLogger> createForm(@RequestBody ActionFormModel actionForm) throws Docx4JException,  MessagingException {
		CreateFormDoc form = new CreateFormDoc();
		EmailLogger eLogger = new EmailLogger();
		File file = new File("src/Toimintakertomus.docx");
		try {
			form.populateWord(form.getTemplate(file), actionForm);
			logger.log(Level.INFO, "Worked ok");
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, "File not found");
			eLogger.setErrorPart1(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Something went horribly wrong!!!!!");
			eLogger.setErrorPart2(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			eLogger = SendEmailWithAttachment();
		} catch (IOException e) {
			e.printStackTrace();
			eLogger.setErrorPart3(e.getMessage());
		}
		return new ResponseEntity<>(eLogger, HttpStatus.CREATED);
	}
	/*
	@PostMapping("/sendMail")
	public ResponseEntity<Object> createMail() throws MessagingException, FileNotFoundException {
		EmailUtil email = new EmailUtil();
		try {
			email.createEmail();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	*/
	public EmailLogger SendEmailWithAttachment() throws MessagingException, IOException {
		EmailLogger eLogger = new EmailLogger();
		
		 EmailUtil sendAttachmentViaEmail = new EmailUtil();
		 try {
			 eLogger = sendAttachmentViaEmail.createEmail();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			eLogger.setErrorPart4(e.getMessage());
		}
		 
		return eLogger;
	}
}
