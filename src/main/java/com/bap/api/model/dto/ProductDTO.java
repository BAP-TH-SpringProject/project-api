package com.bap.api.model.dto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String productName;

    private String productType;

    private String image;

    private double sale;

    private int quantity;

    private double price;

    private String descriptions;
}
