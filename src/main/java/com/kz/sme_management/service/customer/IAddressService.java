package com.kz.sme_management.service.customer;

import com.kz.sme_management.model.customer.Address;
import com.kz.sme_management.model.customer.Customer;

public interface IAddressService {
    Address create(Address address, Customer customer);

    void deleteByCustomer(Customer customer);
    void deleteById(String id);

    Address findById(String id);
}
