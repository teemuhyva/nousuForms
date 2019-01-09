package com.nousuapi.forms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Normalizer.Form;

import javax.mail.MessagingException;
import javax.xml.bind.JAXBException;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.createform.CreateFormDoc;
import com.nousuapi.forms.emailutil.EmailUtil;
import com.nousuapi.forms.model.ActionFormModel;

@RestController
@RequestMapping("/api/forms")
public class FormsController {

	@RequestMapping("/actionForm")
	public ResponseEntity<Object> createForm(@RequestBody ActionFormModel actionform) throws Docx4JException, IOException {
		CreateFormDoc form = new CreateFormDoc();
		form.replacePlaceholder(form.getTemplate("C:\\Users\\Matty\\Downloads\\Toimintakertomus.docx"), "YLEISTÄ", "jotain");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping("/sendMail")
	public ResponseEntity<Object> createMail() throws MessagingException, FileNotFoundException {
		EmailUtil email = new EmailUtil();
		email.createEmail();
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
