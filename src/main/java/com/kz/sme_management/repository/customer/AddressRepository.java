package com.kz.sme_management.repository.customer;

import com.kz.sme_management.model.customer.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String>
{

}
