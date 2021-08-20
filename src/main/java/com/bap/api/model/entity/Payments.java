package com.bap.api.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity


@NoArgsConstructor
@AllArgsConstructor
public class Payments implements Serializable{

    @Id
    @Column(name = "id_paid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paid;

    @ManyToOne
//  @MapsId("id_product")
    @JoinColumn(name = "id_product")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Products products;

    @ManyToOne
//  @MapsId("id_user")
    @JoinColumn(name = "id_user")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Users users;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "total")
    private double total;
    @Column(name = "payment_method")
    private String payment_method;
	public Long getId_paid() {
		return id_paid;
	}
	public void setId_paid(Long id_paid) {
		this.id_paid = id_paid;
	}
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

}