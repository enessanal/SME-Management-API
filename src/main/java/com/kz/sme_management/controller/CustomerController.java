package com.kz.sme_management.controller;

import com.kz.sme_management.model.Customer;
import com.kz.sme_management.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${PATH_CUSTOMERS}")
public class CustomerController
{
    private final CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomers()
    {
        return customerService.findAll();
    }

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public Long countCustomers()
    {
        return customerService.count();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable String id)
    {
        return customerService.findById(id);
    }

    @GetMapping("/accountCode/{accountCode}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerByAccountCode(@PathVariable String accountCode)
    {
        return customerService.findByAccountCode(accountCode);
    }

    @GetMapping("/tc/{tc}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerByIdentityNumber(@PathVariable String tc)
    {
        return customerService.findByIdIdentityNumber(tc);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable String id)
    {
        customerService.deleteById(id);
    }




}
