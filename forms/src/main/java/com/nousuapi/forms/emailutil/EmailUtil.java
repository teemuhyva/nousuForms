package com.nousuapi.forms.emailutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import javax.mail.MessagingException;

import org.json.JSONArray;

import com.nousuapi.forms.createform.CreateFormDoc;
import com.nousuapi.forms.exceptions.CustomException;
import com.nousuapi.forms.exceptions.ErrorLogging;
import com.nousuapi.forms.model.ActionFormModel;
import com.sendgrid.Attachments;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Personalization;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class EmailUtil {
		
	InputStream inputStream;	
	
	public ErrorLogging createEmail(File file, List<ActionFormModel> actionForm) throws Exception {
	  ErrorLogging log = new ErrorLogging();
	  
	  CreateFormDoc doc = new CreateFormDoc();
	  JSONArray arr = doc.generateJsonFromForm(actionForm);
	  String signature = doc.loopJsonObjectToGetValue(arr, "signature");
	  
	  
	  SendGrid sendGrid = new SendGrid(System.getenv("SENDGRID_APIKEY"));
      String subject = "Toimintakertomus - " +  signature;
      Email from = new Email("jyvaskylanousu@gmail.com");
      Email to = new Email("jyvaskylanousu@gmail.com");
      Content content = new Content();
      content.setType("text/plain");
      content.setValue("Hei.\n\n Liitteenä toimintakertomus. \n\n Ystävällisin Terveisin\n" + signature);
      Personalization perz = new Personalization();
      perz.addTo(to);
      perz.setSubject(subject);
      
      Mail mail = new Mail();
      mail.setFrom(from);
      mail.setSubject(subject);
      mail.setReplyTo(to);
      mail.addContent(content);
      mail.addPersonalization(perz);
      
      byte[] filedata = org.apache.commons.io.IOUtils.toByteArray(new FileInputStream(file));
      Attachments attachment = new Attachments();
      String fileString = Base64.getEncoder().encodeToString(filedata);
      
      attachment.setContent(fileString);
      attachment.setFilename("Toimintakertomus.docx");
      attachment.setDisposition("attachment");
      mail.addAttachments(attachment);
      
      Request req = new Request();
      
      try {    	  
    	  req.setMethod(Method.POST);
    	  req.setEndpoint("mail/send");
    	  req.setBody(mail.build());
    	  Response response = sendGrid.api(req);
    	  
      } catch(IOException e) {
    	  log.setError5(e.getMessage());
    	  throw new Exception(CustomException.SENDING_EMAIL_FAILED);
      }
      return log;
   }   
   
}
