package com.example.controller.customer;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static boolean sendMail(String toMail,String subject,String Content) {
		boolean sentMail=false;
		
		String to=toMail;
		String from="allurushivani@gmail.com";
		String host="smtp.mail.com";
		Properties properties=System.getProperties();
		properties.put("mail.smtp.socketFactory.port","465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
		
		 Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

	            protected PasswordAuthentication getPasswordAuthentication() {

	                return new PasswordAuthentication("allurushivani@gmail.com", "ldev qiqr jvzf jder");

	            }

	        });
		  try {
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(from));

	            // Set To: header field of the header.
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	            // Set Subject: header field
	            message.setSubject(subject);
	            String msg=Content;

	            // Now set the actual message
	            //message.setText("Hi! How r U: 98827");
	            message.setContent(msg, "text/html");

	            System.out.println("sending...");
	            // Send message
	            Transport.send(message);
	            //System.out.println("Sent message successfully....");
	        } catch (MessagingException mex) {
	            mex.printStackTrace();
	        }
			return sentMail;
			
		}

	}


