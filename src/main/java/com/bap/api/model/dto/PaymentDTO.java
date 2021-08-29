package com.bap.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private Long idUser;
    private Long idProduct;
    private Long quantity;
    private double total;
    private String paymentMethod;
    private String status;
}
