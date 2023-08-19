package com.kz.sme_management.service.customer.impl;

import com.kz.sme_management.model.customer.Address;
import com.kz.sme_management.model.customer.Customer;
import com.kz.sme_management.repository.customer.AddressRepository;
import com.kz.sme_management.service.customer.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService implements IAddressService
{
    private final AddressRepository addressRepository;

    @Override
    public Address create(Address address, Customer customer)
    {
        address.setCustomer(customer);
        return addressRepository.save(address);
    }
}