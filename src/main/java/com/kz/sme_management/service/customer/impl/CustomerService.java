package com.kz.sme_management.service.customer.impl;

import com.kz.sme_management.dto.customer.AddAddressDto;
import com.kz.sme_management.exception.ConflictException;
import com.kz.sme_management.exception.NotFoundException;
import com.kz.sme_management.exception.UnprocessableException;
import com.kz.sme_management.model.customer.Address;
import com.kz.sme_management.model.customer.Customer;
import com.kz.sme_management.repository.customer.CustomerRepository;
import com.kz.sme_management.service.customer.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService
{
    private final CustomerRepository customerRepository;
    private final AddressService addressService;

    @Override
    public List<Customer> findAll()
    {
        return customerRepository.findAll();
    }

    @Override
    public Long count()
    {
        return customerRepository.count();
    }

    @Override
    public Customer findById(String id)
    {
        return customerRepository.findById(id).orElseThrow( () -> new NotFoundException("Invalid customer id"));
    }

    @Override
    public Customer findByAccountCode(String accountCode)
    {
        return customerRepository.findCustomerByAccountCode(accountCode).orElseThrow( () -> new NotFoundException("Invalid customer account code"));
    }

    @Override
    public Customer findByIdIdentityNumber(String identityNumber)
    {
        return customerRepository.findCustomerByIdentityNumber(identityNumber).orElseThrow( () -> new NotFoundException("Invalid identity number"));
    }

    @Transactional
    @Override
    public void deleteById(String id)
    {
        if(customerRepository.findById(id).isEmpty())  throw new NotFoundException("Invalid customer id");

        customerRepository.deleteById(id);
    }

    @Override
    public Address getAddress(String id, String addressId)
    {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Invalid customer id"));

        return customer.getAddresses().stream().filter(address -> address.getId().equals(addressId)).findFirst().orElseThrow(() -> new NotFoundException("Invalid address id"));
    }

    @Override
    public List<Address> getAddresses(String id)
    {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Invalid customer id"));

        return customer.getAddresses();
    }

    public void addAddress(AddAddressDto addAddressDto, String id)
    {
        Customer customer = this.findById(id);

        if(customer.getAddresses().size()>=5)
            throw new UnprocessableException("A customer can have a maximum of 5 addresses.");

        if(customer.getAddresses().stream().anyMatch(address -> address.getName().equals(addAddressDto.getName())))
            throw new ConflictException("Address' name must be unique for a customer.");

        addressService.create(new Address(addAddressDto.getName(), addAddressDto.getCity(), addAddressDto.getDistrict(), addAddressDto.getDetails()), customer);
    }





}
