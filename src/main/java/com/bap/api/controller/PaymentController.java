package com.bap.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bap.api.model.entity.Payments;
import com.bap.api.service.PaymentService;

@RestController
@RequestMapping("/admin")
/**
 * The PaymentController is the class that help admin can manage products
 *
 * @author admin
 *
 */
public class PaymentController {
    @Autowired
    private PaymentService PaymentService;

    @GetMapping("/payments")
    /**
     * This is a method to get all payments
     *
     * @return
     */
    public List<Payments> getListPayment() {
        List<Payments> payments = new ArrayList<Payments>();
        List<Payments> result = PaymentService.findAll();
        for (Payments item : result) {
            payments.add(item);
        }
        return payments;
    }

    @GetMapping("/payment/{id}")
    /**
     * This is a method to get a payment by id
     *
     * @param id
     * @return
     */
    public ResponseEntity<Payments> getPayment(@PathVariable("id") Long id) {
        // @PathVariable lay ra thông tin trong URL
        Optional<Payments> productOptional = PaymentService.findById(id);
        return productOptional.map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/addPay")
    /**
     * This is a method to add a payment
     *
     * @param payments
     * @return
     */
    public ResponseEntity<Payments> createPayment(@ModelAttribute Payments payments) {
        return new ResponseEntity<>(PaymentService.save(payments), HttpStatus.OK);
    }

    @PutMapping("/editPay/{id}")
    /**
     *
     * @param id
     * @param payments
     * @return
     */
    public ResponseEntity<Payments> updatePayment(@PathVariable("id") Long id, @ModelAttribute Payments payments) {
        Optional<Payments> productOptional = PaymentService.findById(id);
        return (ResponseEntity<Payments>) productOptional.map(payment1 -> {
            payments.setId_paid(payment1.getId_paid());
            return new ResponseEntity<>(PaymentService.save(payments), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/deletePay/{id}")

    /**
     * This is a method to delete the payment by id
     *
     * @param id
     * @return
     */
    public ResponseEntity<Payments> delete(@PathVariable Long id) {
        Optional<Payments> productOptional = PaymentService.findById(id);
        return productOptional.map(payments -> {
            PaymentService.remove(id);
            return new ResponseEntity<>(payments, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
