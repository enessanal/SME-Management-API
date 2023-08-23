package com.kz.sme_management.service.product.impl;

import com.kz.sme_management.model.product.Product;
import com.kz.sme_management.repository.product.ProductRepository;
import com.kz.sme_management.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService
{
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll()
    {

        return productRepository.findAll();
    }
}
