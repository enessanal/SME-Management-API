package com.kz.sme_management.service;

import com.kz.sme_management.exception.NotFoundException;
import com.kz.sme_management.model.Customer;
import com.kz.sme_management.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService
{
    private final CustomerRepository customerRepository;

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
}
