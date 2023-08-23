package com.kz.sme_management.model.product;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kz.sme_management.model.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@NoArgsConstructor
@Table(name="products")
@ToString(callSuper = true)
public class Product extends BaseEntity
{
    @Getter @Setter
    @Column(name="code", nullable = false, unique = true)
    private String code;

    @Getter @Setter
    @Column(name="name", nullable = false)
    private String name;

    @Getter @Setter
    @Column(name="color")
    private String color;

    @Getter @Setter
    @Column(name="stock")
    private Integer stock;

    /*
    * PrintSize: ENUM
    * */

    @Getter @Setter
    @Column(name="list_price", nullable = false)
    private BigDecimal listPrice;


    @Getter
    @Column(name="purchase_price")
    private BigDecimal purchasePrice;

    @Getter
    @Column(name="cash_price")
    private BigDecimal cashPrice;

    @Getter
    @Column(name="last_price")
    private BigDecimal lastPrice;

    @Getter
    @Column(name="limit_price")
    private BigDecimal limitPrice;

    @Getter
    @Column(name="cc_price")
    private BigDecimal ccPrice;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name="brand_id", nullable = false)
    @JsonBackReference
    private Brand brand;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    @JsonBackReference
    private Category category;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name="type_id", nullable = false)
    @JsonBackReference
    private Type type;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name="size_id", nullable = false)
    @JsonBackReference
    private Size size;



    @PrePersist
    @PreUpdate
    public void calculatePrices()
    {
        BigDecimal purchaseFactor = BigDecimal.valueOf(100).subtract(brand.getListDiscountRate()).divide(BigDecimal.valueOf(100));
        this.purchasePrice = customRound(this.listPrice.multiply(purchaseFactor));

        BigDecimal profitFactor =  brand.getProfitRate().divide(BigDecimal.valueOf(100)).add(BigDecimal.valueOf(1));
        this.cashPrice = customRound(this.purchasePrice.multiply(profitFactor));

        BigDecimal minFactor =  brand.getProfitMinRate().divide(BigDecimal.valueOf(100)).add(BigDecimal.valueOf(1));
        this.lastPrice = customRound(this.purchasePrice.multiply(minFactor));


        BigDecimal maxFactor =  brand.getProfitMaxRate().divide(BigDecimal.valueOf(100)).add(BigDecimal.valueOf(1));
        this.limitPrice = customRound(this.purchasePrice.multiply(maxFactor));

        // ! CASH_PRICE x ccFactor
        BigDecimal ccFactor =  brand.getCcRate().divide(BigDecimal.valueOf(100)).add(BigDecimal.valueOf(1));
        this.ccPrice = customRound(this.cashPrice.multiply(ccFactor));
    }


    private BigDecimal customRound(BigDecimal number)
    {
        if (number.compareTo(new BigDecimal("2000")) > 0)
        {
            return number.divide(new BigDecimal("100"), 0, RoundingMode.HALF_UP).multiply(new BigDecimal("100"));
        }
        else if (number.compareTo(new BigDecimal("100")) > 0)
        {
            return number.divide(new BigDecimal("10"), 0, RoundingMode.HALF_UP).multiply(new BigDecimal("10"));
        }
        else if (number.compareTo(BigDecimal.ZERO) > 0)
        {
            return number.setScale(0, RoundingMode.HALF_UP);
        }
        else
        {
            return BigDecimal.ZERO;
        }
    }

}
