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

    public List<Users> findAll(){
        return repoUser.findAll();
    }

    public Users save(Users users) {
        return repoUser.save(users);
    }

    public Optional<Users> findById(Long id) {
        return repoUser.findById(id);
    }


    public void delete(long id) {
    	repoUser.deleteById(id);
    }

	public void update(long id, Users users) {
		repoUser.save(users);

	}

}


