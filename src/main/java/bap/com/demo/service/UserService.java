package bap.com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bap.com.demo.model.Users;
import bap.com.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repoUser;

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
    public Users save(Users user) {
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
    public void delete(long id) {
        repoUser.deleteById(id);
    }

    /**
     * This is a method to update a user by is
     * 
     * @param id
     * @param users
     */
    public void update(long id, Users users) {
        repoUser.save(users);

    }

}
