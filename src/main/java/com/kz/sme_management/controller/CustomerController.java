package com.kz.sme_management.controller;

import com.kz.sme_management.dto.customer.AddAddressDto;
import com.kz.sme_management.dto.customer.ListCustomerDto;
import com.kz.sme_management.model.customer.Customer;
import com.kz.sme_management.service.customer.impl.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
@RequestMapping("${PATH_CUSTOMERS}")
@Tag(name = "Customers", description = "Customer Management APIs")
public class CustomerController
{
    private final CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get customers")
    public List<ListCustomerDto> getCustomers()
    {
        return customerService.findAll().stream().map(ListCustomerDto::new).collect(toList());

    }

    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get number of all customers")
    public Long countCustomers()
    {
        return customerService.count();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a Customer by id")
    public Customer getCustomerById(@PathVariable String id)
    {
        return customerService.findById(id);
    }

    @GetMapping("/accountCode/{accountCode}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a Customer by unique account code")
    public Customer getCustomerByAccountCode(@PathVariable String accountCode)
    {
        return customerService.findByAccountCode(accountCode);
    }

    @GetMapping("/tc/{tc}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a Customer by unique identity number (tc)")
    public Customer getCustomerByIdentityNumber(@PathVariable String tc)
    {
        return customerService.findByIdIdentityNumber(tc);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a Customer by id")
    public void deleteUserById(@PathVariable String id)
    {
        customerService.deleteById(id);
    }



    @PostMapping("/id/{id}/addresses")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create an address for a customer")
    public void addAddress(@PathVariable String id, @RequestBody AddAddressDto addAddressDto)
    {
        customerService.addAddress(addAddressDto, id);
    }

}
