package com.kz.sme_management.service.customer;

import com.kz.sme_management.dto.customer.ListCustomerDto;
import com.kz.sme_management.model.customer.Address;
import com.kz.sme_management.model.customer.Customer;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ICustomerService
{
    Page<ListCustomerDto> findAll(Map<String, String> allParameters);
    Long count();
    Customer findById(String id);
    Customer findByCode(String code);
    Customer findByIdIdentityNumber(String identityNumber);

    void deleteById(String id);
    void deleteByCode(String code);
    void deleteByIdentityNumber(String identityNumber);

    Address getAddress(String id, String addressId);
    List<Address> getAddresses(String id);

    void deleteAddresses(String id);
}
