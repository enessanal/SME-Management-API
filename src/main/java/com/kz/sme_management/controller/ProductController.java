package com.kz.sme_management.controller;

import com.kz.sme_management.dto.customer.ListCustomerDto;
import com.kz.sme_management.dto.product.ListProductDto;
import com.kz.sme_management.model.customer.Customer;
import com.kz.sme_management.model.product.Product;
import com.kz.sme_management.service.product.impl.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("${PATH_PRODUCTS}")
@Tag(name = "Products", description = "Product Management APIs")
public class ProductController
{
    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get products")
    public Page<ListProductDto> getProducts(Optional<Integer> page, Optional<Integer> size, Optional<String> sortBy, Optional<String> direction)
    {
        return productService.findAll(page,size,sortBy,direction);
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get a Product by id")
    public Product getProductById(@PathVariable String id)
    {
        return productService.findById(id);
    }






}
