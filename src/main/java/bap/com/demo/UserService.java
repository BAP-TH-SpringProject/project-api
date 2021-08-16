package bap.com.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bap.com.demo.Users;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<Users> listAll() {
        return repo.findAll();
    }

    public void save(Users users) {
        repo.save(users);
    }

    public Users get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
