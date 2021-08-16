package bap.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bap.com.demo.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {



}