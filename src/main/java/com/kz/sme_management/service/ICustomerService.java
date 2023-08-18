package com.kz.sme_management.service;

import com.kz.sme_management.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService
{
    List<Customer> findAll();
    Customer findById(String id);
    Customer findByAccountCode(String accountCode);
    Customer findByIdIdentityNumber(String identityNumber);
}
