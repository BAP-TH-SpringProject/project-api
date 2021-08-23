package com.bap.api.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bap.api.config.mail.MyConstants;

@Controller
public class MailController {
    @Autowired
    public JavaMailSender emailSender;
 
    @ResponseBody
    @RequestMapping("/sendHtmlEmail")
    public String sendHtmlEmail() throws MessagingException {
        
        MimeMessage message = emailSender.createMimeMessage();
 
        boolean multipart = true;
         
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
         
        String htmlMsg = "<h3>Im testing send a HTML email</h3>"
                +"<img src='https://vietnamsummit.org/wp-content/uploads/2016/08/logo-bap-software-1.png'>";
         
        message.setContent(htmlMsg, "text/html");
         
        helper.setTo(MyConstants.FRIEND_EMAIL);
         
        helper.setSubject("Test send HTML email");
         
     
        this.emailSender.send(message);
 
        return "Email Sent!";
    }
    @ResponseBody
    @PostMapping("/sendHtmlEmail")
    public boolean sendHtmlEmail(String email, String sub, String content) throws MessagingException {
        
        MimeMessage message = emailSender.createMimeMessage();
 
        boolean multipart = true;
         
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
         
        String htmlMsg = "<h3>"+content+"</h3>"
                +"<img src='https://vietnamsummit.org/wp-content/uploads/2016/08/logo-bap-software-1.png'>";
         
        message.setContent(htmlMsg, "text/html");
         
        helper.setTo(MyConstants.FRIEND_EMAIL);
         
        helper.setSubject(sub);
         
     
        this.emailSender.send(message);
 
        return true;
    }
    @ResponseBody
    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleEmail() {
 
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
         
        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Test Simple Email");
        message.setText("Hello, Im testing Simple Email");
 
        // Send Message!
        this.emailSender.send(message);
 
        return "Email Sent!";
    }
}
