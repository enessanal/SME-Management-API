package com.kz.sme_management.service.product;

import com.kz.sme_management.dto.product.ListProductDto;
import com.kz.sme_management.model.product.Brand;
import com.kz.sme_management.model.product.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IProductService
{
    public Page<ListProductDto> findAll(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction);
    Product findById(String id);

    List<Product> findProductsByBrand(Brand brand);
}
