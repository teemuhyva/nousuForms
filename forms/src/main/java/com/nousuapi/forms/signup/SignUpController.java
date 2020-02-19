package com.nousuapi.forms.signup;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nousuapi.forms.createform.CreateFormDoc;
import com.nousuapi.forms.emailutil.EmailUtil;
import com.nousuapi.forms.excelutil.SignUpExcel;
import com.nousuapi.forms.helpers.DocumentHelperUtil;
import com.nousuapi.forms.mapper.SignUpResourceMapper;
import com.nousuapi.forms.model.ActionFormModelResource;
import com.nousuapi.forms.service.SignUpService;
import com.nousuapi.forms.signup.model.SignupResource;

@RestController
@RequestMapping("/api/signup")
public class SignUpController {

	private static Logger logger = LoggerFactory.getLogger(SignUpController.class);
	
	@Autowired
	private SignUpService signUpService;
	
	@PostMapping("/")
	public ResponseEntity<SignupResource> signUp(@RequestBody List<ActionFormModelResource> signUpForm) throws Docx4JException, MessagingException, JSONException {
		
		SignupResource signUpFormModel = SignupResource.mapFromActionModel(signUpForm);
		signUpService.signChild(signUpFormModel);
		
		File file = new File("Laskupohjamalli.docx");
		
		try {
			DocumentHelperUtil docs = new DocumentHelperUtil();
			CreateFormDoc form = new CreateFormDoc();
			form.populateWord(docs.getTemplate(file), signUpForm, signUpFormModel);
		} catch (FileNotFoundException e) {
			logger.error("File not found :: " + e.getStackTrace());
		} catch (IOException e) {
			logger.error("File not found :: " + e.getStackTrace());
		}
		
		try {
			sendPaymentEmail(new File("Ilmoittautumislasku.docx"), signUpFormModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<SignUpResourceMapper> getSignedUpUsers() {
		List<SignupResource> listUsers = signUpService.getSignedUsers(null);
		SignUpResourceMapper result = new SignUpResourceMapper();
		result.setSignUpList(listUsers);
		result.add(linkTo(SignUpController.class).slash("/generate/kerho").withRel("downloadClubSheet"));
		result.add(linkTo(SignUpController.class).slash("/generate/joukkue").withRel("downloadTeamSheet"));
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/generate/{name}")
	public ResponseEntity<String> generateExcel(@Context HttpServletResponse response, @PathVariable(name = "name") String name) throws IOException {
		List<SignupResource> listUsers = signUpService.getSignedUsers(name);
		SignUpExcel generate = new SignUpExcel();
		generate.generateForSignedUsers(response, listUsers);
		return new ResponseEntity<String>("OK", HttpStatus.CREATED);
		
	}
		
	public void sendPaymentEmail(File file, SignupResource signUpFormModel) throws Exception {
		EmailUtil sendAttachmentViaEmail = new EmailUtil();
		 
		sendAttachmentViaEmail.paymentEmail(file, signUpFormModel);
	}
}
