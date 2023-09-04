package com.kz.sme_management.repository.contract;

import com.kz.sme_management.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String>, JpaSpecificationExecutor<Contract> {
}
