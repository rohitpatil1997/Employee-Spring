package com.example.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Base64;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
	

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String sender, String recipient, String subject, String body,String base64) throws MessagingException, IOException {
    	
//        MimeMessage message1 = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message1, true);
        MimeMessage message=javaMailSender.createMimeMessage();
    	MimeMessageHelper helper=new MimeMessageHelper(message,true);
        // Create a SimpleMailMessage
//        SimpleMailMessage message = new SimpleMailMessage();
        byte[] byteArray = Base64.getDecoder().decode(base64);

    	
//    	byte[] bs=file.getBytes();
//    	String attachmentFilename = "attachment.pdf"; // Specify the desired filename with the appropriate extension
    	String contentType = "application/octet-stream"; // Specify the desired content type
    	Resource attachmentResource = new ByteArrayResource(byteArray);
    	

        
//        message.setFrom(sender);
//        message.setTo(recipient);
//        message.setSubject(subject);
//        message.setText(body);
    	  helper.setFrom(sender);
          helper.setTo(recipient);
          helper.setSubject(subject);
          helper.setText(body, true); // Set the HTML content
          helper.addAttachment("attachment.pdf", attachmentResource, contentType);
          helper.setReplyTo("ashishparte143@gmail.com");
//          helper.addAttachment(file2.getName(), file2);

        // Send the email
        javaMailSender.send(message);
    }
    

}
