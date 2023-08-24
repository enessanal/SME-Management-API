package com.kz.sme_management.repository.product;

import com.kz.sme_management.model.product.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String>
{
    Optional<Brand> findByName (String name);
}
