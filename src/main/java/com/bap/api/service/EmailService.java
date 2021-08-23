package com.bap.api.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    public JavaMailSender emailSender;
    public void sendHtmlEmail(String email, String sub, String content) throws MessagingException {
        
        MimeMessage message = emailSender.createMimeMessage();
 
        boolean multipart = true;
         
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
         
        String htmlMsg = "<h3 style='color: orangered'>"+content+"</h3>"
                +"<img src='https://vietnamsummit.org/wp-content/uploads/2016/08/logo-bap-software-1.png'>";
         
        message.setContent(htmlMsg, "text/html");
         
        helper.setTo(email);
         
        helper.setSubject(sub);
        
        this.emailSender.send(message);
    }
}
