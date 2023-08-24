package com.kz.sme_management.repository.product;

import com.kz.sme_management.model.product.Brand;
import com.kz.sme_management.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>
{
    List<Product> findByBrand(Brand brand);

    Optional<Product> findByName(String name);
}
