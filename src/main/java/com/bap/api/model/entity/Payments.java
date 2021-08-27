package com.bap.api.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payments{

    @Id
    @Column(name = "id_paid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_product", nullable=false)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Products products;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable=false)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Users users;
    
    @Column(name = "quantity")
    private Long quantity;
    
    @Column(name = "total")
    private double total;
    
    @Column(name = "payment_method")
    private String paymentMethod;
    
    @Column(name = "status")
    private String status;
    
}