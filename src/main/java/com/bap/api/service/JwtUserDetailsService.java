package com.bap.api.service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bap.api.config.mail.MyConstants;
import com.bap.api.model.dto.UserDTO;
import com.bap.api.model.entity.Users;
import com.bap.api.repository.UserRepository;

/*
JWTUserDetailsService implements the Spring Security UserDetailsService interface.
It overrides the loadUserByUsername for fetching user details from the database using the username.
The Spring Security Authentication Manager calls this method for getting the user details from the database
when authenticating the user details provided by the user. Here we are getting the user details from a hardcoded
User List. In the next tutorial we will be adding the DAO implementation for fetching User Details from the Database.
Also the password for a user is stored in encrypted format using BCrypt.
Previously we have seen Spring Boot Security - Password Encoding Using Bcrypt.
Here using the Online Bcrypt Generator you can generate the Bcrypt for a password.
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

    // to query in the database
    @Autowired
    private UserRepository repoUser;
    //Send Email
    @Autowired
    private EmailService sendEmail; 
    // Password Encoder
    @Autowired
    private PasswordEncoder bcryptEncoder;

//    @Autowired
//    private org.apache.logging.log4j.core.Logger logger;
    
// Search for users by user name
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("User Name: " + username);
        Users user = repoUser.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        // User Object in Java Security library
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        //Set Authorization
        if(user.getRoles() == 0) {
            GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
            grantList.add(authority);
        }else {
            GrantedAuthority authority = new SimpleGrantedAuthority("USER"); 
            grantList.add(authority);
        }
        return new User(user.getUserName(), user.getPassword(),grantList);
    }
    public int getRoles(String username) {
        Users user = repoUser.findByUsername(username);
        if (user == null) {
            return 1;
        }
        if(user.getRoles() == 0) {
            return 0;
        }
        return 1;
    }
    // Forget Password
    public void forgotPassword(String email) {
        Users user = repoUser.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        int min = 10000;
        int max = 99999;      
        //Generate random int value from min to max 
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        String generatedString = "New_" + random_int;
        try {
            sendEmail.sendHtmlEmail(email, "New Password Of Teddy Website", "New Password: "+generatedString); 
            user.setPassword(bcryptEncoder.encode(generatedString));
            repoUser.save(user);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    // Create a new user in the database
    public Users save(UserDTO user) {
        Users newUser = new Users();
        newUser.setUserName(user.getUserName());
        newUser.setFullName(user.getFullName());
        newUser.setEmail(user.getEmail());
        // set password is encrypted
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setPhone(user.getPhone());
        newUser.setAddress(user.getAddress());
        return repoUser.save(newUser);
    }
}
