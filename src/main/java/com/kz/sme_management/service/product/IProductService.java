package com.kz.sme_management.service.product;

import com.kz.sme_management.dto.product.ListProductDto;
import com.kz.sme_management.model.product.Brand;
import com.kz.sme_management.model.product.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface IProductService
{
    Page<ListProductDto> findAll(Map<String, String> allParameters);
    Product findById(String id);

    List<Product> findProductsByBrand(Brand brand);
}
