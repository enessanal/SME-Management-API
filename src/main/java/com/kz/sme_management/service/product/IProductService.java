package com.kz.sme_management.service.product;

import com.kz.sme_management.dto.product.ListProductDto;
import com.kz.sme_management.model.product.Product;

import java.util.List;

public interface IProductService
{
    public List<ListProductDto> findAll();
}
