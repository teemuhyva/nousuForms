package com.nousuapi.forms;

import java.io.FileNotFoundException;
import java.io.IOException;

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

@RestController
@RequestMapping("/api/forms")
public class FormsController {

	@PostMapping("/actionForm")
	public ResponseEntity<Object> createForm(@RequestBody ActionFormModel actionForm) throws Docx4JException, IOException {
		CreateFormDoc form = new CreateFormDoc();
		form.populateWord(form.getTemplate("src\\main\\resources\\templates\\Toimintakertomus.docx"), actionForm);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/sendMail")
	public ResponseEntity<Object> createMail() throws MessagingException, FileNotFoundException {
		EmailUtil email = new EmailUtil();
		email.createEmail();
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
