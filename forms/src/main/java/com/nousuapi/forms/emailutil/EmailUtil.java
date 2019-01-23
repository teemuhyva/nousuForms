package com.nousuapi.forms.emailutil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import javax.mail.MessagingException;

import com.nousuapi.forms.model.EmailLogger;
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
	
	public EmailLogger createEmail() throws MessagingException, FileNotFoundException, IOException {
	  EmailLogger eLogger = new EmailLogger();
	  eLogger.setStartEmail("starting email system");
      SendGrid sendGrid = new SendGrid(System.getenv("SENDGRID_APIKEY"));
      String subject = "Toimintakertomus";
      Email from = new Email("jyvaskylanousu@gmail.com");
      Email to = new Email("jyvaskylanousu@gmail.com");
      Content content = new Content();
      content.setType("text/plain");
      content.setValue("testiemail");
      Personalization perz = new Personalization();
      perz.addTo(to);
      perz.setSubject(subject);
      
      Mail mail = new Mail();
      mail.setFrom(from);
      mail.setSubject(subject);
      mail.setReplyTo(to);
      mail.addContent(content);
      Request req = new Request();
      
      try {
    	  eLogger.setSendEmail("try cach email system");
    	  req.setMethod(Method.POST);
    	  req.setEndpoint("mail/send");
    	  req.setBody(mail.build());
    	  Response response = sendGrid.api(req);
    	  
      } catch(IOException e) {
    	  throw e;
      }
      
      return eLogger;
   }
}
