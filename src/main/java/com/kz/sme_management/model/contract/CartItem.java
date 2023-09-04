package com.kz.sme_management.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kz.sme_management.model.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CartItem {

    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String category;
    private String code;
    private String name;
    private String type;
    private String grup;
    private String size;
    private String color;
    private int count;
    private Double price;
    private Date deliveryDate;

    @ManyToOne
    private Product referenceProduct;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    @JsonBackReference
    private Contract contract;


}
