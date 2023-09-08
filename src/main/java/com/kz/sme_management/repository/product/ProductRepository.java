package com.kz.sme_management.repository.product;

import com.kz.sme_management.dto.product.ListProductDto;
import com.kz.sme_management.model.product.Brand;
import com.kz.sme_management.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product>
{
    List<Product> findByBrand(Brand brand);

    Optional<Product> findByName(String name);

    List<Product> findProductsByBrand(Brand brand);

    List<Product> findByIdIn(List<String> ids);

}
