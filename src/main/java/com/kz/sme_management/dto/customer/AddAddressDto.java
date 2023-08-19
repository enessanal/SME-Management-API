package com.kz.sme_management.dto.customer;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class AddAddressDto
{
    private String name;
    private String city;
    private String district;
    private String details;
}