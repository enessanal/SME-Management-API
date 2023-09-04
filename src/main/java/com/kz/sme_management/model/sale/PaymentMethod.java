package com.kz.sme_management.model.sale;

import lombok.Getter;

@Getter
public enum PaymentMethod {

    CASH("Nakit"),
    CREDIT_CARD("Kredi Kartı"),
    BANK_TRANSFER("Havale"),
    CREDIT("Kredi");


    private final String paymentMethod;
    PaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


}
