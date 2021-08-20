package com.bap.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bap.api.model.entity.Administrator;

@Repository
public interface AdminRepository extends CrudRepository<Administrator, Long> {
    @Query("select u from Users u where u.email = :email")
    Administrator findAdministrator(@Param("email") String email);
}
