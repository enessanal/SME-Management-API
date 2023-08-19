package com.kz.sme_management.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class AddressAddDto
{
    private String name;
    private String city;
    private String district;
    private String details;
}