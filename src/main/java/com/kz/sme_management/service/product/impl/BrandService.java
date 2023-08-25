package com.kz.sme_management.service.product.impl;

import com.kz.sme_management.dto.product.UpdateBrandDto;
import com.kz.sme_management.exception.ConflictException;
import com.kz.sme_management.exception.NotFoundException;
import com.kz.sme_management.model.product.Brand;
import com.kz.sme_management.repository.product.BrandRepository;
import com.kz.sme_management.service.product.IBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public Brand updateBrand(String id, UpdateBrandDto updateBrandDto)
    {
        Brand brand = brandRepository.findById(id).orElseThrow( () -> new NotFoundException("Invalid brand id"));

        if(!brand.getName().equals(updateBrandDto.getName()))
        {
            if(brandRepository.findByName(updateBrandDto.getName()).isPresent())
                throw new ConflictException("Brand name must be unique");
        }

        brand.setName(updateBrandDto.getName());
        brand.setListDiscountRate(updateBrandDto.getListDiscountRate());
        brand.setProfitRate(updateBrandDto.getProfitRate());
        brand.setProfitMaxRate(updateBrandDto.getProfitMaxRate());
        brand.setProfitMinRate(updateBrandDto.getProfitMinRate());
        brand.setCcRate(updateBrandDto.getCcRate());

        return brandRepository.save(brand);


    }
}
