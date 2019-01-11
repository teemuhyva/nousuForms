package com.nousuapi.forms.emailutil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {
	
	InputStream inputStream;
	
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	
	
	public void createEmail() throws MessagingException, FileNotFoundException {
	  Properties props = new Properties();
	  String propFileName = "application.properties";
	  inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
	  
	  try {
		props.load(inputStream);
		} catch (IOException e) {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.put("mail.smtp.port", "587");
      
      String from = "teemuhyva@gmail.com";
      String to = "teemuhyva@gmail.com";
      
      Session session = Session.getInstance(props, new javax.mail.Authenticator() {

          protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication("teemuhyva@gmail.com", "");
          }
      });

      try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
         message.setSubject("This is the Subject Line!");
         BodyPart messageBodyPart = new MimeBodyPart();
         messageBodyPart.setText("This is message body");
         Multipart multipart = new MimeMultipart();
         multipart.addBodyPart(messageBodyPart);
         messageBodyPart = new MimeBodyPart();
         String filename = "src\\main\\resources\\templates\\Toimintakertomus.docx";
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);

         message.setContent(multipart);

         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}
