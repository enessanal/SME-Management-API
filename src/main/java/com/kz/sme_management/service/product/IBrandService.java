package com.kz.sme_management.service.product;

import com.kz.sme_management.dto.product.UpdateBrandDto;
import com.kz.sme_management.model.product.Brand;
import java.util.List;

public interface IBrandService
{
    List<Brand> findAll();
    Brand updateBrand(String id, UpdateBrandDto updateBrandDto);
}
