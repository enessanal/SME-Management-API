package com.kz.sme_management.service.customer.impl;

import com.kz.sme_management.exception.NotFoundException;
import com.kz.sme_management.model.customer.Address;
import com.kz.sme_management.model.customer.Customer;
import com.kz.sme_management.repository.customer.AddressRepository;
import com.kz.sme_management.service.customer.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService implements IAddressService {
    private final AddressRepository addressRepository;

    @Override
    public Address create(Address address, Customer customer) {
        address.setCustomer(customer);
        return addressRepository.save(address);
    }

    @Override
    public void deleteByCustomer(Customer customer) {
        addressRepository.deleteAddressesByCustomer(customer);
    }

    @Override
    public void deleteById(String id)
    {
        if(addressRepository.findById(id).isEmpty()) throw new NotFoundException("Invalid address identity number");
        addressRepository.deleteById(id);
    }

    @Override
    public Address findById(String id) {
        return addressRepository.findById(id).orElseThrow(() -> new NotFoundException("Invalid address id"));
    }


}
