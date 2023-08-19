package com.kz.sme_management.service.customer;

import com.kz.sme_management.model.customer.Customer;

import java.util.List;

public interface ICustomerService
{
    List<Customer> findAll();
    Long count();
    Customer findById(String id);
    Customer findByAccountCode(String accountCode);
    Customer findByIdIdentityNumber(String identityNumber);

    void deleteById(String id);
}
