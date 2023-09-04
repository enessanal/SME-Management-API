package com.kz.sme_management.service.contract;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CartItemDto {

    private String productId;
    private int count;
    private Double price;
    private Date deliveryDate;
}
