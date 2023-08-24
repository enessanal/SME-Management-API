package com.kz.sme_management.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kz.sme_management.model.util.BaseEntity;
import lombok.*;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="brands")
@ToString(callSuper = true)
@RequiredArgsConstructor
public class Brand extends BaseEntity
{
    @Getter @Setter @NonNull
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



    public <T extends Number> Brand(String name, T listDiscountRate, T profitRate, T profitMinRate, T profitMaxRate, T ccRate)
    {
        this.name = name;

        this.listDiscountRate = BigDecimal.valueOf(listDiscountRate.doubleValue());
        this.profitRate = BigDecimal.valueOf(profitRate.doubleValue());
        this.profitMinRate = BigDecimal.valueOf(profitMinRate.doubleValue());
        this.profitMaxRate = BigDecimal.valueOf(profitMaxRate.doubleValue());
        this.ccRate = BigDecimal.valueOf(ccRate.doubleValue());
    }







    @Getter @Setter
    @ToString.Exclude
    @JsonBackReference
    @OneToMany(mappedBy="brand")
    private List<Product> products;
}
