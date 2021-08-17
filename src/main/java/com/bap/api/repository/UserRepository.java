package com.bap.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bap.api.model.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    @Query("select u from Users u where u.user_name = ?1")
    Users findByUsername(String user_name);
}
