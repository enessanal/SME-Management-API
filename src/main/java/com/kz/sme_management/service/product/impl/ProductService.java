package com.kz.sme_management.service.product.impl;

import com.kz.sme_management.dto.product.ListProductDto;
import com.kz.sme_management.model.product.Product;
import com.kz.sme_management.repository.product.ProductRepository;
import com.kz.sme_management.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService
{
    private final ProductRepository productRepository;

    @Override
    public List<ListProductDto> findAll()
    {

        return productRepository.findAll().stream().map(ListProductDto::new).collect(Collectors.toList());
    }
}
