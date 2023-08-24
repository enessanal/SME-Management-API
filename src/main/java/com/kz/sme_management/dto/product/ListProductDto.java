package com.kz.sme_management.dto.product;

import com.kz.sme_management.model.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ListProductDto
{
    private String id;
    private String code;
    private String name;
    private String color;
    private Integer stock;

    private String brand;
    private String category;
    private String type;
    private String size;

    private BigDecimal listPrice;
    private BigDecimal purchasePrice;
    private BigDecimal cashPrice;
    private BigDecimal limitPrice;
    private BigDecimal lastPrice;
    private BigDecimal ccPrice;


    public ListProductDto(Product product)
    {
        this.id = product.getId();
        this.code = product.getCode();
        this.name = product.getName();
        this.color = product.getColor();
        this.stock = product.getStock();

        this.brand = product.getBrand().getName();
        this.category = product.getCategory().getName();
        this.type = product.getType().getName();

        this.size = product.getSize()!=null ? product.getSize().getName():"";

        this.listPrice = product.getListPrice();
        this.purchasePrice = product.getPurchasePrice();
        this.cashPrice = product.getCashPrice();
        this.limitPrice = product.getLimitPrice();
        this.lastPrice = product.getLastPrice();
        this.ccPrice = product.getCcPrice();
    }
}
