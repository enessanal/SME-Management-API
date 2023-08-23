package com.kz.sme_management.controller;

import com.kz.sme_management.dto.customer.ListCustomerDto;
import com.kz.sme_management.model.product.Product;
import com.kz.sme_management.service.product.impl.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Product> getProducts()
    {
        return productService.findAll();
    }






}
