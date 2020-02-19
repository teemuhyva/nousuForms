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

import com.nousuapi.forms.createform.CreateActionPlan;
import com.nousuapi.forms.createform.CreateFormDoc;
import com.nousuapi.forms.emailutil.EmailUtil;
import com.nousuapi.forms.excelutil.BudgetExcel;
import com.nousuapi.forms.exceptions.ErrorLogging;
import com.nousuapi.forms.helpers.DocumentHelperUtil;
import com.nousuapi.forms.model.ActionFormModelResource;
import com.nousuapi.forms.model.BudgetModelResource;


@RestController
@RequestMapping("/api/forms")
public class FormsController {
	
	@PostMapping("/actionForm")
	public ResponseEntity<?> createForm(@RequestBody List<ActionFormModelResource> actionForm) throws Exception {
		CreateFormDoc form = new CreateFormDoc();
		File file = new File("Toimintakertomus.docx");		
		
		try {
			DocumentHelperUtil docs = new DocumentHelperUtil();
			form.populateWord(docs.getTemplate(file), actionForm, null);
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
		}
		
		try {
			SendEmailWithAttachment(new File("Toimintakertomus2.docx"), actionForm);
		} catch (IOException e) {
			e.getMessage();
		}
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/actionplan")
	public ResponseEntity<?> createActionPlan(@RequestBody List<ActionFormModelResource> actionPlan) throws Exception {
		CreateActionPlan form = new CreateActionPlan();
		File file = new File("Toimintasuunnitelma.docx");		
		
		try {
			DocumentHelperUtil docs = new DocumentHelperUtil();
			form.generateActionPlan(docs.getTemplate(file), actionPlan);
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
		}
		
		try {
			SendEmailWithAttachment(new File("Toimintasuunnitelma2.docx"), actionPlan);
		} catch (IOException e) {
			e.getMessage();
		}
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/budgetassesment")
	public ResponseEntity<?> createBudgetAssesment(@RequestBody BudgetModelResource budget) throws Exception {		
		BudgetExcel.createBudgetExcel(budget);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	public ErrorLogging SendEmailWithAttachment(File file, List<ActionFormModelResource> actionForm) throws Exception {
		ErrorLogging log = new ErrorLogging();
		EmailUtil sendAttachmentViaEmail = new EmailUtil();
		 
		try {			 
			 log = sendAttachmentViaEmail.createEmail(file, actionForm);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		 
		return log;
	}
}
