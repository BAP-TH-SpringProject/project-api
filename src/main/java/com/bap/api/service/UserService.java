package com.bap.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bap.api.model.entity.Users;
import com.bap.api.repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repoUser;

    @Autowired
    private EmailService sendEmail;

    /**
     * This is a mothed to get list users
     * 
     * @return
     */
    public List<Users> findAll() {
        return repoUser.findAll();
    }

    /**
     * This is a method to save a user
     * 
     * @param users
     * @return
     */
    public Users update(Users user) {
        return repoUser.save(user);
    }

    /**
     * This is a method to get a user by id
     * 
     * @param id
     * @return
     */
    public Optional<Users> findById(Long id) {
        return repoUser.findById(id);
    }

    /**
     * This is a method to delete a user by id
     * 
     * @param id
     */
    public void banUser(Long id) {
        Users user = repoUser.findByID(id);
        System.out.println("User: "+user);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with id: " + id);
        }
        if (user.getStatus().equals("active")) {
            try {
                user.setStatus("banned");
                String sub = "You have been banned from using the service at teddy.vn";
                String content = "Due to a violation, your account has been disabled by the administrator";
                sendEmail.sendHtmlEmail(user.getEmail(), sub, content);
            } catch (Exception e) {
                // TODO: handle exception
            }
        } else {
            try {
                user.setStatus("active");
                String sub = "Notice from teddy.vn";
                String content = "Your account is allowed to work again";
                sendEmail.sendHtmlEmail(user.getEmail(), sub, content);
            } catch (Exception e) {
                // TODO: handle exception
            } 
        }
        System.out.println("Status: "+user.getStatus());
        repoUser.save(user);
//        sendEmail.sendHtmlEmail("123","123","123");
    }

    public void delete(Long id) {
        repoUser.deleteById(id);
    }

    /**
     * This is a method to update a user by is
     * 
     * @param id
     * @param users
     */
    public void update(Long id, Users users) {
        repoUser.save(users);

    }

}