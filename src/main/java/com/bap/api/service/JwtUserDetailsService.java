package com.bap.api.service;

import java.util.ArrayList;

import com.bap.api.model.entity.Users;
import com.bap.api.model.dto.UserDTO;
import com.bap.api.repository.UserRepository;

import ch.qos.logback.classic.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

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
    private UserRepository userDao;

    // Password Encoder
    @Autowired
    private PasswordEncoder bcryptEncoder;

//    @Autowired
//    private org.apache.logging.log4j.core.Logger logger;
    
// Search for users by user name (Tìm Kiếm user thông qua user name)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
         //logger.warn("User Name: " + username);
        System.out.println("User Name: " + username);
        Users user = userDao.findByUsername(username);
        if (user == null) {
            // Nếu không tìm thấy thì thông báo không tồn tại user này
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        // Nếu tìm thấy User thì truyền tài khoản mật khẩu vào và xác thực
        // User này là của thư viện security (org.springframework.security.core.userdetails.User;)
        return new User(user.getUser_name(), user.getPassword(),
                new ArrayList<>());
    }

    // Create a user in the database (Tạo user trong database)
    public Users save(UserDTO user) {
        Users newUser = new Users();
        newUser.setUser_name(user.getUser_name());
        // set password is encrypted
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(newUser);
    }
}
