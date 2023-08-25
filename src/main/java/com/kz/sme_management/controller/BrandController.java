package com.kz.sme_management.controller;

import com.kz.sme_management.dto.product.UpdateBrandDto;
import com.kz.sme_management.model.product.Brand;
import com.kz.sme_management.service.product.impl.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${PATH_BRANDS}")
@Tag(name = "Brands", description = "Brand and Price Rates Management APIs")
public class BrandController
{
    private final BrandService brandService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get brands")
    public List<Brand> getBrands()
    {
        return brandService.findAll();
    }


    @PutMapping(path="/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update brand by id")
    public Brand updateBrand(@PathVariable String id, @Valid @RequestBody UpdateBrandDto updateBrandDto)
    {
        return brandService.updateBrand(id, updateBrandDto);
    }




}
