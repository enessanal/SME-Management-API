package com.kz.sme_management.service.product.impl;

import com.kz.sme_management.dto.product.ListProductDto;
import com.kz.sme_management.exception.NotFoundException;
import com.kz.sme_management.model.customer.Customer;
import com.kz.sme_management.model.product.Product;
import com.kz.sme_management.model.util.Paging;
import com.kz.sme_management.repository.product.ProductRepository;
import com.kz.sme_management.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService
{
    private final ProductRepository productRepository;

    @Override
    public Page<ListProductDto> findAll(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction)
    {
        Paging paging = new Paging(new int[]{10, 25, 50, 100}, new String[]{"createdTime","updateTime","code","id","name", "listPrice", "purchasePrice"});
        Pageable pageable = paging.getPageable(page, size, sortBy, direction);

//            "cashPrice": 3200.00,
//            "limitPrice": 4600.00,
//            "lastPrice": 3000.00,
//            "ccPrice": 3400.00

        return productRepository.findAll(pageable).map(ListProductDto::new);

    }



    @Override
    public Product findById(String id)
    {
        return productRepository.findById(id).orElseThrow( () -> new NotFoundException("Invalid product id"));
    }
}
