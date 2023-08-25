package com.kz.sme_management.dto.product;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter @Setter
public class UpdateBrandDto
{
    @NotNull
    @Size(min = 3, max=20, message = "Brand name must be 3 - 30 characters")
    private String name;

    @NotNull
    @Min(-1000)
    @Max(100)
    private BigDecimal listDiscountRate;

    @NotNull
    @Min(-1000)
    @Max(100)
    private BigDecimal profitRate;

    @NotNull
    @Min(-1000)
    @Max(100)
    private BigDecimal profitMinRate;

    @NotNull
    @Min(-1000)
    @Max(100)
    private BigDecimal profitMaxRate;

    @NotNull
    @Min(-1000)
    @Max(100)
    private BigDecimal ccRate;
}
