package com.kz.sme_management.service.product.impl;

import com.kz.sme_management.model.product.Brand;
import com.kz.sme_management.repository.product.BrandRepository;
import com.kz.sme_management.service.product.IBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService implements IBrandService
{
    private final BrandRepository brandRepository;


    @Override
    public List<Brand> findAll()
    {
        return brandRepository.findAll();
    }
}
