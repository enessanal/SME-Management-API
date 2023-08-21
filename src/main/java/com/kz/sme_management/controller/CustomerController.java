package com.kz.sme_management.controller;

import com.kz.sme_management.dto.customer.AddAddressDto;
import com.kz.sme_management.dto.customer.ListCustomerDto;
import com.kz.sme_management.model.customer.Address;
import com.kz.sme_management.model.customer.Customer;
import com.kz.sme_management.service.customer.impl.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Page<Customer> getCustomers(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction)
    {

        return customerService.findAll(page,size,sortBy,direction);



//        return customerService.findAll().stream().map(ListCustomerDto::new).collect(toList());

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

    @GetMapping("/code/{code}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a Customer by unique code")
    public Customer getCustomerByCode(@PathVariable String code)
    {
        return customerService.findByCode(code);
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
    public void deleteCustomerById(@PathVariable String id)
    {
        customerService.deleteById(id);
    }

    @DeleteMapping("/code/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a Customer by unique code")
    public void deleteCustomerByCode(@PathVariable String code)
    {
        customerService.deleteByCode(code);
    }

    @DeleteMapping("/tc/{tc}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a Customer by Identity Number (tc)")
    public void deleteCustomerByIdentityNumber(@PathVariable String tc)
    {
        customerService.deleteByIdentityNumber(tc);
    }



    @PostMapping("/id/{id}/addresses")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create an address for a customer")
    public void addAddress(@PathVariable String id, @RequestBody AddAddressDto addAddressDto)
    {
        customerService.addAddress(addAddressDto, id);
    }

    @GetMapping("/id/{id}/addresses")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all addresses of a customer")
    public List<Address> getAddresses(@PathVariable String id )
    {
        return customerService.getAddresses(id);
    }

    @GetMapping("/id/{id}/addresses/{addressId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get an address of a customer by id")
    public Address getAddress(@PathVariable String id, @PathVariable String addressId)
    {
        return customerService.getAddress(id, addressId);
    }

    @DeleteMapping("/id/{id}/addresses")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete all addresses of a customer by id")
    public void deleteAddresses(@PathVariable String id)
    {
        customerService.deleteAddresses(id);
    }




}
