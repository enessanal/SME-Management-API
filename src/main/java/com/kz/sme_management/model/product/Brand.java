package com.kz.sme_management.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kz.sme_management.model.util.BaseEntity;
import lombok.*;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="brands")
@ToString(callSuper = true)
public class Brand extends BaseEntity
{
    @Getter @Setter
    @Column(name="name", nullable = false, unique = true)
    private String name;

    @Getter @Setter
    @Column(name="list_discount_rate", nullable = false)
    private BigDecimal listDiscountRate;

    @Getter @Setter
    @Column(name="profit_rate", nullable = false)
    private BigDecimal profitRate;

    @Getter @Setter
    @Column(name="profit_min_rate", nullable = false)
    private BigDecimal profitMinRate;

    @Getter @Setter
    @Column(name="profit_max_rate", nullable = false)
    private BigDecimal profitMaxRate;

    @Getter @Setter
    @Column(name="profit_cc_rate", nullable = false)
    private BigDecimal ccRate;

    @Getter @Setter
    @ToString.Exclude
//    @JsonManagedReference
    @JsonBackReference
    @OneToMany(mappedBy="brand")
    private List<Product> products;
}
