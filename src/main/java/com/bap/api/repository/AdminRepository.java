package com.bap.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bap.api.model.entity.Administrator;

@Repository
public interface AdminRepository extends JpaRepository<Administrator, Long> {
    @Query("select u from Administrator u where u.email = ?1")
    AdminRepository findAdmin(String email);
}
