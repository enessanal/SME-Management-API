package com.kz.sme_management.repository.customer;

import com.kz.sme_management.model.customer.Address;
import com.kz.sme_management.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String>
{
    void deleteAddressesByCustomer(Customer customer);
}
