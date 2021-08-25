package com.bap.api.controller;

import javax.mail.MessagingException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bap.api.model.dto.EmailDTO;
import com.bap.api.service.JwtUserDetailsService;
@CrossOrigin
@RestController
public class MailController {
    @Autowired
    public JwtUserDetailsService sendEmail;
    
    // Forgot password
    @PostMapping("/forgotPassword")
    public boolean testEmail(@RequestBody EmailDTO email) throws MessagingException {
        try {
            sendEmail.forgotPassword(email.getEmail());
            return true; 
        } catch (Exception e) {
            return false;
        }

    }

}
