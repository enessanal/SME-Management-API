package com.kz.sme_management.repository.product;

import com.kz.sme_management.model.product.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<Type,String>
{
    Optional<Type> findByName(String name);
}
