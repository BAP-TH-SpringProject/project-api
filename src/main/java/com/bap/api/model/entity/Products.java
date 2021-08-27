package com.bap.api.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Products {
    @Id
    @GeneratedValue
    @Column(name = "id_product", nullable = false)
    private Long id;

    @Column(name = "product_name")
    private String productName;
    
    @Column(name = "product_type")
    private String productType;
    
    @Column(name = "image")
    private String image;

    @Column(name = "sale")
    private double sale;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "descriptions")
    private String descriptions;
}
