package bap.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bap.com.demo.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}