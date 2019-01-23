package com.nousuapi.forms.emailutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.logging.Logger;

import javax.mail.MessagingException;

import com.nousuapi.forms.model.ActionFormModel;
import com.nousuapi.forms.model.EmailLogger;
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
	
	private static Logger logger = Logger.getLogger(EmailUtil.class.getName());
	
	InputStream inputStream;	
	
	public EmailLogger createEmail(File file, ActionFormModel actionForm) throws MessagingException, FileNotFoundException, IOException {
	  EmailLogger eLogger = new EmailLogger();
	  
      SendGrid sendGrid = new SendGrid(System.getenv("SENDGRID_APIKEY"));
      String subject = "Toimintakertomus - "+ actionForm.getSignature();
      Email from = new Email("jyvaskylanousu@gmail.com");
      Email to = new Email("jyvaskylanousu@gmail.com");
      Content content = new Content();
      content.setType("text/plain");
      content.setValue("Hei.\n\n Liitteenä toimintakertomus. \n\n Ystävällisin Terveisin\n" + actionForm.getSignature());
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
    	  eLogger.setStartEmail("Email send");
    	  eLogger.setStatusCode(response.getStatusCode());
    	  
      } catch(IOException e) {
    	  eLogger.setErrorPart5(e.getMessage());
    	  throw e;
      }
      
      return eLogger;
   }
}
