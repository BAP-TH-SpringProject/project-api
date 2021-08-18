package bap.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bap.com.demo.model.Payments;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Long> {

}
