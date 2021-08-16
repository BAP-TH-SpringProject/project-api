package bap.com.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<Users> findAll(){
        return repo.findAll();
    }

    public Users save(Users users) {
        return repo.save(users);
    }

    public Optional<Users> findById(Long id) {
        return repo.findById(id);
    }


    public void delete(long id) {
        repo.deleteById(id);
    }

	public void update(long id, Users users) {
		repo.save(users);

	}

}


