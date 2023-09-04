package com.kz.sme_management.service.contract;

import com.kz.sme_management.model.sale.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ContractDTO {

    private String customerId;
    private String addressId;
    private Long employeeId;
    private List<CartItemDto> cart;
    private PaymentMethod paymentMethod;

}
