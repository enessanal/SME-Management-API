package com.kz.sme_management.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter @Setter
public class UpdateBrandDto
{
    @Size(min = 3, max=20, message = "Brand name must be 3 - 30 characters")
    @NotBlank
    private String name;

    @NotNull
    private BigDecimal listDiscountRate;

    @NotNull
    private BigDecimal profitRate;

    @NotNull
    private BigDecimal profitMinRate;

    @NotNull
    private BigDecimal profitMaxRate;

    @NotNull
    private BigDecimal ccRate;
}
