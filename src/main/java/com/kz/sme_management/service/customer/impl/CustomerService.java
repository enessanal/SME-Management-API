package com.kz.sme_management.service.customer.impl;

import com.kz.sme_management.model.util.Paging;
import com.kz.sme_management.dto.customer.AddAddressDto;
import com.kz.sme_management.dto.customer.ListCustomerDto;
import com.kz.sme_management.exception.ConflictException;
import com.kz.sme_management.exception.NotFoundException;
import com.kz.sme_management.exception.UnprocessableException;
import com.kz.sme_management.model.customer.Address;
import com.kz.sme_management.model.customer.Customer;
import com.kz.sme_management.repository.customer.CustomerRepository;
import com.kz.sme_management.service.customer.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService
{
    private final CustomerRepository customerRepository;
    private final AddressService addressService;

    @Override
    public Page<ListCustomerDto> findAll(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction)
    {
        Paging paging = new Paging(new int[]{10, 25, 50, 100}, new String[]{"createdTime","updateTime","code","id","email", "identityNumber", "fullName", "mobilePhone"});
        Pageable pageable = paging.getPageable(page.get(), size.get(), sortBy.get(), direction.get());




        return customerRepository.findAll(pageable).map(ListCustomerDto::new);
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
    public Customer findByCode(String code)
    {
        return customerRepository.findCustomerByCode(code).orElseThrow( () -> new NotFoundException("Invalid customer code"));
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
        if(customerRepository.findById(id).isEmpty()) throw new NotFoundException("Invalid customer id");
        customerRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByCode(String code)
    {
        if(customerRepository.findCustomerByCode(code).isEmpty()) throw new NotFoundException("Invalid customer code");
        customerRepository.deleteCustomerByCode(code);
    }

    @Transactional
    @Override
    public void deleteByIdentityNumber(String identityNumber)
    {
        if(customerRepository.findCustomerByIdentityNumber(identityNumber).isEmpty()) throw new NotFoundException("Invalid customer identity number");
        customerRepository.deleteCustomerByIdentityNumber(identityNumber);
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

    @Transactional
    @Override
    public void deleteAddresses(String id)
    {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Invalid customer id"));
        addressService.deleteByCustomer(customer);

    }

    @Transactional
    public void addAddress(AddAddressDto addAddressDto, String id)
    {
//        Customer customer = this.findById(id);

        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Invalid customer id"));

        if(customer.getAddresses().size()>=5)
            throw new UnprocessableException("A customer can have a maximum of 5 addresses.");

        if(customer.getAddresses().stream().anyMatch(address -> address.getName().equals(addAddressDto.getName())))
            throw new ConflictException("Address' name must be unique for a customer.");

        addressService.create(new Address(addAddressDto.getName(), addAddressDto.getCity(), addAddressDto.getDistrict(), addAddressDto.getDetails()), customer);
    }





}
