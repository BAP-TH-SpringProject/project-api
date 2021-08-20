package com.bap.api.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bap.api.model.entity.Payments;
import com.bap.api.repository.PaymentRepository;


@Service
@Transactional
public class PaymentService {
    @Autowired
    private PaymentRepository repoPayment;

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
    public Payments save(Payments payments) {
        return repoPayment.save(payments);
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
}
