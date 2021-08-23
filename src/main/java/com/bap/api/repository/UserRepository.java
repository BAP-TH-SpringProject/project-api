package com.bap.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bap.api.model.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    @Query("select u from Users u where u.userName = ?1")
    Users findByUsername(String userName);
    
    @Query("select u from Users u where u.email = ?1")
    Users findByEmail(String email);
}
