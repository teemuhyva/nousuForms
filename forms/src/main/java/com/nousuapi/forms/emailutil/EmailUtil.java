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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nousuapi.forms.createform.CreateFormDoc;
import com.nousuapi.forms.createform.PaymentTemplate;
import com.nousuapi.forms.exceptions.CustomException;
import com.nousuapi.forms.exceptions.ErrorLogging;
import com.nousuapi.forms.helpers.DocumentHelperUtil;
import com.nousuapi.forms.model.ActionFormModel;
import com.nousuapi.forms.signup.model.SignupResource;
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
		
	private static Logger logger = LoggerFactory.getLogger(EmailUtil.class);
	
	InputStream inputStream;
	
	public ErrorLogging createEmail(File file, List<ActionFormModel> actionForm) throws Exception {
	  DocumentHelperUtil docs = new DocumentHelperUtil();
	  ErrorLogging log = new ErrorLogging();
	  
	  CreateFormDoc doc = new CreateFormDoc();
	  JSONArray arr = docs.generateJsonFromForm(actionForm);
	  String signature = docs.loopJsonObjectToGetValue(arr, "signature");
	  
	  
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
	
	public void paymentEmail(File file, SignupResource signUpFormModel) throws Exception {
		  SendGrid sendGrid = new SendGrid(System.getenv("SENDGRID_APIKEY_PAYMENT"));
		  String subject = "Ilmoittautuminen syksy 2019";
	      Email from = new Email("jyvaskylanousu@gmail.com");
	      Email to = new Email(signUpFormModel.getEmail());
	      Content content = new Content();
	      content.setType("text/html");
	      content.setValue(
	    		  "<p>Hei!</p><br>" +
	    		    "<p>Kiitos ilmoittautumisesta!<br>" +
	    		    "Olemme vastaanottaneet ilmoittautumisenne jalkapallokerhoon.</p><br>" +
	    		    "<p>Liittenä lasku. Muistathan laittaa viestikenttään maksupohjassa olevan tekstin.<br>" +
	    		    "Huom. Toimintamaksulla vahvistetaan osallistuminen Nousun toimintaan. Eräpäivä kaksi viikkoa<br>" +
	    		    "ilmoittautumisesta mutta toimintamaksu on maksettava viimeistään ennen ensimmäisiä harjoituksia.<br>" +
	    		    "<p>Maksettuja toimintamaksuja ei palauteta.</p><br>" +
	    		    "<p>Laitamme ryhmänne toiminnasta tietoa viikolla 38-39.<br>" +
	    		    "Akuuteista muutoksista ilmoitamme pikaisesti ja sähköpostin välityksellä!</p><br>" +
	    		    "<p>Ystävällisin Terveisin<br>Jyväskylän Nousu ry</p>"
	      		);
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
	      attachment.setFilename("Ilmoittautumislasku.docx");
	      attachment.setDisposition("attachment");
	      mail.addAttachments(attachment);
	      
	      Request req = new Request();
	      
	      try {    	  
	    	  req.setMethod(Method.POST);
	    	  req.setEndpoint("mail/send");
	    	  req.setBody(mail.build());
	    	  Response response = sendGrid.api(req);
	      } catch(IOException e) {
	    	  logger.error(":::::::: " + e.getMessage());
	    	  throw new Exception(CustomException.SENDING_EMAIL_FAILED);
	      }
	}
	
	public void signUppedEmail(File file) throws Exception {
		  SendGrid sendGrid = new SendGrid(System.getenv("SENDGRID_APIKEY_PAYMENT"));
		  String subject = "Ilmoittautuneet";
	      Email from = new Email("jyvaskylanousu@gmail.com");
	      Email to = new Email("jyvaskylanousu@gmail.com");
	      Content content = new Content();
	      content.setType("text/plain");
	      content.setValue("uudetlmoittautuneet");
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
	      attachment.setFilename("Ilmoittautuneet.xls");
	      attachment.setDisposition("attachment");
	      mail.addAttachments(attachment);
	      
	      Request req = new Request();
	      
	      try {    	  
	    	  req.setMethod(Method.POST);
	    	  req.setEndpoint("mail/send");
	    	  req.setBody(mail.build());
	    	  Response response = sendGrid.api(req);
	    	  System.out.println(response.getStatusCode());
	    	  response.getStatusCode();
	    	  System.out.println(response.getBody());
	    	  response.getBody();
	    	  
	      } catch(IOException e) {
	    	  logger.error(":::::::: " + e.getMessage());
	    	  throw new Exception(CustomException.SENDING_EMAIL_FAILED);
	      }
	}
   
}
