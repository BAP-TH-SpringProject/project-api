package com.bap.api.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bap.api.model.dto.EmailDTO;
import com.bap.api.service.JwtUserDetailsService;

@Controller
public class MailController {
    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    public JwtUserDetailsService sendEmail;
    @ResponseBody
    @PostMapping("/forgotPassword")
    public String testEmail(@RequestBody EmailDTO email) throws MessagingException {
        sendEmail.forgetPassword(email.getEmail());
        return "Set new password is successful!";
    }

}
