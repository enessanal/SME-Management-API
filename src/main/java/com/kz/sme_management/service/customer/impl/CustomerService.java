package com.kz.sme_management.service.customer.impl;

import com.kz.sme_management.dto.AddressAddDto;
import com.kz.sme_management.exception.NotFoundException;
import com.kz.sme_management.model.customer.Address;
import com.kz.sme_management.model.customer.Customer;
import com.kz.sme_management.repository.customer.CustomerRepository;
import com.kz.sme_management.service.customer.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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

    public void addAddress(AddressAddDto addressAddDto, String id)
    {
        Customer customer = this.findById(id);

        if(customer.getAddresses().size()>=5)
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        if(customer.getAddresses().stream().anyMatch(address -> address.getName().equals(addressAddDto.getName())))
            throw new ResponseStatusException(HttpStatus.CONFLICT);

        addressService.create(new Address(addressAddDto.getName(), addressAddDto.getCity(), addressAddDto.getDistrict(), addressAddDto.getDetails()), customer);
    }





}
