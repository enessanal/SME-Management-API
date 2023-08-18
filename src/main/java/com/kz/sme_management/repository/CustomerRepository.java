package com.kz.sme_management.repository;

import com.kz.sme_management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>
{
    Optional<Customer> findCustomerByAccountCode(String accountCode);
    Optional<Customer> findCustomerByIdentityNumber(String identityNumber);
}
