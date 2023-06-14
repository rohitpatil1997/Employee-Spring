package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import org.springframework.http.MediaType;


import com.example.employee.model.EmailData;
import com.example.employee.model.byteDto;
import com.example.employee.model.responseDto;
import com.example.employee.service.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4600")
@RestController
@RequestMapping("api/v1/")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ObjectMapper mapper;
	
//	   @PostMapping("/send-email")
//	    public ResponseEntity<String> sendEmail(@RequestBody EmailData emailData) {
//	        // Perform the email sending logic using the provided emailData
//	        // ...
//
//	        // Return an appropriate response
//	        return ResponseEntity.ok("Email sent successfully");
//	    }
	
//	@PostMapping("/send-email1")
//	public ResponseEntity<String> sendEmail1(@RequestBody EmailData emailData) {
//	    // Get email data from the request body
//	    String sender = emailData.getSender();
//	    String recipient = emailData.getRecipient();
//	    String subject = emailData.getSubject();
//	    String body = emailData.getBody();
//
//	    // SMTP server configuration
//	    Properties properties = new Properties();
//	    properties.put("mail.smtp.host", "smtp.gmail.com");
//	    properties.put("mail.smtp.port", "587");
//	    // Add additional SMTP properties if required
//
//	    // Create a Session object
//	    Session session = Session.getInstance(properties, new Authenticator() {
//	        protected PasswordAuthentication getPasswordAuthentication() {
//	            return new PasswordAuthentication("rohitbpatil@nimapinfotech,com", "Rohitpatil@97");
//	        }
//	    });
//
//	    try {
//	        // Create a MimeMessage object
//	        MimeMessage message = new MimeMessage(session);
//
//	        // Set the sender, recipient, subject, and body
//	        message.setFrom(new InternetAddress(sender));
//	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
//	        message.setSubject(subject);
//	        message.setText(body);
//
//	        // Send the email
//	        Transport.send(message);
//
//	        // Return a success response
//	        return ResponseEntity.ok("Email sent successfully");
//	    } catch (MessagingException e) {
//	        // Handle any exceptions
//	        e.printStackTrace();
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
//	    }
//	}

//    @PostMapping("/send-email")
//    public ResponseEntity<String> sendEmail(@RequestParam(value = "emailData",required = true) String emailData,@RequestParam("attachment") MultipartFile attachment) throws JsonMappingException, JsonProcessingException {
//    	
//    	EmailData data=new EmailData();
//    	data=mapper.readValue(emailData, EmailData.class);
//    	
//        String sender = data.getSender();
//        String recipient = data.getRecipient();
//        String subject = data.getSubject();
//        String body = data.getBody();
//
//        // Check for null or empty values
//        if (isNullOrEmpty(sender) || isNullOrEmpty(recipient) || isNullOrEmpty(subject) || isNullOrEmpty(body)) {
//            return ResponseEntity.badRequest().body("One or more fields are empty.");
//        }
//
//        try {
//            // Send the email
//            emailService.sendEmail(sender, recipient, subject, body,attachment);
//
//            // Return a success response
//            return ResponseEntity.ok("Email sent successfully");
//        } catch (Exception e) {
//            // Handle any exceptions
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
//        }
//    }

    
    

	    @PostMapping(value = "/send-email")
	    public ResponseEntity<?> sendEmail(@RequestBody byteDto bt) {
//		public ResponseEntity<String> sendEmail(@RequestBody byte[] attachmentData, @RequestParam(value = "emailData", required = true) String emailData) {

	    	// Process the email data
//	        EmailData data;
//	        try {
//	            data = mapper.readValue(emailData, EmailData.class);
//	        } catch (JsonProcessingException e) {
//	            return ResponseEntity.badRequest().body("Invalid email data");
//	        }
	    	EmailData emailData=bt.getData();
	        String sender = emailData.getSender();
	        String recipient = emailData.getRecipient();
	        String subject = emailData.getSubject();
	        String body = emailData.getBody();

	        
	        // Check for null or empty values
	        if (isNullOrEmpty(sender) || isNullOrEmpty(recipient) || isNullOrEmpty(subject) || isNullOrEmpty(body)) {
	            return ResponseEntity.badRequest().body("One or more fields are empty.");
	        }

	        try {
	            // Send the email
	            emailService.sendEmail(sender, recipient, subject, body, bt.getBs());

	            // Return a success response
//	            return ResponseEntity.ok("Email sent successfully",HttpStatus.OK);
	            responseDto responseDto = new responseDto();
	            responseDto.setHttpStatus(HttpStatus.OK);
	            responseDto.setStatus(true);
	            responseDto.setResult(" ");
	            responseDto.setMessage("Email sent successfully");
	            return new ResponseEntity<>(responseDto,HttpStatus.OK);
	            
	        } catch (Exception e) {
	            // Handle any exceptions
	            e.printStackTrace();
//	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
	            responseDto responseDto = new responseDto();
	            responseDto.setHttpStatus(HttpStatus.OK);
	            responseDto.setStatus(false);
	            responseDto.setResult(" ");
	            responseDto.setMessage("Failed to send email");
	            return new ResponseEntity<>(responseDto,HttpStatus.OK);
	        }
	    }


	
    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

}
