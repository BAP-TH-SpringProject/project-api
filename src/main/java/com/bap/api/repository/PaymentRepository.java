package com.bap.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bap.api.model.entity.Payments;



@Repository
public interface PaymentRepository extends JpaRepository<Payments, Long> {}