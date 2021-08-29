package com.bap.api.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bap.api.model.dto.PaymentDTO;
import com.bap.api.model.entity.Payments;
import com.bap.api.model.entity.Products;
import com.bap.api.model.entity.Users;
import com.bap.api.repository.PaymentRepository;
import com.bap.api.repository.ProductRepository;
import com.bap.api.repository.UserRepository;


@Service
@Transactional
public class PaymentService {
    @Autowired
    private PaymentRepository repoPayment;
    
    @Autowired
    private UserRepository repoUser;
    
    @Autowired
    private ProductRepository repoProduct;
    
    @Autowired
    private EmailService sendEmail;
    /**
     * get method
     * @return
     */
    public List<Payments> findAll() {
        return repoPayment.findAll();
    }

    /**
     * save method
     * @param payments
     * @return
     */
    public Payments save(PaymentDTO payment) {
        System.out.println("PaymentDTO: "+payment);
        Payments newPayment = new Payments();
        Users user = repoUser.findByID(payment.getIdUser());
        System.out.println(user);
        Products product = repoProduct.findByID(payment.getIdProduct());
        System.out.println(product);
        newPayment.setUsers(user);
        newPayment.setProducts(product);
        newPayment.setPaymentMethod(payment.getPaymentMethod());
        newPayment.setQuantity(payment.getQuantity());
        newPayment.setTotal(payment.getTotal());
        newPayment.setStatus("pending");
        return repoPayment.save(newPayment);
    }

    /**
     * get product by id method
     * @param id
     * @return
     */
    public Optional<Payments> findById(Long id) {
        return repoPayment.findById(id);
    }

    /**
     * delete method
     * @param id
     */
    public void remove(Long id) {
        repoPayment.deleteById(id);
    }

    /**
     * update method
     * @param id
     * @param payments
     */
    public void update(Long id, Payments payments) {
        repoPayment.save(payments);
    }
    public void confirm(Long id) {
        Payments payment = repoPayment.findByID(id);
        System.out.println("Payment: "+payment);
        
        if (payment == null) {
            throw new UsernameNotFoundException("Payment not found with id: " + id);
        }
        if (payment.getStatus().equals("pending")) {
            try {
                payment.setStatus("delivered");
                String sub = "Order has been confirmed";
                String content = "Your order has been confirmed by the admin and is on its way to the location you provided.\r\n"
                        + "Please contact 0799101759 for support";
                sendEmail.sendHtmlEmail(payment.getUsers().getEmail(), sub, content);
            } catch (Exception e) {
                // TODO: handle exception
            }
        } 
        repoPayment.save(payment);
    }
    public void cancel(Long id) {
        Payments payment = repoPayment.findByID(id);
        System.out.println("Payment: "+payment);
        
        if (payment == null) {
            throw new UsernameNotFoundException("Payment not found with id: " + id);
        }
        if (payment.getStatus().equals("pending")) {
            try {
                payment.setStatus("canceled");
                String sub = "Order canceled";
                String content = "Your order has been cancelled.\r\n"
                        + "Please contact 0799101759 for support";
                sendEmail.sendHtmlEmail(payment.getUsers().getEmail(), sub, content);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }else if (payment.getStatus().equals("canceled")) {
                payment.setStatus("pending");
        }else {
            payment.setStatus("delivered");
        }
        repoPayment.save(payment);
    }
}
