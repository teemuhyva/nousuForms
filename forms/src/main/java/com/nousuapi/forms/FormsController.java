package com.nousuapi.forms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.MessagingException;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.hibernate.internal.util.xml.ErrorLogger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.createform.CreateFormDoc;
import com.nousuapi.forms.emailutil.EmailUtil;
import com.nousuapi.forms.exceptions.ErrorLogging;
import com.nousuapi.forms.model.ActionFormModel;


@RestController
@RequestMapping("/api/forms")
public class FormsController {

	private static final Logger logger = Logger.getLogger(FormsController.class.getName());
	
	@PostMapping("/actionForm")
	public ResponseEntity<?> createForm(@RequestBody ActionFormModel actionForm) throws Exception {
		ErrorLogging log = new ErrorLogging();
		CreateFormDoc form = new CreateFormDoc();
		File file = new File("Toimintakertomus.docx");		
		try {
			form.populateWord(form.getTemplate(file), actionForm);
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, "File not found");
			log.setError1(e.getMessage());
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Something went horribly wrong!!!!!");
			
		}
		
		try {
			log = SendEmailWithAttachment(new File("Toimintakertomus2.docx"), actionForm);
		} catch (IOException e) {
			e.printStackTrace();
			log.setError3(e.getMessage());
		}
		return new ResponseEntity<>(log,HttpStatus.CREATED);
	}
	
	@PostMapping("/ilmanbodya")
	public ResponseEntity<?> createForm() throws Exception {
		ActionFormModel model = new ActionFormModel();
		try {
			SendEmailWithAttachment(new File("Toimintakertomus2.docx"), model);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@PostMapping("/jyvaskylacupjobsForm")
	public ResponseEntity<Object> generateJob() {
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}
	
	public ErrorLogging SendEmailWithAttachment(File file, ActionFormModel actionForm) throws Exception {
		ErrorLogging log = new ErrorLogging();
		 EmailUtil sendAttachmentViaEmail = new EmailUtil();
		 try {			 
			 log = sendAttachmentViaEmail.createEmail(file, actionForm);
		} catch (FileNotFoundException e) {
			log.setError4(e.getMessage());
		}
		 
		 return log;
	}
}
