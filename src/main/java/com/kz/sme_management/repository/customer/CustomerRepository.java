package com.kz.sme_management.repository.customer;

import com.kz.sme_management.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>
{
    Optional<Customer> findCustomerByCode(String code);
    Optional<Customer> findCustomerByIdentityNumber(String identityNumber);

    void deleteCustomerByCode(String code);
    void deleteCustomerByIdentityNumber(String identityNumber);
}
