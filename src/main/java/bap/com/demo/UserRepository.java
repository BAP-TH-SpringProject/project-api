package bap.com.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import bap.com.demo.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}